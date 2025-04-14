/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * Title: City
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
@Entity
@Table(name = "city")
public class City {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer cityId;
   private String name;
   @ManyToOne
   @JoinColumn(name = "state_id")
   private State state;
   private LocalDateTime createDatetime;

   public City() {
   }

   public City(Integer cityId, String name, State state) {
      this.cityId = cityId;
      this.name = name;
      this.state = state;
   }

   public Integer getCityId() {
      return cityId;
   }

   public String getName() {
      return name;
   }

   public State getState() {
      return state;
   }

   public LocalDateTime getCreateDatetime() {
      return createDatetime;
   }

   public void setCityId(Integer cityId) {
      this.cityId = cityId;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setState(State state) {
      this.state = state;
   }

   public void setCreateDatetime(LocalDateTime createDatetime) {
      this.createDatetime = createDatetime;
   }

}
