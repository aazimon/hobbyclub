/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.abberkeep.hobbyclub.controller.dto.TopicDisplay;
import org.abberkeep.hobbyclub.controller.dto.TopicForm;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Reply;
import org.abberkeep.hobbyclub.services.domains.Topic;
import org.abberkeep.hobbyclub.services.repositories.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Title: TopicService
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 27, 2025
 * @author Gary Deken
 * @version
 */
@Service
public class TopicService {
   private final static Logger log = LoggerFactory.getLogger(TopicService.class);
   private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
   @Autowired
   private TopicRepository topicRepository;
   @Autowired
   private ClubService clubService;

   @Transactional
   public Topic addReplyToTopic(TopicForm topicForm, Account account) {
      Optional<Topic> opt = topicRepository.findById(Integer.valueOf(topicForm.getTopicId()));

      if (opt.isEmpty()) {
         return null;
      }
      Topic topic = opt.get();
      Reply reply = new Reply();

      reply.setMessage(topicForm.getPost());
      reply.setTopic(topic);
      reply.setAccount(account);
      topic.addReply(reply);

      return topicRepository.save(topic);
   }

   @Transactional
   public List<TopicDisplay> getTopicsForClub(Integer clubId) {
      List<Topic> topics = topicRepository.findByClubClubId(clubId);
      List<TopicDisplay> tds = new ArrayList<>();

      topics.forEach(top -> {
         tds.add(mapToTopicDisplay(top));
      });

      return tds;
   }

   @Transactional
   public List<TopicDisplay> getTopicsForUser(Integer accountId, Integer clubId) {
      List<Topic> topics;
      if (clubId > 0) {
         topics = topicRepository.findByAccountAccountIdAndClubClubId(accountId, clubId);
      } else {
         topics = topicRepository.findByAccountAccountId(accountId);
      }
      List<TopicDisplay> tds = new ArrayList<>();

      topics.forEach(top -> tds.add(mapToTopicDisplay(top)));

      return tds;
   }

   @Transactional
   public Topic saveTopic(TopicForm topicForm, Account account) {
      Topic topic = new Topic();

      topic.setTitle(account.getNickName() + "says: ...");
      topic.setMessage(topicForm.getPost());
      topic.setAccount(account);
      topic.setClub(clubService.getClub(Integer.parseInt(topicForm.getClubId())));

      return topicRepository.save(topic);
   }

   private TopicDisplay mapToTopicDisplay(Topic topic) {
      TopicDisplay td = new TopicDisplay();

      td.setTopicId(topic.getTopicId().toString());
      td.setMessage(topic.getMessage());
      td.setPoster(topic.getAccount().getNickName());
      td.setPostDate(formatter.format(topic.getCreateDatetime()));

      List<TopicDisplay> replies = new ArrayList<>();

      for (Reply reply : topic.getReplies()) {
         TopicDisplay rp = new TopicDisplay();

         rp.setTopicId(reply.getReplyId().toString());
         rp.setMessage(reply.getMessage());
         rp.setPoster(reply.getAccount().getNickName());
         rp.setPostDate(formatter.format(reply.getCreateDatetime()));

         replies.add(rp);
      }

      td.setReplies(replies);

      return td;
   }

}
