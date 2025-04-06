/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import org.abberkeep.hobbyclub.services.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Title: AccountController
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
@Controller
public class AccountController extends BaseController {
   private static final Logger log = LoggerFactory.getLogger(AccountController.class);
   @Autowired
   private LocationService locationService;

   @RequestMapping("/registration")
   public ModelAndView registrationPage() {
      log.debug("Registration Page");
      ModelAndView mv = getModelAndView("Hobby Club Registration", "registration");

      mv.getModel().put("stateDropDown", locationService.getAllStates());

      return mv;
   }

   @PostMapping(name = "/newMember")
   public ModelAndView registerNewMember(@ModelAttribute RegistrationForm registrationForm) {
      log.debug("Register New Member");
      ModelAndView mv = getModelAndView("Hobby Club Registration", "registration");

      return mv;
   }

}
