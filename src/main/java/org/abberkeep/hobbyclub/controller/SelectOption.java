/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

/**
 * Title: SelectOption
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
public class SelectOption {
   private String value;
   private String label;

   public SelectOption(String value, String label) {
      this.value = value;
      this.label = label;
   }

   public String getValue() {
      return value;
   }

   public String getLabel() {
      return label;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public void setLabel(String label) {
      this.label = label;
   }

}
