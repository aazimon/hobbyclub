/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * Title: Reply
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 27, 2025
 * @author Gary Deken
 * @version
 */
@Entity
@Table(name = "replies")
public class Reply {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer replyId;
   @ManyToOne
   @JoinColumn(name = "topic_id")
   private Topic topic;
   @ManyToOne
   @JoinColumn(name = "account_id")
   private Account account;
   private String message;
   private LocalDateTime createDatetime;

   public Reply() {
   }

   public Reply(Integer replyId, Topic topic, Account account, String message, LocalDateTime createDatetime) {
      this.replyId = replyId;
      this.topic = topic;
      this.account = account;
      this.message = message;
      this.createDatetime = createDatetime;
   }

   public Integer getReplyId() {
      return replyId;
   }

   public Topic getTopic() {
      return topic;
   }

   public Account getAccount() {
      return account;
   }

   public String getMessage() {
      return message;
   }

   public LocalDateTime getCreateDatetime() {
      return createDatetime;
   }

   public void setReplyId(Integer replyId) {
      this.replyId = replyId;
   }

   public void setTopic(Topic topic) {
      this.topic = topic;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public void setCreateDatetime(LocalDateTime createDatetime) {
      this.createDatetime = createDatetime;
   }

}
