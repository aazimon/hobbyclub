/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller.dto;

/**
 * Title: SearchForm
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 18, 2025
 * @author Gary Deken
 * @version
 */
public class SearchForm {
   private String clubName;
   private String categoryId;
   private String stateId;
   private String cityId;

   public SearchForm() {
   }

   public SearchForm(String clubName, String categoryId, String stateId, String cityId) {
      this.clubName = clubName;
      this.categoryId = categoryId;
      this.stateId = stateId;
      this.cityId = cityId;
   }

   public String getClubName() {
      return clubName;
   }

   public String getCategoryId() {
      return categoryId;
   }

   public String getStateId() {
      return stateId;
   }

   public String getCityId() {
      return cityId;
   }

   public void setClubName(String clubName) {
      this.clubName = clubName;
   }

   public void setCategoryId(String categoryId) {
      this.categoryId = categoryId;
   }

   public void setStateId(String stateId) {
      this.stateId = stateId;
   }

   public void setCityId(String cityId) {
      this.cityId = cityId;
   }

}
