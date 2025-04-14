/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub;

import org.abberkeep.hobbyclub.services.domains.Account;
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
      acc.setState(buildState(12, "State"));

      return acc;
   }

   protected State buildState(int id, String state) {
      return new State(id + 1, state);
   }

}
