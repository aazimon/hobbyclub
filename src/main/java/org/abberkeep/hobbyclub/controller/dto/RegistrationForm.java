/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller.dto;

/**
 * Title: RegistrationForm
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
public class RegistrationForm {
   private String firstName;
   private String lastName;
   private String nickName;
   private String password;
   private String stateId;
   private String CityId;
   private String interestOne;
   private String interestTwo;
   private String interestThree;

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getNickName() {
      return nickName;
   }

   public String getPassword() {
      return password;
   }

   public String getStateId() {
      return stateId;
   }

   public String getCityId() {
      return CityId;
   }

   public String getInterestOne() {
      return interestOne;
   }

   public String getInterestTwo() {
      return interestTwo;
   }

   public String getInterestThree() {
      return interestThree;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public void setNickName(String nickName) {
      this.nickName = nickName;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setStateId(String stateId) {
      this.stateId = stateId;
   }

   public void setCityId(String CityId) {
      this.CityId = CityId;
   }

   public void setInterestOne(String interestOne) {
      this.interestOne = interestOne;
   }

   public void setInterestTwo(String interestTwo) {
      this.interestTwo = interestTwo;
   }

   public void setInterestThree(String interestThree) {
      this.interestThree = interestThree;
   }

}
