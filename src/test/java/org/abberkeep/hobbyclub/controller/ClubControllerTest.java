/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.abberkeep.hobbyclub.controller.dto.ClubDisplay;
import org.abberkeep.hobbyclub.controller.dto.ClubForm;
import org.abberkeep.hobbyclub.controller.dto.EventDisplay;
import org.abberkeep.hobbyclub.controller.dto.EventForm;
import org.abberkeep.hobbyclub.controller.dto.SelectOption;
import org.abberkeep.hobbyclub.controller.dto.TopicForm;
import org.abberkeep.hobbyclub.services.CategoryService;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.EventService;
import org.abberkeep.hobbyclub.services.LocationService;
import org.abberkeep.hobbyclub.services.TopicService;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gary Deken
 */
@ExtendWith(MockitoExtension.class)
public class ClubControllerTest extends TestBaseController {
   private static final int PAGE_CLUB = 10;
   private Club club;
   @Mock
   private ClubService clubService;
   @Mock
   private EventService eventService;
   @Mock
   private CategoryService categoryService;
   @Mock
   private LocationService locationService;
   @Mock
   private TopicService topicService;
   @Mock
   private HttpSession session;
   @InjectMocks
   private ClubController underTest;

   @BeforeEach
   public void setUp() {
      club = buildClub(23, "Title23");
      club.setState(buildState(12, "State 12"));
      club.setCity(buildCity(1, "City 23", club.getState()));
   }

   @Test
   public void testClubHome() {
      when(clubService.getClub(23)).thenReturn(club);
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.TRUE);
      when(locationService.getStatesSelected(13)).thenReturn(buildSelectOptions(20));
      when(locationService.getCitiesSelected(13, 2)).thenReturn(buildSelectOptions(3));
      when(eventService.getClubEvents(23, 10)).thenReturn(buildEventDisplays(4, club));

