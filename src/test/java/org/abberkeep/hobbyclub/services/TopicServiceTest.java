/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.abberkeep.hobbyclub.controller.dto.TopicDisplay;
import org.abberkeep.hobbyclub.controller.dto.TopicForm;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Reply;
import org.abberkeep.hobbyclub.services.domains.Topic;
import org.abberkeep.hobbyclub.services.repositories.TopicRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Gary Deken
 */
@ExtendWith(MockitoExtension.class)
public class TopicServiceTest extends TestBaseService {
   @Mock
   private TopicRepository topicRepository;
   @Mock
   private ClubService clubService;
   @InjectMocks
   private TopicService underTest;

   @Test
   public void testAddReplyToTopic() {
      Account account = buildAccount(10);
      Topic top = buildTopic(null, 10, 23, 0);
      when(topicRepository.findById(89)).thenReturn(Optional.of(top));
      when(topicRepository.save(any())).thenAnswer(invoc -> {
         Topic tp = invoc.getArgument(0);

         tp.setTopicId(54);
         assertEquals(1, tp.getReplies().size());

         return tp;
      });

      Topic topic = underTest.addReplyToTopic(buildTopicForm("23", "89"), account);

      assertEquals(54, topic.getTopicId());
   }

   @Test
   public void testGetTopicsForClub() {
      List<Topic> tps = new ArrayList<>();

      tps.add(buildTopic(100, 10, 23, 0));
      tps.add(buildTopic(101, 11, 23, 3));
      when(topicRepository.findByClubClubId(23)).thenReturn(tps);

      List<TopicDisplay> actual = underTest.getTopicsForClub(23);

      assertEquals(2, actual.size());
      TopicDisplay actualTD = actual.get(0);
      assertEquals(0, actualTD.getReplies().size());
      actualTD = actual.get(1);
      assertEquals(3, actualTD.getReplies().size());
   }

   @Test
   public void testGetTopicsForUser() {
      List<Topic> tps = new ArrayList<>();

      tps.add(buildTopic(100, 10, 23, 0));
      tps.add(buildTopic(101, 10, 23, 3));
      when(topicRepository.findByAccountAccountId(10)).thenReturn(tps);

      List<TopicDisplay> actual = underTest.getTopicsForUser(10);

      assertEquals(2, actual.size());
      TopicDisplay actualTD = actual.get(0);
      assertEquals(0, actualTD.getReplies().size());
      actualTD = actual.get(1);
      assertEquals(3, actualTD.getReplies().size());
   }

   @Test
   public void testSaveTopic() {
      Account account = buildAccount(10);
      when(clubService.getClub(23)).thenReturn(buildClub(23, "Club 23"));
      when(topicRepository.save(any())).thenAnswer(invoc -> {
         Topic tp = invoc.getArgument(0);

         tp.setTopicId(54);
         assertEquals(23, tp.getClub().getClubId());
         assertEquals(10, tp.getAccount().getAccountId());
         assertEquals(0, tp.getReplies().size());

         return tp;
      });

      Topic topic = underTest.saveTopic(buildTopicForm("23", null), account);

      assertEquals(54, topic.getTopicId());
   }

   private TopicForm buildTopicForm(String clubId, String topicId) {
      TopicForm tf = new TopicForm();

      tf.setClubId(clubId);
      tf.setPost("Message on Topic");
      tf.setTopicId(topicId);

      return tf;
   }

   private Topic buildTopic(Integer topicId, int accountId, int clubId, int numberReplies) {
      Topic tp = new Topic();

      tp.setTopicId(topicId);
      tp.setAccount(buildAccount(accountId));
      tp.setClub(buildClub(clubId, "Club" + clubId));
      tp.setMessage("Message of Topic");
      tp.setCreateDatetime(LocalDateTime.parse("2025/04/14 19:19", formatter));
      for (int i = 0; i < numberReplies; i++) {
         tp.addReply(buildReply(tp));
      }

      return tp;
   }

   private Reply buildReply(Topic tp) {
      Reply rp = new Reply();

      rp.setReplyId(tp.getTopicId() + 1);
      rp.setAccount(buildAccount(5));
      rp.setTopic(tp);
      rp.setMessage("Replay to Topic");
      rp.setCreateDatetime(LocalDateTime.parse("2025/04/14 19:20", formatter));

      return rp;
   }

}
