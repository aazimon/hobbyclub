/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import org.abberkeep.hobbyclub.controller.dto.SelectOption;
import org.abberkeep.hobbyclub.controller.dto.SearchForm;
import org.abberkeep.hobbyclub.controller.dto.ClubRow;
import org.abberkeep.hobbyclub.controller.dto.ClubDisplay;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.abberkeep.hobbyclub.services.ClubSearchService;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.LocationService;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Title: HomeController
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Mar 31, 2025
 * @author Gary Deken
 * @version
 */
@Controller
public class HomeController extends BaseController {
   private static final Logger log = LoggerFactory.getLogger(HomeController.class);
   @Autowired
   private LocationService locationService;
   @Autowired
   private ClubService clubService;
   @Autowired
   private ClubSearchService clubSearchService;

   @RequestMapping("/")
   public ModelAndView indexPage(HttpSession session) {
      log.debug("Home Page Controller");
      ModelAndView mv = getModelAndView("Hobby Club", "lobby");

      setUpLoggedInUser(session, mv);
      setUpHomePage(mv);

      return mv;
   }

   @RequestMapping("/logout")
   public ModelAndView logout(HttpSession session) {
      log.debug("Log Out");
      session.invalidate();
      ModelAndView mv = getModelAndView("Hobby Club", "lobby");

      setUpHomePage(mv);
      return mv;
   }

   @GetMapping("/ajax/cities/{stateId}")
   @ResponseBody
   public List<SelectOption> getCities(@PathVariable String stateId) {
      log.debug("Get Cities Controller");

      return locationService.getCitiesByStateId(Integer.valueOf(stateId));
   }

   @PostMapping("/searchClubs")
   public ModelAndView searchClubs(@ModelAttribute SearchForm search, HttpSession session) {
      log.debug("Search Clubs Page");
      ModelAndView mv = getModelAndView("Hobby Clubs - Search", "search");

      setUpLoggedInUser(session, mv);
      // repopulate form.
      mv.getModel().put("clubName", search.getClubName());
      mv.getModel().put("categoryDropDown", setSelected(clubService.getCategories("Any"), search.getCategoryId()));
      mv.getModel().put("stateDropDown", setSelected(locationService.getAllStates(), search.getStateId()));
      if ("0".equals(search.getStateId())) {
         // if no state is selected, City drop down would be Any City.
         mv.getModel().put("cityDropDown", Arrays.asList(new SelectOption("0", "Any City")));
      } else {
         mv.getModel().put("cityDropDown", setSelected(locationService.getCitiesByStateId(Integer.valueOf(
            search.getStateId())), search.getCityId()));
      }
      List<ClubDisplay> searchClubs = clubSearchService.searchClubs(search);
      populateClubLists(searchClubs, mv);

      return mv;
   }

   private void setUpHomePage(ModelAndView mv) {
      mv.getModel().put("categoryDropDown", clubService.getCategories("Any"));
      mv.getModel().put("stateDropDown", locationService.getAllStates());
      mv.getModel().put("cityDropDown", Arrays.asList(new SelectOption("0", "Any City")));

      List<ClubDisplay> popClubs = clubSearchService.getPopularClubs();
      populateClubLists(popClubs, mv);
   }

   private void setUpLoggedInUser(HttpSession session, ModelAndView mv) {
      if (session.getAttribute("userAccount") != null) {
         Account account = (Account) session.getAttribute("userAccount");
         setUserLoggedIn(mv, account);
      }
   }

   private void populateClubLists(List<ClubDisplay> popClubs, ModelAndView mv) {
      if (!popClubs.isEmpty()) {
         // Get the most popular to highlight at top.
         ClubDisplay mostPopular = popClubs.remove(0);
         mv.getModel().put("mostPopular", mostPopular);
         if (!popClubs.isEmpty()) {
            // if more popular ones, get them to fill the page.
            if (popClubs.size() % 2 == 1) {
               ClubDisplay lastClub = popClubs.remove(popClubs.size() - 1);
               mv.getModel().put("lastClub", lastClub);
            }
            List<ClubRow> rows = new ArrayList<>();

            for (Iterator<ClubDisplay> iterator = popClubs.iterator(); iterator.hasNext();) {
               rows.add(new ClubRow(iterator.next(), iterator.next()));
            }

            mv.getModel().put("popularClubs", rows);
         }
      }
   }

}