      ModelAndView actual = underTest.clubHome("23", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB, actual.getModel().size());
      assertEquals("Title23", actual.getModel().get("navTitle"));
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      assertEquals("true", actual.getModel().get("userClub"));
      assertEquals("23", actual.getModel().get("clubId"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(20, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
      List<EventDisplay> actualED = (List<EventDisplay>) actual.getModel().get("clubEvents");
      assertEquals(4, actualED.size());
   }

   @Test
   public void testClubHomeNotInClub() {
      when(clubService.getClub(23)).thenReturn(club);
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.FALSE);
      when(locationService.getStatesSelected(13)).thenReturn(buildSelectOptions(20));
      when(locationService.getCitiesSelected(13, 2)).thenReturn(buildSelectOptions(3));
      when(eventService.getClubEvents(23, 10)).thenReturn(buildEventDisplays(4, club));

      ModelAndView actual = underTest.clubHome("23", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB - 1, actual.getModel().size());
      assertEquals("Title23", actual.getModel().get("navTitle"));
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      assertNull(actual.getModel().get("userClub"));
      assertEquals("23", actual.getModel().get("clubId"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(20, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
   }

   @Test
   public void testClubHomeNotLoggedIn() {
      when(clubService.getClub(23)).thenReturn(club);
      when(session.getAttribute("userAccount")).thenReturn(null);
      when(locationService.getStatesSelected(13)).thenReturn(buildSelectOptions(20));
      when(locationService.getCitiesSelected(13, 2)).thenReturn(buildSelectOptions(3));
      when(eventService.getClubEvents(23, null)).thenReturn(buildEventDisplays(4, club));

      ModelAndView actual = underTest.clubHome("23", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB - 3, actual.getModel().size());
      assertEquals("Title23", actual.getModel().get("navTitle"));
      assertNull(actual.getModel().get("loginUser"));
      assertNull(actual.getModel().get("nickName"));
      assertNull(actual.getModel().get("userClub"));
      assertEquals("23", actual.getModel().get("clubId"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(20, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
   }

   @Test
   public void testClubHomeNone() {
      when(clubService.getClub(23)).thenReturn(null);

      ModelAndView actual = underTest.clubHome("23", session);

      assertEquals("error", actual.getViewName());
   }

   @Test
   public void testJoinClub() {
      when(clubService.getClub(23)).thenReturn(club);
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.TRUE);
      when(locationService.getStatesSelected(13)).thenReturn(buildSelectOptions(20));
      when(locationService.getCitiesSelected(13, 2)).thenReturn(buildSelectOptions(3));
      when(eventService.getClubEvents(23, 10)).thenReturn(buildEventDisplays(4, club));

      ModelAndView actual = underTest.joinClub("23", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB, actual.getModel().size());
      assertEquals("Title23", actual.getModel().get("navTitle"));
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(20, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
   }

   @Test
   public void testAddEvent() {
      EventForm eventForm = new EventForm("Title", "Details", "2025/04/25 21:00", "3", "18");
      Account account = buildAccount(10);

      when(clubService.getClub(23)).thenReturn(club);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.TRUE);
      when(locationService.getStatesSelected(13)).thenReturn(buildSelectOptions(20));
      when(locationService.getCitiesSelected(13, 2)).thenReturn(buildSelectOptions(3));
      when(eventService.getClubEvents(23, 10)).thenReturn(buildEventDisplays(4, club));

      ModelAndView actual = underTest.addEvent("23", eventForm, session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB + 1, actual.getModel().size());
      assertEquals("Title23", actual.getModel().get("navTitle"));
      assertEquals("New Event Created", actual.getModel().get("clubMessage"));

      verify(eventService).saveEvent(eventForm, account, club);
   }

   @Test
   public void testAddEventTooLong() {
      EventForm eventForm = new EventForm("Epic Anime Marathon: A 12-Hour Journey Through Iconic Series",
         "Join us for an unforgettable 12-hour anime marathon celebrating some of the most iconic series in anime history! From action-packed classics to heartwarming slice-of-life favorites, we'll journey through beloved worlds that have shaped anime culture. Expect screenings, trivia games, cosplay showcases, and themed snacks. Bring your friends, dress up as your favorite characters, and get ready for a night filled with laughter, excitement, and pure anime magic! This is an event you don't want to miss.",
         "2025/04/25 21:00", "3", "18");
      Account account = buildAccount(10);

      when(clubService.getClub(23)).thenReturn(club);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.TRUE);
      when(locationService.getStatesSelected(13)).thenReturn(buildSelectOptions(20));
      when(locationService.getCitiesSelected(13, 2)).thenReturn(buildSelectOptions(3));
      when(eventService.getClubEvents(23, 10)).thenReturn(buildEventDisplays(4, club));
      when(eventService.saveEvent(eventForm, account, club)).thenAnswer(invoc -> {
         EventForm ef = invoc.getArgument(0);

         assertEquals(50, ef.getNewEventTitle().length());
         assertEquals(500, ef.getNewEventDetails().length());

         return null;
      });

      ModelAndView actual = underTest.addEvent("23", eventForm, session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB + 1, actual.getModel().size());
      assertEquals("Title23", actual.getModel().get("navTitle"));
      assertEquals("New Event Created", actual.getModel().get("clubMessage"));

      verify(eventService).saveEvent(eventForm, account, club);
   }

   @Test
   public void testMarkAttendanceWillAttend() {
      Account account = buildAccount(10);

      when(clubService.getClub(23)).thenReturn(club);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(eventService.addAttendanceToEvent(89, account, "WA")).thenReturn("Title");
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.TRUE);
      when(locationService.getStatesSelected(13)).thenReturn(buildSelectOptions(20));
      when(locationService.getCitiesSelected(13, 2)).thenReturn(buildSelectOptions(3));
      when(eventService.getClubEvents(23, 10)).thenReturn(buildEventDisplays(4, club));

      ModelAndView actual = underTest.markAttendance("23", "89", "WA", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB + 1, actual.getModel().size());
      assertEquals("Successfully marking Title as Attending.", actual.getModel().get("clubMessage"));
   }

   @Test
   public void testMarkAttendanceMayAttend() {
      Account account = buildAccount(10);

      when(clubService.getClub(23)).thenReturn(club);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(eventService.addAttendanceToEvent(89, account, "MA")).thenReturn("Title");
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.TRUE);
      when(locationService.getStatesSelected(13)).thenReturn(buildSelectOptions(20));
      when(locationService.getCitiesSelected(13, 2)).thenReturn(buildSelectOptions(3));
      when(eventService.getClubEvents(23, 10)).thenReturn(buildEventDisplays(4, club));

      ModelAndView actual = underTest.markAttendance("23", "89", "MA", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB + 1, actual.getModel().size());
      assertEquals("Successfully marking Title as May Attend.", actual.getModel().get("clubMessage"));
   }

   @Test
   public void testMarkAttendanceInterested() {
      Account account = buildAccount(10);

      when(clubService.getClub(23)).thenReturn(club);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(eventService.addAttendanceToEvent(89, account, "IE")).thenReturn("Title");
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.TRUE);
      when(locationService.getStatesSelected(13)).thenReturn(buildSelectOptions(20));
      when(locationService.getCitiesSelected(13, 2)).thenReturn(buildSelectOptions(3));
      when(eventService.getClubEvents(23, 10)).thenReturn(buildEventDisplays(4, club));

      ModelAndView actual = underTest.markAttendance("23", "89", "IE", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB + 1, actual.getModel().size());
      assertEquals("Successfully marking Title as Interested.", actual.getModel().get("clubMessage"));
   }

   @Test
   public void testMarkAttendanceNotInterested() {
      Account account = buildAccount(10);

      when(clubService.getClub(23)).thenReturn(club);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(eventService.addAttendanceToEvent(89, account, "NI")).thenReturn("Title");
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.TRUE);
      when(locationService.getStatesSelected(13)).thenReturn(buildSelectOptions(20));
      when(locationService.getCitiesSelected(13, 2)).thenReturn(buildSelectOptions(3));
      when(eventService.getClubEvents(23, 10)).thenReturn(buildEventDisplays(4, club));

      ModelAndView actual = underTest.markAttendance("23", "89", "NI", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB + 1, actual.getModel().size());
      assertEquals("Successfully marking Title as Not Interested.", actual.getModel().get("clubMessage"));
   }

   @Test
   public void testMarkAttendanceBadData() {
      Account account = buildAccount(10);

      when(clubService.getClub(23)).thenReturn(club);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(eventService.getEvent(89)).thenReturn(buildEvent(89, "Title", buildAccount(99)));
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.TRUE);
      when(locationService.getStatesSelected(13)).thenReturn(buildSelectOptions(20));
      when(locationService.getCitiesSelected(13, 2)).thenReturn(buildSelectOptions(3));
      when(eventService.getClubEvents(23, 10)).thenReturn(buildEventDisplays(4, club));

      ModelAndView actual = underTest.markAttendance("23", "89", "XX", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB + 1, actual.getModel().size());
      assertEquals("Error saving intentions on Title.", actual.getModel().get("clubMessage"));
   }

