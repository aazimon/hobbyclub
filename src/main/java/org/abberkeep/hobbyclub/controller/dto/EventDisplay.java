/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller.dto;

/**
 * Title: EventDisplay
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 25, 2025
 * @author Gary Deken
 * @version
 */
public class EventDisplay {
   private String id;
   private String title;
   private String details;
   private String dateTime;
   private String organizer;
   private String location;
   private String willAttend;
   private String mayAttend;
   private String interested;
   private String none;
   private String clubId;
   private String clubTitle;
   private String ownEvent;

   public EventDisplay() {
   }

   public EventDisplay(String id, String title, String details, String dateTime, String organizer, String location,
      String willAttend, String mayAttend, String interested, String none, String clubId, String clubTitle) {
      this.id = id;
      this.title = title;
      this.details = details;
      this.dateTime = dateTime;
      this.organizer = organizer;
      this.location = location;
      this.willAttend = willAttend;
      this.mayAttend = mayAttend;
      this.interested = interested;
      this.none = none;
      this.clubId = clubId;
      this.clubTitle = clubTitle;
   }

   public String getId() {
      return id;
   }

   public String getTitle() {
      return title;
   }

   public String getDetails() {
      return details;
   }

   public String getDateTime() {
      return dateTime;
   }

   public String getOrganizer() {
      return organizer;
   }

   public String getLocation() {
      return location;
   }

   public String getWillAttend() {
      return willAttend;
   }

   public String getMayAttend() {
      return mayAttend;
   }

   public String getInterested() {
      return interested;
   }

   public String getNone() {
      return none;
   }

   public String getClubId() {
      return clubId;
   }

   public String getClubTitle() {
      return clubTitle;
   }

   public String getOwnEvent() {
      return ownEvent;
   }

   public void setId(String id) {
      this.id = id;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public void setDetails(String details) {
      this.details = details;
   }

   public void setDateTime(String dateTime) {
      this.dateTime = dateTime;
   }

   public void setOrganizer(String organizer) {
      this.organizer = organizer;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public void setWillAttend(String willAttend) {
      this.willAttend = willAttend;
   }

   public void setMayAttend(String mayAttend) {
      this.mayAttend = mayAttend;
   }

   public void setInterested(String interested) {
      this.interested = interested;
   }

   public void setNone(String none) {
      this.none = none;
   }

   public void setClubId(String clubId) {
      this.clubId = clubId;
   }

   public void setClubTitle(String clubTitle) {
      this.clubTitle = clubTitle;
   }

   public void setOwnEvent(String ownEvent) {
      this.ownEvent = ownEvent;
   }

}
