/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * Title: State
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
@Entity
@Table(name = "state")
public class State {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer stateId;
   private String name;
   private LocalDateTime createDatetime;

   public State() {
   }

   public State(Integer stateId, String name) {
      this.stateId = stateId;
      this.name = name;
   }

   public Integer getStateId() {
      return stateId;
   }

   public String getName() {
      return name;
   }

   public LocalDateTime getCreateDatetime() {
      return createDatetime;
   }

   public void setStateId(Integer stateId) {
      this.stateId = stateId;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setCreateDatetime(LocalDateTime createDatetime) {
      this.createDatetime = createDatetime;
   }

}
