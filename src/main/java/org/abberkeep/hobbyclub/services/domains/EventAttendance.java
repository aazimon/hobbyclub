/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services.domains;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Title: EventAttendance
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 22, 2025
 * @author Gary Deken
 * @version
 */
@Entity
@Table(name = "eventattendance")
public class EventAttendance {
   public static final String WILL_ATTEND = "WA";
   public static final String MAY_ATTEND = "MA";
   public static final String INTERESTED = "IE";
   public static final String NOT_INTERESTED = "NI";
   public static final Set<String> VALID_ATTENDANCE = Set.of(WILL_ATTEND, MAY_ATTEND, INTERESTED, NOT_INTERESTED);
   @EmbeddedId
   private EventAttendanceId id = new EventAttendanceId();
   @ManyToOne
   @MapsId("accountId")
   @JoinColumn(name = "account_id")
   private Account account;
   @ManyToOne
   @MapsId("eventId")
   @JoinColumn(name = "event_id")
   private Event event;
   private String attending;
   @Column(name = "create_datetime")
   private LocalDateTime createDatetime;

   public EventAttendance() {
   }

   public EventAttendance(Account account, Event event, String attending) {
      this.account = account;
      this.event = event;
      this.attending = attending;
   }

   public Account getAccount() {
      return account;
   }

   public Event getEvent() {
      return event;
   }

   public String getAttending() {
      return attending;
   }

   public LocalDateTime getCreateDatetime() {
      return createDatetime;
   }

   public EventAttendanceId getId() {
      return id;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   public void setEvent(Event event) {
      this.event = event;
   }

   public void setAttending(String attending) {
      this.attending = attending;
   }

   public void setCreateDatetime(LocalDateTime createDatetime) {
      this.createDatetime = createDatetime;
   }

   public void setId(EventAttendanceId id) {
      this.id = id;
   }

}
