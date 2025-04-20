/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.abberkeep.hobbyclub.services.domains;

/**
 * Title: ActiveState
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 17, 2025
 * @author Gary Deken
 * @version
 */
public enum Status {
   ACTIVE('A'), DELETED('D');

   private Character state;

   private Status(Character state) {
      this.state = state;
   }

   public Character getState() {
      return state;
   }

}
