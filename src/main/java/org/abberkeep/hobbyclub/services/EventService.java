/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.abberkeep.hobbyclub.controller.dto.EventDisplay;
import org.abberkeep.hobbyclub.controller.dto.EventForm;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.Event;
import org.abberkeep.hobbyclub.services.domains.EventAttendance;
import org.abberkeep.hobbyclub.services.domains.State;
import org.abberkeep.hobbyclub.services.repositories.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Title: EventService
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 27, 2025
 * @author Gary Deken
 * @version
 */
@Service
public class EventService {
   private final static Logger log = LoggerFactory.getLogger(EventService.class);
   private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
   @Autowired
   private EventRepository eventRepository;
   @Autowired
   private LocationService locationService;

   @Transactional
   public String addAttendanceToEvent(Integer eventId, Account account, String attendance) {
      Optional<Event> opt = eventRepository.findById(eventId);

      if (opt.isEmpty()) {
         log.error("Event not found for ID " + eventId);
         return "";
      }
      Event event = opt.get();
      EventAttendance eventAttend = new EventAttendance(account, event, attendance);

      event.addAttendance(eventAttend);
      eventRepository.save(event);

      return event.getTitle();
   }

   @Transactional
   public List<EventDisplay> getClubEvents(Integer clubId, Integer loggedInUserId) {
      List<Event> events = eventRepository.findByClubClubId(clubId);
      List<EventDisplay> eds = new ArrayList<>();

      events.forEach(ev -> {
         EventDisplay ed = mapEventDisplay(ev);
         if (ev.getAccount().getAccountId().equals(loggedInUserId)) {
            ed.setOwnEvent("true");
         }
         eds.add(ed);
      });

      return eds;
   }

   public Event getEvent(Integer eventId) {
      Optional<Event> opt = eventRepository.findById(eventId);

      if (opt.isEmpty()) {
         return null;
      }
      return opt.get();
   }

   @Transactional
   public List<EventDisplay> getEventsForUsers(Account account) {
      List<Event> events = eventRepository.findByAccountAccountId(account.getAccountId());
      List<EventDisplay> eventDisplays = new ArrayList<>();

      events.forEach(ev -> {
         EventDisplay ed = mapEventDisplay(ev);

         eventDisplays.add(ed);
      });

      return eventDisplays;
   }

   @Transactional
   public List<EventDisplay> getEventsForUserClubs(Account account) {
      List<Event> events = eventRepository.findByClubAccountId(account.getAccountId());
      List<EventDisplay> eventDisplays = new ArrayList<>();

      events.forEach(ev -> {
         EventDisplay ed = mapEventDisplay(ev);

         eventDisplays.add(ed);
      });

      return eventDisplays;
   }

   @Transactional
   public Event saveEvent(EventForm eventForm, Account account, Club club) {
      Event event = new Event();

      event.setAccount(account);
      event.setClub(club);
      event.setTitle(eventForm.getNewEventTitle());
      event.setDetails(eventForm.getNewEventDetails());
      event.setDatetime(LocalDateTime.parse(eventForm.getNewEventDate(), formatter));
      City city = null;

      if (eventForm.getCityId() != null && !eventForm.getCityId().isBlank()) {
         city = locationService.getCityById(Integer.valueOf(eventForm.getCityId()));
      }
      if (city == null) {
         city = club.getCity();
      }
      event.setCity(city);
      State state = null;

      if (eventForm.getStateId() != null && !eventForm.getStateId().isBlank()) {
         state = locationService.getStateById(Integer.valueOf(eventForm.getStateId()));
      }
      if (state == null) {
         state = club.getState();
      }
      event.setState(state);

      return eventRepository.save(event);
   }

   private EventDisplay mapEventDisplay(Event ev) {
      EventDisplay ed = new EventDisplay();
      ed.setId(ev.getEventId().toString());
      ed.setTitle(ev.getTitle());
      ed.setDetails(ev.getDetails());
      ed.setDateTime(formatter.format(ev.getDatetime()).toLowerCase());
      ed.setLocation(ev.getCity().getName() + ", " + ev.getState().getName());
      ed.setOrganizer(ev.getAccount().getNickName());
      ed.setClubId(ev.getClub().getClubId().toString());
      ed.setClubTitle(ev.getClub().getName());
      int will = 0;
      int may = 0;
      int intrst = 0;
      int none = 0;
      for (EventAttendance eventAttendance : ev.getEventAttendances()) {
         switch (eventAttendance.getAttending()) {
            case EventAttendance.WILL_ATTEND:
               will++;
               break;
            case EventAttendance.MAY_ATTEND:
               may++;
               break;
            case EventAttendance.INTERESTED:
               intrst++;
               break;
            default:
               none++;
         }
      }
      ed.setWillAttend(Integer.toString(will));
      ed.setMayAttend(Integer.toString(may));
      ed.setInterested(Integer.toString(intrst));
      ed.setNone(Integer.toString(none));
      return ed;
   }

}
