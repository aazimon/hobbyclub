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

/**
 * Title: UserClub
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 16, 2025
 * @author Gary Deken
 * @version
 */
@Entity
@Table(name = "userclubs")
public class UserClub {
   @EmbeddedId
   private UserClubId id = new UserClubId();
   @ManyToOne
   @MapsId("accountId")
   @JoinColumn(name = "account_id")
   private Account account;
   @ManyToOne
   @MapsId("clubId")
   @JoinColumn(name = "club_id")
   private Club club;
   @Column(name = "create_datetime")
   private LocalDateTime createDatetime;
   private Character active;

   public UserClub() {
   }

   public UserClub(Account account, Club club, LocalDateTime createDatetime, Character active) {
      this.account = account;
      this.club = club;
      this.createDatetime = createDatetime;
      this.active = active;
   }

   public UserClubId getId() {
      return id;
   }

   public Account getAccount() {
      return account;
   }

   public Club getClub() {
      return club;
   }

   public LocalDateTime getCreateDatetime() {
      return createDatetime;
   }

   public Character getActive() {
      return active;
   }

   public void setId(UserClubId id) {
      this.id = id;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   public void setClub(Club club) {
      this.club = club;
   }

   public void setCreateDatetime(LocalDateTime createDatetime) {
      this.createDatetime = createDatetime;
   }

   public void setActive(Character active) {
      this.active = active;
   }

}
