/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller.dto;

/**
 * Title: UserFilterForm
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) May 1, 2025
 * @author Gary Deken
 * @version
 */
public class UserFilterForm {
   private String filterEvent;
   private String filterTopic;

   public UserFilterForm() {
   }

   public UserFilterForm(String filterEvent, String filterTopic) {
      this.filterEvent = filterEvent;
      this.filterTopic = filterTopic;
   }

   public String getFilterEvent() {
      return filterEvent;
   }

   public String getFilterTopic() {
      return filterTopic;
   }

   public void setFilterEvent(String filterEvent) {
      this.filterEvent = filterEvent;
   }

   public void setFilterTopic(String filterTopic) {
      this.filterTopic = filterTopic;
   }

}
