/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller.dto;

/**
 * Title: TopicForm
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 27, 2025
 * @author Gary Deken
 * @version
 */
public class TopicForm {
   private String clubId;
   private String post;
   private String topicId;

   public TopicForm() {
   }

   public TopicForm(String clubId, String post, String topicId) {
      this.clubId = clubId;
      this.post = post;
      this.topicId = topicId;
   }

   public String getClubId() {
      return clubId;
   }

   public String getPost() {
      return post;
   }

   public String getTopicId() {
      return topicId;
   }

   public void setClubId(String clubId) {
      this.clubId = clubId;
   }

   public void setPost(String post) {
      this.post = post;
   }

   public void setTopicId(String topicId) {
      this.topicId = topicId;
   }

}
