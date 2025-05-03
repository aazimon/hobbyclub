/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services.domains;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Title: Topic
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 27, 2025
 * @author Gary Deken
 * @version
 */
@Entity
@Table(name = "topics")
public class Topic {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer topicId;
   @ManyToOne
   @JoinColumn(name = "club_id")
   private Club club;
   @ManyToOne
   @JoinColumn(name = "account_id")
   private Account account;
   private String title;
   private String message;
   private LocalDateTime createDatetime;
   @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
   private Set<Reply> replies = new HashSet<>();

   public Topic() {
   }

   public Topic(Integer topicId, Club club, Account account, String title, String message, LocalDateTime createDatetime) {
      this.topicId = topicId;
      this.club = club;
      this.account = account;
      this.title = title;
      this.message = message;
      this.createDatetime = createDatetime;
   }

   public void addReply(Reply reply) {
      replies.add(reply);
   }

   public Integer getTopicId() {
      return topicId;
   }

   public Club getClub() {
      return club;
   }

   public Account getAccount() {
      return account;
   }

   public String getTitle() {
      return title;
   }

   public String getMessage() {
      return message;
   }

   public LocalDateTime getCreateDatetime() {
      return createDatetime;
   }

   public Set<Reply> getReplies() {
      return replies;
   }

   public void setTopicId(Integer topicId) {
      this.topicId = topicId;
   }

   public void setClub(Club club) {
      this.club = club;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public void setCreateDatetime(LocalDateTime createDatetime) {
      this.createDatetime = createDatetime;
   }

   public void setReplies(Set<Reply> replies) {
      this.replies = replies;
   }

}