   @Test
   public void testPostReply() {
      Account account = buildAccount(10);
      TopicForm topicForm = new TopicForm("23", "Topic Text", null);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(clubService.getClub(23)).thenReturn(club);

      ModelAndView actual = underTest.postReply(topicForm, session);

      validateTitleView("Title23", "club", actual);
      verify(topicService).addReplyToTopic(topicForm, account);
   }

   @Test
   public void testPostReplyTooLong() {
      Account account = buildAccount(10);
      TopicForm topicForm = new TopicForm("23",
         "Anime is a vibrant and diverse art form that blends stunning visuals, deep storytelling, and unforgettable characters. From action-packed adventures like Naruto and Attack on Titan to heartwarming tales like Your Name, anime captivates audiences worldwide. It�s more than entertainment � it�s a window into culture, emotion, and imagination that brings fans together.",
         null);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(clubService.getClub(23)).thenReturn(club);
      when(topicService.addReplyToTopic(topicForm, account)).thenAnswer(invoc -> {
         TopicForm tf = invoc.getArgument(0);

         assertEquals(300, tf.getPost().length());

         return null;
      });

      ModelAndView actual = underTest.postReply(topicForm, session);

      validateTitleView("Title23", "club", actual);
      verify(topicService).addReplyToTopic(topicForm, account);
   }

   @Test
   public void testPostTopic() {
      Account account = buildAccount(10);
      TopicForm topicForm = new TopicForm("23", "Topic Text", null);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(clubService.getClub(23)).thenReturn(club);

      ModelAndView actual = underTest.postTopic(topicForm, session);

      validateTitleView("Title23", "club", actual);
      verify(topicService).saveTopic(topicForm, account);
   }

   @Test
   public void testPostTopicTooLong() {
      Account account = buildAccount(10);
      TopicForm topicForm = new TopicForm("23",
         "Anime is a vibrant and diverse art form that blends stunning visuals, deep storytelling, and unforgettable characters. From action-packed adventures like Naruto and Attack on Titan to heartwarming tales like Your Name, anime captivates audiences worldwide. It�s more than entertainment � it�s a window into culture, emotion, and imagination that brings fans together.",
         null);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(clubService.getClub(23)).thenReturn(club);
      when(topicService.saveTopic(topicForm, account)).thenAnswer(invoc -> {
         TopicForm tf = invoc.getArgument(0);

         assertEquals(300, tf.getPost().length());

         return null;
      });

      ModelAndView actual = underTest.postTopic(topicForm, session);

      validateTitleView("Title23", "club", actual);
      verify(topicService).saveTopic(topicForm, account);
   }

   @Test
   public void testSaveClub() {
      Account account = buildAccount(10);
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(categoryService.getCategoryById(Integer.valueOf("3"))).thenReturn(buildCategory(3, "Category"));
      when(clubService.saveClub(any(), eq(account))).thenAnswer(invocation -> {
         Club c = (Club) invocation.getArgument(0);
         c.setClubId(45);
         c.setCreateDatetime(LocalDateTime.now());
         return c;
      });

      ClubDisplay actual = underTest.saveClub(new ClubForm("title", "3", "description"), session);

      assertEquals("title", actual.getTitle());
      assertEquals("45", actual.getId());
   }

   @Test
   public void testValidateClubForUser() {
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.validateClubByTitleState(eq("Title"), any(State.class))).thenReturn(Boolean.TRUE);

      ResponseEntity<String> actual = underTest.validateClubForUser("Title", session);

      assertTrue(actual.getStatusCode().is2xxSuccessful());
      assertEquals("valid", actual.getBody());
   }

   @Test
   public void testValidateClubForUserFail() {
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.validateClubByTitleState(eq("Title"), any(State.class))).thenReturn(Boolean.FALSE);

      ResponseEntity<String> actual = underTest.validateClubForUser("Title", session);

      assertTrue(actual.getStatusCode().is4xxClientError());
      assertEquals("invalid", actual.getBody());
   }

   private List<EventDisplay> buildEventDisplays(int i, Club club) {
      List<EventDisplay> ed = new ArrayList<>();

      for (int j = 0; j < i; j++) {
         ed.add(buildEventDisplay(3 + i, "Event #" + i, club));
      }

      return ed;
   }

}
