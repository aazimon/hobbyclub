/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import jakarta.servlet.http.HttpSession;
import org.abberkeep.hobbyclub.services.CategoryService;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.State;
import org.abberkeep.hobbyclub.services.domains.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
   @Autowired
   private CategoryService categoryService;

   @RequestMapping("/clubHome/{clubId}")
   public ModelAndView clubHome(@PathVariable String clubId, HttpSession session) {
      log.debug("validate club");
      Club club = clubService.getClub(Integer.valueOf(clubId));

      if (club == null) {
         ModelAndView mv = getModelAndView("No Club Found", "error");
         log.error("Club is not valid.");

         return mv;
      }
      Account account = (Account) session.getAttribute("userAccount");
      ModelAndView mv = setUpClubPage(account, club);

      return mv;
   }

   @RequestMapping("/joinClub/{clubId}")
   public ModelAndView joinClub(@PathVariable String clubId, HttpSession session) {
      Account account = (Account) session.getAttribute("userAccount");
      Club club = clubService.getClub(Integer.valueOf(clubId));

      if (!clubService.isUserInClub(account.getAccountId(), club.getClubId())) {
         clubService.joinClub(account, Integer.parseInt(clubId));
      }
      ModelAndView mv = setUpClubPage(account, club);

      return mv;
   }

   @PostMapping("/ajax/saveClub")
   @ResponseBody
   public YourClub saveClub(@RequestBody ClubForm clubform, HttpSession session) {
      log.debug("save club");
      Account account = (Account) session.getAttribute("userAccount");
      State state = account.getState();
      City city = account.getCity();
      Category category = categoryService.getCategoryById(Integer.valueOf(clubform.getCategory()));

      Club club = new Club();

      club.setName(clubform.getTitle());
      club.setDescription(clubform.getDescription());
      club.setCity(city);
      club.setState(state);
      club.setCategory(category);
      club.setAccount(account);
      club.setActive(Status.ACTIVE.getState());

      club = clubService.saveClub(club);

      return new YourClub(club.getName(), club.getClubId().toString());
   }

   @GetMapping("/ajax/validateClub/{clubTitle}")
   @ResponseBody
   public ResponseEntity<String> validateClubForUser(@PathVariable String clubTitle, HttpSession session) {
      log.debug("validate club");
      Account account = (Account) session.getAttribute("userAccount");
      State state = account.getState();

      if (clubService.validateClubByTitleState(clubTitle, state)) {
         return ResponseEntity.ok("valid");
      }

      return new ResponseEntity<>("invalid", HttpStatus.BAD_REQUEST);
   }

   private ModelAndView setUpClubPage(Account account, Club club) {
      ModelAndView mv = getModelAndView(club.getName(), "club");
      mv.getModel().put("navTitle", club.getName());
      if (account != null) {
         setUserLoggedIn(mv, account);
         if (clubService.isUserInClub(account.getAccountId(), club.getClubId())) {
            mv.getModel().put("userClub", "true");
         }

      }
      mv.getModel().put("clubId", club.getClubId().toString());
      return mv;
   }

}
