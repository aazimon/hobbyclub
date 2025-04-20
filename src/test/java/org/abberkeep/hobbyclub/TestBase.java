/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub;

import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Status;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.State;

/**
 * Title: BaseTest
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 11, 2025
 * @author Gary Deken
 * @version
 */
public class TestBase {

   protected Account buildAccount(int id) {
      Account acc = new Account();

      acc.setAccountId(id);
      acc.setFirstName("First");
      acc.setLastName("Last");
      acc.setNickName("Nick");
      State state = buildState(12, "State");
      acc.setState(state);
      acc.setCity(buildCity(23, "City", state));

      return acc;
   }

   protected Category buildCategory(int id, String category) {
      return new Category(id, category);
   }

   protected City buildCity(int id, String city, State state) {
      return new City(id + 1, city, state);
   }

   protected Club buildClub(int id, String title) {
      Club club = new Club();

      club.setClubId(id);
      club.setName(title);
      club.setActive(Status.ACTIVE.getState());

      return club;
   }

   protected State buildState(int id, String state) {
      return new State(id + 1, state);
   }

}
