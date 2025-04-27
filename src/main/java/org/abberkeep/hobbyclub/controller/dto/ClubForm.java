/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller.dto;

/**
 * Title: ClubForm
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 14, 2025
 * @author Gary Deken
 * @version
 */
public class ClubForm {
   private String title;
   private String category;
   private String description;

   public ClubForm() {
   }

   public ClubForm(String title, String category, String description) {
      this.title = title;
      this.category = category;
      this.description = description;
   }

   public String getTitle() {
      return title;
   }

   public String getCategory() {
      return category;
   }

   public String getDescription() {
      return description;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public void setDescription(String description) {
      this.description = description;
   }

}
