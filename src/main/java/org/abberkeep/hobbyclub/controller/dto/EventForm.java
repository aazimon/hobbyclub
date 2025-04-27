/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller.dto;

/**
 * Title: EventForm
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 24, 2025
 * @author Gary Deken
 * @version
 */
public class EventForm {
   private String newEventTitle;
   private String newEventDetails;
   private String newEventDate;
   private String stateId;
   private String cityId;

   public EventForm() {
   }

   public EventForm(String newEventTitle, String newEventDetails, String newEventDate, String stateId, String cityId) {
      this.newEventTitle = newEventTitle;
      this.newEventDetails = newEventDetails;
      this.newEventDate = newEventDate;
      this.stateId = stateId;
      this.cityId = cityId;
   }

   public String getNewEventTitle() {
      return newEventTitle;
   }

   public String getNewEventDetails() {
      return newEventDetails;
   }

   public String getNewEventDate() {
      return newEventDate;
   }

   public String getStateId() {
      return stateId;
   }

   public String getCityId() {
      return cityId;
   }

   public void setNewEventTitle(String newEventTitle) {
      this.newEventTitle = newEventTitle;
   }

   public void setNewEventDetails(String newEventDetails) {
      this.newEventDetails = newEventDetails;
   }

   public void setNewEventDate(String newEventDate) {
      this.newEventDate = newEventDate;
   }

   public void setStateId(String stateId) {
      this.stateId = stateId;
   }

   public void setCityId(String cityId) {
      this.cityId = cityId;
   }

}
