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
 * Title: Account
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
@Entity
@Table(name = "accounts")
public class Account {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer accountId;
   private String firstName;
   private String lastName;
   private String nickName;
   @ManyToOne
   @JoinColumn(name = "state_id")
   private State state;
   @ManyToOne
   @JoinColumn(name = "city_id")
   private City city;
   private LocalDateTime createDatetime;
   private Character active;

   public Account() {
   }

   public Account(Integer accountId, String firstName, String lastName, String nickName, State state, City city,
      LocalDateTime createDatetime, Character active) {
      this.accountId = accountId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.nickName = nickName;
      this.state = state;
      this.city = city;
      this.createDatetime = createDatetime;
      this.active = active;
   }

   public Integer getAccountId() {
      return accountId;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getNickName() {
      return nickName;
   }

   public State getState() {
      return state;
   }

   public City getCity() {
      return city;
   }

   public LocalDateTime getCreateDatetime() {
      return createDatetime;
   }

   public Character getActive() {
      return active;
   }

   public void setAccountId(Integer accountId) {
      this.accountId = accountId;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public void setNickName(String nickName) {
      this.nickName = nickName;
   }

   public void setState(State state) {
      this.state = state;
   }

   public void setCity(City city) {
      this.city = city;
   }

   public void setCreateDatetime(LocalDateTime createDatetime) {
      this.createDatetime = createDatetime;
   }

   public void setActive(Character active) {
      this.active = active;
   }

}
