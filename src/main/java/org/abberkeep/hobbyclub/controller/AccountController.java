/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import java.util.List;
import org.abberkeep.hobbyclub.services.AccountService;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.LocationService;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
   @Autowired
   private AccountService accountService;
   @Autowired
   private ClubService clubService;

   @RequestMapping("/registration")
   public ModelAndView registrationPage() {
      log.debug("Registration Page");
      ModelAndView mv = getModelAndView("Hobby Club Registration", "registration");

      mv.getModel().put("stateDropDown", locationService.getAllStates());
      mv.getModel().put("cityDropDown", locationService.getCitiesByStateId(1));
      mv.getModel().put("categoryDropDown", clubService.getCategories());
      mv.getModel().put("categoryDropDown2", clubService.getCategories());
      mv.getModel().put("categoryDropDown3", clubService.getCategories());

      return mv;
   }

   @PostMapping("/newMember")
   public ModelAndView registerNewMember(@ModelAttribute RegistrationForm registrationForm) {
      log.debug("Register New Member");
      ModelAndView mv = new ModelAndView();

      mv.getModel().put("title", "Hobby Club Registration");
      if (validateRegistrationForm(registrationForm, mv)) {
         // valid data.
         Account account = accountService.createNewAccount(registrationForm);

         mv.setViewName("userhome");
         setUpHomePage(mv, account);
      } else {
         // data missing.
         mv.getModel().put("firstName", registrationForm.getFirstName());
         mv.getModel().put("lastName", registrationForm.getLastName());
         mv.getModel().put("nickName", registrationForm.getNickName());
         mv.getModel().put("stateDropDown", setSelected(locationService.getAllStates(), registrationForm.getStateId()));
         int stateId = 1;
         if (StringUtils.hasText(registrationForm.getStateId())) {
            stateId = Integer.valueOf(registrationForm.getStateId());
         }
         String cityId = "*";
         if (StringUtils.hasText(registrationForm.getCityId())) {
            cityId = registrationForm.getCityId();
         }
         mv.getModel().put("cityDropDown", setSelected(locationService.getCitiesByStateId(stateId), cityId));
         mv.getModel().put("categoryDropDown", setSelectedAt(clubService.getCategories(),
            registrationForm.getInterestOne()));
         mv.getModel().put("categoryDropDown2", setSelectedAt(clubService.getCategories(),
            registrationForm.getInterestTwo()));
         mv.getModel().put("categoryDropDown3", setSelectedAt(clubService.getCategories(),
            registrationForm.getInterestThree()));
         mv.setViewName("registration");
      }

      return mv;
   }

   @RequestMapping("/userHome")
   public ModelAndView userHomePage(@PathVariable String accountId) {
      Account account = accountService.getAccountById(Integer.valueOf(accountId));
      ModelAndView mv = getModelAndView(account.getNickName() + " - Home Page", "userHome");

      setUpHomePage(mv, account);

      return mv;
   }

   private List<SelectOption> setSelected(List<SelectOption> options, String value) {
      String valueId = "1";
      if (StringUtils.hasText(value)) {
         valueId = value;
      }

      return setSelectedAt(options, valueId);
   }

   private List<SelectOption> setSelectedAt(List<SelectOption> options, String value) {
      for (SelectOption opt : options) {
         if (opt.getValue().equals(value)) {
            opt.setSelected(true);
         }
      }

      return options;
   }

   private void setUpHomePage(ModelAndView mv, Account account) {

   }

   private boolean validateRegistrationForm(RegistrationForm form, ModelAndView mv) {
      boolean valid = true;
      if (!StringUtils.hasText(form.getFirstName())) {
         mv.getModel().put("missingFirst", "true");
         valid = false;
      }
      if (!StringUtils.hasText(form.getLastName())) {
         mv.getModel().put("missingLast", "true");
         valid = false;
      }
      if (StringUtils.hasText(form.getNickName())) {
         if (accountService.checkNickName(form.getNickName())) {
            mv.getModel().put("takenNick", "true");
            valid = false;
         }
      }
      if (!StringUtils.hasText(form.getStateId())) {
         mv.getModel().put("missingState", "true");
         valid = false;
      }
      if (!StringUtils.hasText(form.getCityId())) {
         mv.getModel().put("missingCity", "true");
         valid = false;
      }
      if (!(StringUtils.hasText(form.getInterestOne()) || StringUtils.hasText(form.getInterestTwo()) || StringUtils.hasText(
         form.getInterestThree()))) {
         mv.getModel().put("missingInterest", "true");
         valid = false;
      }
      return valid;
   }

}
