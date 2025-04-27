/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Title: EventServiceTest
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 27, 2025
 * @author Gary Deken
 * @version
 */
@ExtendWith(MockitoExtension.class)
public class EventServiceTest extends TestBaseService {
   @Mock
   private EventRepository eventRepository;
   @Mock
   private LocationService locationService;
   @InjectMocks
   private EventService underTest;

   @Test
   public void testAddAttendanceToEvent() {
      Account account = buildAccount(10);
      Event event = buildEvent(1, "My Event for 1", buildAccount(23));
      when(eventRepository.findById(56)).thenReturn(Optional.of(event));
      when(eventRepository.save(any())).thenAnswer(invocation -> {
         Event ev = invocation.getArgument(0);

         assertEquals(5, ev.getEventAttendances().size());

         for (EventAttendance ea : ev.getEventAttendances()) {
            if (ea.getAccount().getAccountId().equals(23)) {
               assertEquals(EventAttendance.INTERESTED, ea.getAttending());
               assertEquals(account, ea.getAccount());
            }
         }

         return ev;
      });

      assertEquals("My Event for 1", underTest.addAttendanceToEvent(56, account, EventAttendance.INTERESTED));
   }

   @Test
   public void testAddAttendanceToEventFail() {
      Account account = buildAccount(10);
      when(eventRepository.findById(56)).thenReturn(Optional.empty());

      assertEquals("", underTest.addAttendanceToEvent(56, account, EventAttendance.INTERESTED));

      verify(eventRepository, never()).save(any());
   }

   @Test
   public void testGetClubEvents() {

      List<EventDisplay> actual = underTest.getClubEvents(23, 10);
   }

   @Test
   public void testGetEventsForUsers() {
      Account account = buildAccount(10);
      when(eventRepository.findByAccountAccountId(10)).thenReturn(buildEvents(4));

      List<EventDisplay> actual = underTest.getEventsForUsers(account);

      assertEquals(4, actual.size());
   }

   @Test
   public void testSaveEvent() {
      Club club = buildClub(0, "Title12");
      Account account = buildAccount(10);
      State state = buildState(2, "State");
      City city = buildCity(17, "city", state);
      when(locationService.getCityById(18)).thenReturn(city);
      when(locationService.getStateById(3)).thenReturn(state);
      when(eventRepository.save(any())).thenAnswer(invocation -> {
         Event e = invocation.getArgument(0);

         e.setEventId(56);

         return e;
      });
      EventForm eventForm = new EventForm("Title", "Details", "2025/04/25 21:00", "3", "18");
      Event actual = underTest.saveEvent(eventForm, account, club);

      assertEquals(56, actual.getEventId());
      assertEquals(account, actual.getAccount());
      assertEquals(club, actual.getClub());
      assertEquals(city, actual.getCity());
      assertEquals(state, actual.getState());
      assertEquals(2025, actual.getDatetime().getYear());
      assertEquals("APRIL", actual.getDatetime().getMonth().toString());
      assertEquals(25, actual.getDatetime().getDayOfMonth());
      assertEquals(21, actual.getDatetime().getHour());
      assertEquals(00, actual.getDatetime().getMinute());
   }

   private List<Event> buildEvents(int number) {
      List<Event> evs = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         evs.add(buildEvent(i + 1, "Event" + i, buildAccount(i + 1 + 10)));
      }

      return evs;
   }

}
