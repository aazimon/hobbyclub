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
 * Title: Category
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 6, 2025
 * @author Gary Deken
 * @version
 */
@Entity
@Table(name = "categories")
public class Category {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer CategoryId;
   private String name;
   private LocalDateTime createDatetime;

   public Category() {
   }

   public Category(Integer CategoryId, String name) {
      this.CategoryId = CategoryId;
      this.name = name;
   }

   public Integer getCategoryId() {
      return CategoryId;
   }

   public String getName() {
      return name;
   }

   public LocalDateTime getCreateDatetime() {
      return createDatetime;
   }

   public void setCategoryId(Integer CategoryId) {
      this.CategoryId = CategoryId;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setCreateDatetime(LocalDateTime createDatetime) {
      this.createDatetime = createDatetime;
   }

}
