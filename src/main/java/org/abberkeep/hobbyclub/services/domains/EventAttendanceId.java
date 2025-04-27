/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Title: EventAttendanceId
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 22, 2025
 * @author Gary Deken
 * @version
 */
@Embeddable
public class EventAttendanceId implements Serializable {
   @Column(name = "event_id")
   private Integer eventId;
   @Column(name = "account_id")
   private Integer accountId;

   public EventAttendanceId() {
   }

   public EventAttendanceId(Integer eventId, Integer accountId) {
      this.eventId = eventId;
      this.accountId = accountId;
   }

   public Integer getEventId() {
      return eventId;
   }

   public Integer getAccountId() {
      return accountId;
   }

   public void setEventId(Integer eventId) {
      this.eventId = eventId;
   }

   public void setAccountId(Integer accountId) {
      this.accountId = accountId;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      EventAttendanceId that = (EventAttendanceId) obj;
      return Objects.equals(accountId, that.accountId) && Objects.equals(eventId, that.eventId);
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 53 * hash + Objects.hashCode(this.accountId);
      hash = 53 * hash + Objects.hashCode(this.eventId);
      return hash;
   }

}
