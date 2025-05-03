/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller.dto;

import java.util.List;

/**
 * Title: TopicDisplay
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 27, 2025
 * @author Gary Deken
 * @version
 */
public class TopicDisplay {
   private String topicId;
   private String message;
   private String poster;
   private String postDate;
   private List<TopicDisplay> replies;

   public TopicDisplay() {
   }

   public TopicDisplay(String topicId, String message, String poster, String postDate, List<TopicDisplay> replies) {
      this.topicId = topicId;
      this.message = message;
      this.poster = poster;
      this.postDate = postDate;
      this.replies = replies;
   }

   public String getTopicId() {
      return topicId;
   }

   public String getMessage() {
      return message;
   }

   public String getPoster() {
      return poster;
   }

   public String getPostDate() {
      return postDate;
   }

   public List<TopicDisplay> getReplies() {
      return replies;
   }

   public void setTopicId(String topicId) {
      this.topicId = topicId;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public void setPoster(String poster) {
      this.poster = poster;
   }

   public void setPostDate(String postDate) {
      this.postDate = postDate;
   }

   public void setReplies(List<TopicDisplay> replies) {
      this.replies = replies;
   }

}
