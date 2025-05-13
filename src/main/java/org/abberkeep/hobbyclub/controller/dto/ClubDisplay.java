/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller.dto;

/**
 * Title: ClubDescription
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 17, 2025
 * @author Gary Deken
 * @version
 */
public class ClubDisplay {
   private String id;
   private String title;
   private String description;
   private boolean eventSelected = false;
   private boolean topicSelected = false;

   public ClubDisplay() {
   }

   public ClubDisplay(String id, String title, String description) {
      this.id = id;
      this.title = title;
      this.description = description;
   }

   public String getId() {
      return id;
   }

   public String getTitle() {
      return title;
   }

   public String getDescription() {
      return description;
   }

   public boolean getEventSelected() {
      return eventSelected;
   }

   public boolean getTopicSelected() {
      return topicSelected;
   }

   public void setId(String id) {
      this.id = id;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public void setEventSelected(boolean eventSelected) {
      this.eventSelected = eventSelected;
   }

   public void setTopicSelected(boolean topicSelected) {
      this.topicSelected = topicSelected;
   }

}
