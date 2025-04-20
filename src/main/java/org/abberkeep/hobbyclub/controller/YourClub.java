/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

/**
 * Title: YourClub
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 15, 2025
 * @author Gary Deken
 * @version
 */
public class YourClub {
   private String name;
   private String id;

   public YourClub(String name, String id) {
      this.name = name;
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public String getId() {
      return id;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setId(String id) {
      this.id = id;
   }

}
