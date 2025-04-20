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
 * Title: UserClubId
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 16, 2025
 * @author Gary Deken
 * @version
 */
@Embeddable
public class UserClubId implements Serializable {
   @Column(name = "account_id")
   private Integer accountId;
   @Column(name = "club_id")
   private Integer clubId;

   public UserClubId() {
   }

   public UserClubId(Integer accountId, Integer clubId) {
      this.accountId = accountId;
      this.clubId = clubId;
   }

   public Integer getAccountId() {
      return accountId;
   }

   public Integer getClubId() {
      return clubId;
   }

   public void setAccountId(Integer accountId) {
      this.accountId = accountId;
   }

   public void setClubId(Integer clubId) {
      this.clubId = clubId;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      UserClubId that = (UserClubId) obj;
      return Objects.equals(accountId, that.accountId) && Objects.equals(clubId, that.clubId);
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 53 * hash + Objects.hashCode(this.accountId);
      hash = 53 * hash + Objects.hashCode(this.clubId);
      return hash;
   }

}
