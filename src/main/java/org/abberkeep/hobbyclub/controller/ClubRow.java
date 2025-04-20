/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

/**
 * Title: ClubRow
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 17, 2025
 * @author Gary Deken
 * @version
 */
public class ClubRow {
   private ClubDisplay first;
   private ClubDisplay second;

   public ClubRow(ClubDisplay first, ClubDisplay second) {
      this.first = first;
      this.second = second;
   }

   public ClubDisplay getFirst() {
      return first;
   }

   public ClubDisplay getSecond() {
      return second;
   }

   public void setFirst(ClubDisplay first) {
      this.first = first;
   }

   public void setSecond(ClubDisplay second) {
      this.second = second;
   }

}
