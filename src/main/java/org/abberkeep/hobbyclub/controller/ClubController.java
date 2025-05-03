/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import jakarta.servlet.http.HttpSession;
import org.abberkeep.hobbyclub.controller.dto.ClubDisplay;
import org.abberkeep.hobbyclub.controller.dto.ClubForm;
import org.abberkeep.hobbyclub.controller.dto.EventForm;
import org.abberkeep.hobbyclub.controller.dto.TopicForm;
import org.abberkeep.hobbyclub.services.CategoryService;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.EventService;
import org.abberkeep.hobbyclub.services.LocationService;
import org.abberkeep.hobbyclub.services.TopicService;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.EventAttendance;
import org.abberkeep.hobbyclub.services.domains.State;
import org.abberkeep.hobbyclub.services.domains.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
   private EventService eventService;
   @Autowired
   private CategoryService categoryService;
   @Autowired
   private LocationService locationService;
   @Autowired
   private TopicService topicService;

   @PostMapping("/addEvent/{clubId}")
   public ModelAndView addEvent(@PathVariable String clubId, @ModelAttribute EventForm event, HttpSession session) {
      log.debug("Add new Event");
      Club club = clubService.getClub(Integer.parseInt(clubId));
      Account account = (Account) session.getAttribute("userAccount");

      eventService.saveEvent(event, account, club);
      ModelAndView mv = setUpClubPage(account, club);

      mv.getModel().put("clubMessage", "New Event Created");

      return mv;
   }

   @RequestMapping("/clubHome/{clubId}")
   public ModelAndView clubHome(@PathVariable String clubId, HttpSession session) {
      log.debug("Club home page");
      Club club = clubService.getClub(Integer.parseInt(clubId));

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
      Club club = clubService.getClub(Integer.parseInt(clubId));

      if (!clubService.isUserInClub(account.getAccountId(), club.getClubId())) {
         clubService.joinClub(account, Integer.parseInt(clubId));
      }
      ModelAndView mv = setUpClubPage(account, club);

      return mv;
   }

   @GetMapping("/markAttendance/{clubId}/{eventId}/{attendance}")
   public ModelAndView markAttendance(@PathVariable String clubId, @PathVariable String eventId,
      @PathVariable String attendance, HttpSession session) {
      Account account = (Account) session.getAttribute("userAccount");
      Club club = clubService.getClub(Integer.parseInt(clubId));
      String message;

      if (EventAttendance.VALID_ATTENDANCE.contains(attendance)) {
         String title = eventService.addAttendanceToEvent(Integer.valueOf(eventId), account, attendance);
         message = "Error saving intentions on " + title + ".";
         switch (attendance) {
            case EventAttendance.WILL_ATTEND ->
               message = "Successfully marking " + title + " as Attending.";
            case EventAttendance.MAY_ATTEND ->
               message = "Successfully marking " + title + " as May Attend.";
            case EventAttendance.INTERESTED ->
               message = "Successfully marking " + title + " as Interested.";
            case EventAttendance.NOT_INTERESTED ->
               message = "Successfully marking " + title + " as Not Interested.";
         }
      } else {
         String title = eventService.getEvent(Integer.valueOf(eventId)).getTitle();
         message = "Error saving intentions on " + title + ".";
      }

      ModelAndView mv = setUpClubPage(account, club);

      mv.getModel().put("clubMessage", message);

      return mv;
   }

   @PostMapping("/postReply")
   public ModelAndView postReply(@ModelAttribute TopicForm topicForm, HttpSession session) {
      Account account = (Account) session.getAttribute("userAccount");
      Club club = clubService.getClub(Integer.parseInt(topicForm.getClubId()));

      topicService.addReplyToTopic(topicForm, account);
      ModelAndView mv = setUpClubPage(account, club);

      mv.getModel().put("clubMessage", "Topic added.");

      return mv;
   }

   @PostMapping("/postTopic")
   public ModelAndView postTopic(@ModelAttribute TopicForm topicForm, HttpSession session) {
      Account account = (Account) session.getAttribute("userAccount");
      Club club = clubService.getClub(Integer.parseInt(topicForm.getClubId()));

      topicService.saveTopic(topicForm, account);
      ModelAndView mv = setUpClubPage(account, club);

      mv.getModel().put("clubMessage", "Topic added.");

      return mv;
   }

   @PostMapping("/ajax/saveClub")
   @ResponseBody
   public ClubDisplay saveClub(@RequestBody ClubForm clubform, HttpSession session) {
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

      return new ClubDisplay(club.getClubId().toString(), club.getName(), club.getDescription());
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
      Integer accountId = null;
      if (account != null) {
         setUserLoggedIn(mv, account);
         if (clubService.isUserInClub(account.getAccountId(), club.getClubId())) {
            mv.getModel().put("userClub", "true");
         }
         accountId = account.getAccountId();
      }
      mv.getModel().put("clubId", club.getClubId().toString());
      mv.getModel().put("stateDropDown", locationService.getStatesSelected(club.getState().getStateId()));
      mv.getModel().put("cityDropDown", locationService.getCitiesSelected(club.getState().getStateId(),
         club.getCity().getCityId()));
      mv.getModel().put("clubEvents", eventService.getClubEvents(club.getClubId(), accountId));
      mv.getModel().put("clubTopics", topicService.getTopicsForClub(club.getClubId()));

      return mv;
   }

}
