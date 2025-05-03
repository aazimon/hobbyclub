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
 * Title: Event
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 22, 2025
 * @author Gary Deken
 * @version
 */
@Entity
@Table(name = "events")
public class Event {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer eventId;
   private String title;
   private String details;
   private LocalDateTime datetime;
   @ManyToOne
   @JoinColumn(name = "account_id")
   private Account account;
   @ManyToOne
   @JoinColumn(name = "city_id")
   private City city;
   @ManyToOne
   @JoinColumn(name = "state_id")
   private State state;
   @ManyToOne
   @JoinColumn(name = "club_id")
   private Club club;
   private LocalDateTime createDatetime;
   @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
   private Set<EventAttendance> eventAttendances = new HashSet<>();

   public Event() {
   }

   public Event(Integer eventId, String title, String details, LocalDateTime datetime, Account account, City city,
      State state, LocalDateTime createDatetime, Club club) {
      this.eventId = eventId;
      this.title = title;
      this.details = details;
      this.datetime = datetime;
      this.account = account;
      this.city = city;
      this.state = state;
      this.createDatetime = createDatetime;
      this.club = club;
   }

   public void addAttendance(EventAttendance attendance) {
      eventAttendances.add(attendance);
   }

   public Integer getEventId() {
      return eventId;
   }

   public String getTitle() {
      return title;
   }

   public String getDetails() {
      return details;
   }

   public LocalDateTime getDatetime() {
      return datetime;
   }

   public Account getAccount() {
      return account;
   }

   public City getCity() {
      return city;
   }

   public Club getClub() {
      return club;
   }

   public State getState() {
      return state;
   }

   public LocalDateTime getCreateDatetime() {
      return createDatetime;
   }

   public Set<EventAttendance> getEventAttendances() {
      return eventAttendances;
   }

   public void setEventId(Integer eventId) {
      this.eventId = eventId;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public void setDetails(String details) {
      this.details = details;
   }

   public void setDatetime(LocalDateTime datetime) {
      this.datetime = datetime;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   public void setCity(City city) {
      this.city = city;
   }

   public void setClub(Club club) {
      this.club = club;
   }

   public void setState(State state) {
      this.state = state;
   }

   public void setCreateDatetime(LocalDateTime createDatetime) {
      this.createDatetime = createDatetime;
   }

   public void setEventAttendances(Set<EventAttendance> eventAttendances) {
      this.eventAttendances = eventAttendances;
   }

}
