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
 * Title: UserInterest
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 9, 2025
 * @author Gary Deken
 * @version
 */
@Entity
@Table(name = "userinterest")
public class UserInterest {
   @EmbeddedId
   private UserInterestId id = new UserInterestId();
   @ManyToOne
   @MapsId("accountId")
   @JoinColumn(name = "account_id")
   private Account account;
   @ManyToOne
   @MapsId("categoryId")
   @JoinColumn(name = "category_id")
   private Category category;
   @Column(name = "create_datetime")
   private LocalDateTime createDatetime;

   public UserInterest() {
   }

   public UserInterest(Account account, Category category) {
      this.account = account;
      this.category = category;
   }

   public Account getAccount() {
      return account;
   }

   public Category getCategory() {
      return category;
   }

   public LocalDateTime getCreateDatetime() {
      return createDatetime;
   }

   public UserInterestId getId() {
      return id;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public void setCreateDatetime(LocalDateTime createDatetime) {
      this.createDatetime = createDatetime;
   }

   public void setId(UserInterestId id) {
      this.id = id;
   }

}
