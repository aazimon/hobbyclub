/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.LocationService;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

   @RequestMapping("/")
   public ModelAndView indexPage(HttpSession session) {
      log.debug("Home Page Controller");
      ModelAndView mv = getModelAndView("Hobby Club", "lobby");

      // TODO check if user logged in.
      if (session.getAttribute("userAccount") != null) {
         Account account = (Account) session.getAttribute("userAccount");
         //mv.getModel().put("loginId", "-");
      }
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

   private void setUpHomePage(ModelAndView mv) {
      mv.getModel().put("categoryDropDown", clubService.getCategories("Any"));
      mv.getModel().put("stateDropDown", locationService.getAllStates());
      mv.getModel().put("cityDropDown", locationService.getCitiesByStateId(1));
   }

}
