/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import jakarta.servlet.http.HttpSession;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: ClubController
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 13, 2025
 * @author Gary Deken
 * @version
 */
@Controller
public class ClubController extends BaseController {
   private static final Logger log = LoggerFactory.getLogger(ClubController.class);
   @Autowired
   private ClubService clubService;

   @GetMapping("/ajax/newClub/{clubTitle}")
   @ResponseBody
   public String validateClubForUser(@PathVariable String clubTitle, HttpSession session) {
      log.debug("Get Cities Controller");
      Account account = (Account) session.getAttribute("userAccount");
      State state = account.getState();

      if (clubService.validateClubByTitleState(clubTitle, state)) {
         return "valid";
      }

      return "invalid";
   }

}
