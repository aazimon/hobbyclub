/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.abberkeep.hobbyclub.controller.dto.ClubDisplay;
import org.abberkeep.hobbyclub.controller.dto.LogInForm;
import org.abberkeep.hobbyclub.controller.dto.RegistrationForm;
import org.abberkeep.hobbyclub.controller.dto.SelectOption;
import org.abberkeep.hobbyclub.controller.dto.UserFilterForm;
import org.abberkeep.hobbyclub.services.AccountService;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.EventService;
import org.abberkeep.hobbyclub.services.LocationService;
import org.abberkeep.hobbyclub.services.TopicService;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
   @Autowired
   private AccountService accountService;
   @Autowired
   private ClubService clubService;
   @Autowired
   private TopicService topicService;
   @Autowired
   private EventService eventService;

   @RequestMapping("/login")
   public ModelAndView login() {
      log.debug("Log In");
      ModelAndView mv = getModelAndView("Log in to Hobby Club", "login");

      return mv;
   }

   @PostMapping("/loginHobbyClub")
   public ModelAndView loginHobbyClub(@ModelAttribute LogInForm loginForm, HttpSession session) {
      log.debug("Log In Hobby Club");
      ModelAndView mv = new ModelAndView();

      if (validateLogInForm(loginForm, mv)) {
         Account account = accountService.getAccountByNickNamePassword(loginForm.getNickName(), loginForm.getPassword());
         if (account == null) {
            mv.getModel().put("invalidLogin", "true");
         } else {
            session.setAttribute("userAccount", account);
            setUpHomePage(mv, account, new UserFilterForm("", ""));
            return mv;
         }
      }
      mv.getModel().put("title", "Log in to Hobby Club");
      mv.setViewName("login");
      mv.getModel().put("nickName", loginForm.getNickName());
      mv.getModel().put("password", loginForm.getPassword());

      return mv;
   }

   @RequestMapping("/registration")
   public ModelAndView registrationPage() {
      log.debug("Registration Page");
      ModelAndView mv = getModelAndView("Hobby Club Registration", "registration");

      mv.getModel().put("stateDropDown", locationService.getAllStates());
      mv.getModel().put("cityDropDown", locationService.getCitiesByStateId(1));
      List<SelectOption> categories = clubService.getCategories("Choose");
      mv.getModel().put("categoryDropDown", categories);
      mv.getModel().put("categoryDropDown2", categories);
      mv.getModel().put("categoryDropDown3", categories);

      return mv;
   }

   @PostMapping("/newMember")
   public ModelAndView registerNewMember(@ModelAttribute RegistrationForm registrationForm, HttpSession session) {
      log.debug("Register New Member");
      ModelAndView mv = new ModelAndView();

      mv.getModel().put("title", "Hobby Club Registration");
      if (validateRegistrationForm(registrationForm, mv)) {
         // valid data.
         Account account = accountService.createNewAccount(registrationForm);
         session.setAttribute("userAccount", account);

         setUpHomePage(mv, account, new UserFilterForm("", ""));
      } else {
         // data missing.
         mv.getModel().put("firstName", registrationForm.getFirstName());
         mv.getModel().put("lastName", registrationForm.getLastName());
         mv.getModel().put("nickName", registrationForm.getNickName());
         mv.getModel().put("password", registrationForm.getPassword());
         mv.getModel().put("stateDropDown", setSelected(locationService.getAllStates(), registrationForm.getStateId()));
         int stateId = 1;
         if (StringUtils.hasText(registrationForm.getStateId())) {
            stateId = Integer.parseInt(registrationForm.getStateId());
         }
         String cityId = "0";
         if (StringUtils.hasText(registrationForm.getCityId())) {
            cityId = registrationForm.getCityId();
         }
         mv.getModel().put("cityDropDown", setSelected(locationService.getCitiesByStateId(stateId), cityId));
         mv.getModel().put("categoryDropDown", setSelectedAt(clubService.getCategories("Choose"),
            registrationForm.getInterestOne()));
         mv.getModel().put("categoryDropDown2", setSelectedAt(clubService.getCategories("Choose"),
            registrationForm.getInterestTwo()));
         mv.getModel().put("categoryDropDown3", setSelectedAt(clubService.getCategories("Choose"),
            registrationForm.getInterestThree()));
         mv.setViewName("registration");
      }

      return mv;
   }

   @RequestMapping("/userHome")
   public ModelAndView userHomePage(HttpSession session) {
      log.debug("User Home Page");
      Account account = (Account) session.getAttribute("userAccount");
      ModelAndView mv = new ModelAndView();

      setUpHomePage(mv, account, new UserFilterForm("", ""));

      return mv;
   }

   @PostMapping("/userHomeFilter")
   public ModelAndView userHomePageFiltering(@ModelAttribute UserFilterForm filterForm, HttpSession session) {
      log.debug("User Home Page Filtering");
      Account account = (Account) session.getAttribute("userAccount");
      ModelAndView mv = new ModelAndView();

      setUpHomePage(mv, account, filterForm);

      return mv;
   }

   private int getInteger(String stringInt) {
      if (stringInt == null || stringInt.isBlank()) {
         return 0;
      }
      return Integer.valueOf(stringInt);
   }

   private void setUpHomePage(ModelAndView mv, Account account, UserFilterForm filterForm) {
      mv.setViewName("userhome");
      setUserLoggedIn(mv, account);
      mv.getModel().put("navTitle", account.getNickName() + " - Home Page");
      mv.getModel().put("title", "Hobby Club Home Page for " + account.getNickName());
      mv.getModel().put("categoryDropDown", clubService.getCategories("Choose"));

      List<ClubDisplay> yourClubs = clubService.getYourJoinedClubs(account.getAccountId());
      List<ClubDisplay> clubSelections = new ArrayList<>();

      clubSelections.add(new ClubDisplay("0", "All", ""));
      yourClubs.forEach(cd -> {
         if (cd.getId().equals(filterForm.getFilterEvent())) {
            cd.setEventSelected(true);
         }
         if (cd.getId().equals(filterForm.getFilterTopic())) {
            cd.setTopicSelected(true);
         }
         clubSelections.add(cd);
      });
      mv.getModel().put("selectEventTopic", clubSelections);
      mv.getModel().put("yourClubEvents", eventService.getEventsForUserClubs(account, getInteger(
         filterForm.getFilterEvent())));
      mv.getModel().put("yourEvents", eventService.getEventsForUsers(account, getInteger(filterForm.getFilterEvent())));
      mv.getModel().put("yourCreatedClubs", clubService.getYourCreatedClubs(account.getAccountId()));
      mv.getModel().put("yourJoinedClubs", yourClubs);
      mv.getModel().put("yourTopics", topicService.getTopicsForUser(account.getAccountId(), getInteger(
         filterForm.getFilterTopic())));
      mv.getModel().put("filterEvent", filterForm.getFilterEvent());
      mv.getModel().put("filterTopic", filterForm.getFilterTopic());
   }

   private boolean validateLogInForm(LogInForm form, ModelAndView mv) {
      boolean valid = true;
      if (!StringUtils.hasText(form.getNickName())) {
         mv.getModel().put("missingNick", "true");
         valid = false;
      }
      if (!StringUtils.hasText(form.getPassword())) {
         mv.getModel().put("missingPass", "true");
         valid = false;
      }

      return valid;
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
            mv.getModel().put("nickAlternative", accountService.getRandomNickName(form.getFirstName()));
            valid = false;
         }
      }
      if (!StringUtils.hasText(form.getPassword())) {
         mv.getModel().put("noPass", "true");
         valid = false;
      } else {
         String pass = form.getPassword().trim();
         if (!StringUtils.hasText(pass)) {
            mv.getModel().put("noPass", "true");
            valid = false;
         } else if (pass.length() < 10) {
            mv.getModel().put("shortPass", "true");
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
