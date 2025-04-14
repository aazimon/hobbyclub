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
 * Title: UserInterestId
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 9, 2025
 * @author Gary Deken
 * @version
 */
@Embeddable
public class UserInterestId implements Serializable {
   @Column(name = "account_id")
   private Integer accountId;
   @Column(name = "category_id")
   private Integer categoryId;

   public UserInterestId() {
   }

   public UserInterestId(Integer accountId, Integer categoryId) {
      this.accountId = accountId;
      this.categoryId = categoryId;
   }

   public Integer getAccountId() {
      return accountId;
   }

   public Integer getCategoryId() {
      return categoryId;
   }

   public void setAccountId(Integer accountId) {
      this.accountId = accountId;
   }

   public void setCategoryId(Integer categoryId) {
      this.categoryId = categoryId;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      UserInterestId that = (UserInterestId) obj;
      return Objects.equals(accountId, that.accountId) && Objects.equals(categoryId, that.categoryId);
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 53 * hash + Objects.hashCode(this.accountId);
      hash = 53 * hash + Objects.hashCode(this.categoryId);
      return hash;
   }

}
