/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

/**
 * Title: ClubDescription
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 17, 2025
 * @author Gary Deken
 * @version
 */
public class ClubDisplay {
   private String id;
   private String title;
   private String description;

   public ClubDisplay() {
   }

   public ClubDisplay(String id, String title, String description) {
      this.id = id;
      this.title = title;
      this.description = description;
   }

   public String getId() {
      return id;
   }

   public String getTitle() {
      return title;
   }

   public String getDescription() {
      return description;
   }

   public void setId(String id) {
      this.id = id;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public void setDescription(String description) {
      this.description = description;
   }

}
