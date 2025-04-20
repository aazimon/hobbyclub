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
 * Title: Club
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 14, 2025
 * @author Gary Deken
 * @version
 */
@Entity
@Table(name = "clubs")
public class Club {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer clubId;
   private String name;
   private String description;
   @ManyToOne
   @JoinColumn(name = "city_id")
   private City city;
   @ManyToOne
   @JoinColumn(name = "state_id")
   private State state;
   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;
   @ManyToOne
   @JoinColumn(name = "creator_id")
   private Account account;
   private LocalDateTime createDatetime;
   private Character active;

   public Club() {
   }

   public Club(Integer clubId, String name, String description, City city, State state, Category category,
      Account account, LocalDateTime createDatetime, Character active) {
      this.clubId = clubId;
      this.name = name;
      this.description = description;
      this.city = city;
      this.state = state;
      this.category = category;
      this.account = account;
      this.createDatetime = createDatetime;
      this.active = active;
   }

   public Integer getClubId() {
      return clubId;
   }

   public String getName() {
      return name;
   }

   public String getDescription() {
      return description;
   }

   public City getCity() {
      return city;
   }

   public State getState() {
      return state;
   }

   public Category getCategory() {
      return category;
   }

   public Account getAccount() {
      return account;
   }

   public LocalDateTime getCreateDatetime() {
      return createDatetime;
   }

   public Character getActive() {
      return active;
   }

   public void setClubId(Integer clubId) {
      this.clubId = clubId;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public void setCity(City city) {
      this.city = city;
   }

   public void setState(State state) {
      this.state = state;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   public void setCreateDatetime(LocalDateTime createDatetime) {
      this.createDatetime = createDatetime;
   }

   public void setActive(Character active) {
      this.active = active;
   }

}
