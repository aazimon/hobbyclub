/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.abberkeep.hobbyclub.controller.dto.ClubDisplay;
import org.abberkeep.hobbyclub.controller.dto.EventDisplay;
import org.abberkeep.hobbyclub.controller.dto.LogInForm;
import org.abberkeep.hobbyclub.controller.dto.RegistrationForm;
import org.abberkeep.hobbyclub.controller.dto.SelectOption;
import org.abberkeep.hobbyclub.controller.dto.TopicDisplay;
import org.abberkeep.hobbyclub.controller.dto.UserFilterForm;
import org.abberkeep.hobbyclub.services.AccountService;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.EventService;
import org.abberkeep.hobbyclub.services.LocationService;
import org.abberkeep.hobbyclub.services.TopicService;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gary Deken
 */
@ExtendWith(MockitoExtension.class)
public class AccountControllerTest extends TestBaseController {
   private static final String PAGE_LOGIN = "login";
   private static final String PAGE_REGISTRATION = "registration";
   private static final String PAGE_USERHOME = "userhome";
   private static final int USER_PAGE_SIZE = 13;
   @Mock
   private ClubService clubService;
   @Mock
   private LocationService locationService;
   @Mock
   private AccountService accountService;
   @Mock
   private EventService eventService;
   @Mock
   private TopicService topicService;
   @Mock
   private HttpSession session;
   @InjectMocks
   private AccountController underTest;

   @BeforeEach
   public void setUp() {
   }

   @Test
   public void testLogin() {
      ModelAndView actual = underTest.login();

      assertEquals("Log in to Hobby Club", actual.getModel().get("title"));
      assertEquals(PAGE_LOGIN, actual.getViewName());
   }

   @Test
   public void testLoginHobbyClub() {
      Account acc = buildAccount(11);
      when(accountService.getAccountByNickNamePassword("Nick", "Pass")).thenReturn(acc);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));

      ModelAndView actual = underTest.loginHobbyClub(buildLogInForm("Nick", "Pass"), session);

      validateTitleView("Hobby Club Home Page for Nick", PAGE_USERHOME, actual);
      assertEquals(USER_PAGE_SIZE, actual.getModel().size());
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      verify(session).setAttribute("userAccount", acc);
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(4, actualSO.size());
      assertEquals("", actual.getModel().get("filterEvent"));
      assertEquals("", actual.getModel().get("filterTopic"));
   }

   @Test
   public void testLoginHobbyClubFail1() {
      ModelAndView actual = underTest.loginHobbyClub(buildLogInForm(null, null), session);

      validateTitleView("Log in to Hobby Club", PAGE_LOGIN, actual);
      assertEquals(5, actual.getModel().size());
      assertEquals("true", actual.getModel().get("missingNick"));
      assertEquals("true", actual.getModel().get("missingPass"));
      assertNull(actual.getModel().get("password"));
   }

   @Test
   public void testLoginHobbyClubFail2() {
      when(accountService.getAccountByNickNamePassword("Nick", "Pass")).thenReturn(null);
      ModelAndView actual = underTest.loginHobbyClub(buildLogInForm("Nick", "Pass"), session);

      validateTitleView("Log in to Hobby Club", PAGE_LOGIN, actual);
      assertEquals(4, actual.getModel().size());
      assertEquals("true", actual.getModel().get("invalidLogin"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      assertEquals("Pass", actual.getModel().get("password"));
   }

   @Test
   public void testRegistrationPage() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(1)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));
      ModelAndView actual = underTest.registrationPage();

      validateTitleView("Hobby Club Registration", PAGE_REGISTRATION, actual);
      assertEquals(6, actual.getModel().size());
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(5, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown2");
      assertEquals(5, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(5, actualSO.size());
   }

   @Test
   public void testRegisterNewMember() {
      when(accountService.checkNickName("Gary")).thenReturn(Boolean.FALSE);
      RegistrationForm regForm = buildRegistrationForm("Gary", "Deken", "Gary", "12", "45", "password123");
      addInterests(regForm, "Books", "Games", "Photography");
      when(accountService.createNewAccount(regForm)).thenReturn(buildAccount(11));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));
      when(clubService.getYourCreatedClubs(11)).thenReturn(new ArrayList<>());
      when(clubService.getYourJoinedClubs(11)).thenReturn(new ArrayList<>());
      when(topicService.getTopicsForUser(11, 0)).thenReturn(new ArrayList<>());

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateSetUpHomePage(actual);
      verify(session).setAttribute(eq("userAccount"), any(Account.class));
      List<ClubDisplay> actualYC = (List<ClubDisplay>) actual.getModel().get("yourCreatedClubs");
      assertEquals(0, actualYC.size());
      actualYC = (List<ClubDisplay>) actual.getModel().get("yourJoinedClubs");
      assertEquals(0, actualYC.size());
      assertEquals("", actual.getModel().get("filterEvent"));
      assertEquals("", actual.getModel().get("filterTopic"));
   }

   @Test
   public void testRegisterNewMember2() {
      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "12", "45", "password123");
      addInterests(regForm, "Interest", null, null);
      when(accountService.createNewAccount(regForm)).thenReturn(buildAccount(11));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));
      when(clubService.getYourCreatedClubs(11)).thenReturn(new ArrayList<>());
      when(clubService.getYourJoinedClubs(11)).thenReturn(new ArrayList<>());
      when(topicService.getTopicsForUser(11, 0)).thenReturn(new ArrayList<>());

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateSetUpHomePage(actual);
      verify(session).setAttribute(eq("userAccount"), any(Account.class));
      List<ClubDisplay> actualYC = (List<ClubDisplay>) actual.getModel().get("yourCreatedClubs");
      assertEquals(0, actualYC.size());
      actualYC = (List<ClubDisplay>) actual.getModel().get("yourJoinedClubs");
      assertEquals(0, actualYC.size());
   }

   @Test
   public void testRegisterNewMember3() {
      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "12", "45", "password123");
      addInterests(regForm, null, "Interest", null);
      when(accountService.createNewAccount(regForm)).thenReturn(buildAccount(11));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));
      when(clubService.getYourCreatedClubs(11)).thenReturn(new ArrayList<>());
      when(clubService.getYourJoinedClubs(11)).thenReturn(new ArrayList<>());
      when(topicService.getTopicsForUser(11, 0)).thenReturn(new ArrayList<>());

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateSetUpHomePage(actual);
      verify(session).setAttribute(eq("userAccount"), any(Account.class));
      List<ClubDisplay> actualYC = (List<ClubDisplay>) actual.getModel().get("yourCreatedClubs");
      assertEquals(0, actualYC.size());
      actualYC = (List<ClubDisplay>) actual.getModel().get("yourJoinedClubs");
      assertEquals(0, actualYC.size());
   }

   @Test
   public void testRegisterNewMember4() {
      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "12", "45", "password123");
      addInterests(regForm, null, null, "Interest");
      when(accountService.createNewAccount(regForm)).thenReturn(buildAccount(11));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));
      when(clubService.getYourCreatedClubs(11)).thenReturn(new ArrayList<>());
      when(clubService.getYourJoinedClubs(11)).thenReturn(new ArrayList<>());
      when(topicService.getTopicsForUser(11, 0)).thenReturn(new ArrayList<>());

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateSetUpHomePage(actual);
      verify(session).setAttribute(eq("userAccount"), any(Account.class));
      List<ClubDisplay> actualYC = (List<ClubDisplay>) actual.getModel().get("yourCreatedClubs");
      assertEquals(0, actualYC.size());
      actualYC = (List<ClubDisplay>) actual.getModel().get("yourJoinedClubs");
      assertEquals(0, actualYC.size());
   }

   @Test
   public void testRegisterNewMemberFail1() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(1)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm(null, null, null, null, null, null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", PAGE_REGISTRATION, actual);
      assertEquals(16, actual.getModel().size());
      assertNull(actual.getModel().get("firstName"));
      assertNull(actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
      assertNull(actual.getModel().get("password"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertTrue(actualSO.get(1).getSelected());
      assertFalse(actualSO.get(8).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
      validateSelectedFalseFirstTrue(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(5, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown2");
      assertEquals(4, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(6, actualSO.size());
      validateSelectedFalse(actualSO);
      assertNotNull(actual.getModel().get("missingFirst"));
      assertNotNull(actual.getModel().get("missingLast"));
      assertNotNull(actual.getModel().get("noPass"));
      assertNotNull(actual.getModel().get("missingState"));
      assertNotNull(actual.getModel().get("missingCity"));
      assertNotNull(actual.getModel().get("missingInterest"));
   }

   @Test
   public void testRegisterNewMemberFail2() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(1)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", null, null, null, null, null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", PAGE_REGISTRATION, actual);
      assertEquals(15, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertNull(actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
      assertNull(actual.getModel().get("password"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertTrue(actualSO.get(1).getSelected());
      assertFalse(actualSO.get(8).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
      validateSelectedFalseFirstTrue(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(5, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown2");
      assertEquals(4, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(6, actualSO.size());
      validateSelectedFalse(actualSO);
      assertNotNull(actual.getModel().get("missingLast"));
      assertNotNull(actual.getModel().get("noPass"));
      assertNotNull(actual.getModel().get("missingState"));
      assertNotNull(actual.getModel().get("missingCity"));
      assertNotNull(actual.getModel().get("missingInterest"));
   }

   @Test
   public void testRegisterNewMemberFail3() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(1)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, null, null, null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", PAGE_REGISTRATION, actual);
      assertEquals(14, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
      assertNull(actual.getModel().get("password"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertTrue(actualSO.get(1).getSelected());
      assertFalse(actualSO.get(8).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
      validateSelectedFalseFirstTrue(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(5, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown2");
      assertEquals(4, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(6, actualSO.size());
      validateSelectedFalse(actualSO);
      assertNotNull(actual.getModel().get("noPass"));
      assertNotNull(actual.getModel().get("missingState"));
      assertNotNull(actual.getModel().get("missingCity"));
      assertNotNull(actual.getModel().get("missingInterest"));
   }

   @Test
   public void testRegisterNewMemberFail4() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      List<SelectOption> cities = buildSelectOptions(3);
      cities.add(0, new SelectOption("0", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", null, null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", PAGE_REGISTRATION, actual);
      assertEquals(13, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
      assertNull(actual.getModel().get("password"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(8).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(4, actualSO.size());
      assertTrue(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertFalse(actualSO.get(3).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(5, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown2");
      assertEquals(4, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(6, actualSO.size());
      validateSelectedFalse(actualSO);
      assertNotNull(actual.getModel().get("noPass"));
      assertNotNull(actual.getModel().get("missingCity"));
      assertNotNull(actual.getModel().get("missingInterest"));

   }

   @Test
   public void testRegisterNewMemberFail5() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      List<SelectOption> cities = buildSelectOptions(3);
      cities.add(0, new SelectOption("0", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", "2", null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", PAGE_REGISTRATION, actual);
      assertEquals(12, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
      assertNull(actual.getModel().get("password"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(8).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(4, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(3).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(5, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown2");
      assertEquals(4, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(6, actualSO.size());
      validateSelectedFalse(actualSO);
      assertNotNull(actual.getModel().get("noPass"));
      assertNotNull(actual.getModel().get("missingInterest"));
   }

   @Test
   public void testRegisterNewMemberFail6() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(1)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, null, null, null);
      addInterests(regForm, null, "2", null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", PAGE_REGISTRATION, actual);
      assertEquals(13, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
      assertNull(actual.getModel().get("password"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertTrue(actualSO.get(1).getSelected());
      assertFalse(actualSO.get(8).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
      validateSelectedFalseFirstTrue(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(5, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown2");
      assertEquals(4, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(2).getSelected());
      assertFalse(actualSO.get(3).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(6, actualSO.size());
      validateSelectedFalse(actualSO);
      assertNotNull(actual.getModel().get("noPass"));
      assertNotNull(actual.getModel().get("missingState"));
      assertNotNull(actual.getModel().get("missingCity"));
   }

   @Test
   public void testRegisterNewMemberFail7() {
      when(accountService.checkNickName("Taken")).thenReturn(Boolean.TRUE);
      when(accountService.getRandomNickName("First")).thenReturn("First123");
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      List<SelectOption> cities = buildSelectOptions(3);
      cities.add(0, new SelectOption("0", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", "Taken", "8", "2", null);
      addInterests(regForm, "2", null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", PAGE_REGISTRATION, actual);
      assertEquals(13, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertEquals("Taken", actual.getModel().get("nickName"));
      assertEquals("true", actual.getModel().get("takenNick"));
      assertNotNull(actual.getModel().get("nickAlternative"));
      assertNull(actual.getModel().get("password"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(8).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(4, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(3).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(5, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(2).getSelected());
      assertFalse(actualSO.get(3).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown2");
      assertEquals(4, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(6, actualSO.size());
      validateSelectedFalse(actualSO);
      assertNotNull(actual.getModel().get("noPass"));
   }

   @Test
   public void testRegisterNewMemberFail8() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      List<SelectOption> cities = buildSelectOptions(3);
      cities.add(0, new SelectOption("0", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", "2", "pass");
      addInterests(regForm, "2", null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", PAGE_REGISTRATION, actual);
      assertEquals(11, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
      assertEquals("pass", actual.getModel().get("password"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(8).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(4, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(3).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(5, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(2).getSelected());
      assertFalse(actualSO.get(3).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown2");
      assertEquals(4, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(6, actualSO.size());
      validateSelectedFalse(actualSO);
      assertNotNull(actual.getModel().get("shortPass"));
   }

   @Test
   public void testRegisterNewMemberFail9() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      List<SelectOption> cities = buildSelectOptions(3);
      cities.add(0, new SelectOption("0", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", "2", "           ");
      addInterests(regForm, "2", null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", PAGE_REGISTRATION, actual);
      assertEquals(11, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
      assertEquals("           ", actual.getModel().get("password"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(8).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(4, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(3).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(5, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(2).getSelected());
      assertFalse(actualSO.get(3).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown2");
      assertEquals(4, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(6, actualSO.size());
      validateSelectedFalse(actualSO);
      assertNotNull(actual.getModel().get("noPass"));
   }

   @Test
   public void testRegisterNewMemberFail10() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      List<SelectOption> cities = buildSelectOptions(3);
      cities.add(0, new SelectOption("0", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", "2", "     pass      ");
      addInterests(regForm, "2", null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", PAGE_REGISTRATION, actual);
      assertEquals(11, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
      assertEquals("     pass      ", actual.getModel().get("password"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(8).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(4, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(3).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(5, actualSO.size());
      assertFalse(actualSO.get(0).getSelected());
      assertFalse(actualSO.get(1).getSelected());
      assertTrue(actualSO.get(2).getSelected());
      assertFalse(actualSO.get(3).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown2");
      assertEquals(4, actualSO.size());
      validateSelectedFalse(actualSO);
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(6, actualSO.size());
      validateSelectedFalse(actualSO);
      assertNotNull(actual.getModel().get("shortPass"));
   }

   @Test
   public void testUserHomePage() {
      Account account = buildAccount(10);
      Club club = buildClub(23, "Club 23");
      List<ClubDisplay> createdClubs = new ArrayList<>();
      createdClubs.add(buildClubDisplay("12", "Name1"));
      createdClubs.add(buildClubDisplay("23", "Name2"));
      List<ClubDisplay> joinedClubs = new ArrayList<>();
      joinedClubs.add(buildClubDisplay("11", "Name11"));
      joinedClubs.add(buildClubDisplay("12", "Name12"));
      joinedClubs.add(buildClubDisplay("13", "Name13"));
      List<EventDisplay> yourEvents = new ArrayList<>();
      yourEvents.add(buildEventDisplay(1, "Title1", club));
      yourEvents.add(buildEventDisplay(2, "Title2", club));
      List<TopicDisplay> yourTopics = new ArrayList<>();
      yourTopics.add(buildTopicDisplay("100"));
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));
      when(clubService.getYourCreatedClubs(10)).thenReturn(createdClubs);
      when(clubService.getYourJoinedClubs(10)).thenReturn(joinedClubs);
      when(eventService.getEventsForUserClubs(account, 0)).thenReturn(yourEvents);
      when(eventService.getEventsForUsers(account, 0)).thenReturn(yourEvents);
      when(topicService.getTopicsForUser(10, 0)).thenReturn(yourTopics);

      ModelAndView actual = underTest.userHomePage(session);

      validateSetUpHomePage(actual);
      List<ClubDisplay> actualYC = (List<ClubDisplay>) actual.getModel().get("yourCreatedClubs");
      assertEquals(2, actualYC.size());
      assertEquals("12", actualYC.get(0).getId());
      assertEquals("Name1", actualYC.get(0).getTitle());
      assertEquals("23", actualYC.get(1).getId());
      assertEquals("Name2", actualYC.get(1).getTitle());
      actualYC = (List<ClubDisplay>) actual.getModel().get("selectEventTopic");
      assertEquals(4, actualYC.size());
      ClubDisplay actualCD = actualYC.get(0);
      assertEquals("0", actualCD.getId());
      assertEquals("All", actualCD.getTitle());
      actualYC = (List<ClubDisplay>) actual.getModel().get("yourJoinedClubs");
      assertEquals(3, actualYC.size());
      assertEquals("11", actualYC.get(0).getId());
      assertEquals("Name11", actualYC.get(0).getTitle());
      assertEquals("12", actualYC.get(1).getId());
      assertEquals("Name12", actualYC.get(1).getTitle());
      assertEquals("13", actualYC.get(2).getId());
      assertEquals("Name13", actualYC.get(2).getTitle());
      assertEquals("", actual.getModel().get("filterEvent"));
      assertEquals("", actual.getModel().get("filterTopic"));
      List<EventDisplay> actualYE = (List<EventDisplay>) actual.getModel().get("yourClubEvents");
      assertEquals(2, actualYE.size());
      actualYE = (List<EventDisplay>) actual.getModel().get("yourEvents");
      assertEquals(2, actualYE.size());
      List<TopicDisplay> actualYT = (List<TopicDisplay>) actual.getModel().get("yourTopics");
      assertEquals(1, actualYT.size());
   }

   @Test
   public void testUserHomePageFiltering() {
      Account account = buildAccount(10);
      Club club = buildClub(23, "Club 23");
      List<ClubDisplay> createdClubs = new ArrayList<>();
      createdClubs.add(buildClubDisplay("12", "Name1"));
      createdClubs.add(buildClubDisplay("23", "Name2"));
      List<ClubDisplay> joinedClubs = new ArrayList<>();
      joinedClubs.add(buildClubDisplay("11", "Name11"));
      joinedClubs.add(buildClubDisplay("12", "Name12"));
      joinedClubs.add(buildClubDisplay("13", "Name13"));
      joinedClubs.add(buildClubDisplay("14", "Name14"));
      joinedClubs.add(buildClubDisplay("15", "Name15"));
      List<EventDisplay> yourEvents = new ArrayList<>();
      yourEvents.add(buildEventDisplay(1, "Title1", club));
      yourEvents.add(buildEventDisplay(2, "Title2", club));
      List<TopicDisplay> yourTopics = new ArrayList<>();
      yourTopics.add(buildTopicDisplay("100"));
      when(session.getAttribute("userAccount")).thenReturn(account);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));
      when(clubService.getYourCreatedClubs(10)).thenReturn(createdClubs);
      when(clubService.getYourJoinedClubs(10)).thenReturn(joinedClubs);
      when(eventService.getEventsForUserClubs(account, 12)).thenReturn(yourEvents);
      when(eventService.getEventsForUsers(account, 12)).thenReturn(yourEvents);
      when(topicService.getTopicsForUser(10, 14)).thenReturn(yourTopics);

      UserFilterForm filterForm = new UserFilterForm();
      filterForm.setFilterEvent("12");
      filterForm.setFilterTopic("14");

      ModelAndView actual = underTest.userHomePageFiltering(filterForm, session);

      validateSetUpHomePage(actual);
      assertEquals("12", actual.getModel().get("filterEvent"));
      assertEquals("14", actual.getModel().get("filterTopic"));
      List<ClubDisplay> actualYC = (List<ClubDisplay>) actual.getModel().get("selectEventTopic");
      assertEquals(6, actualYC.size());
      ClubDisplay actualCD = actualYC.get(2);
      assertTrue(actualCD.getEventSelected());
      assertFalse(actualCD.getTopicSelected());
      actualCD = actualYC.get(3);
      assertFalse(actualCD.getEventSelected());
      assertFalse(actualCD.getTopicSelected());
      actualCD = actualYC.get(4);
      assertFalse(actualCD.getEventSelected());
      assertTrue(actualCD.getTopicSelected());
      List<EventDisplay> actualYE = (List<EventDisplay>) actual.getModel().get("selectEventTopic");
      assertEquals(6, actualYE.size());
      actualYE = (List<EventDisplay>) actual.getModel().get("yourEvents");
      assertEquals(2, actualYE.size());
      List<TopicDisplay> actualYT = (List<TopicDisplay>) actual.getModel().get("yourTopics");
      assertEquals(1, actualYT.size());
   }

   private void addInterests(RegistrationForm regForm, String ints1, String ints2, String ints3) {
      regForm.setInterestOne(ints1);
      regForm.setInterestTwo(ints2);
      regForm.setInterestThree(ints3);
   }

   private LogInForm buildLogInForm(String nick, String pass) {
      LogInForm form = new LogInForm();
      form.setNickName(nick);
      form.setPassword(pass);
      return form;
   }

   private RegistrationForm buildRegistrationForm(String first, String last, String nick, String state, String city,
      String password) {
      RegistrationForm regForm = new RegistrationForm();
      regForm.setFirstName(first);
      regForm.setLastName(last);
      regForm.setNickName(nick);
      regForm.setPassword(password);
      regForm.setStateId(state);
      regForm.setCityId(city);

      return regForm;
   }

   private void validateSelectedFalseFirstTrue(List<SelectOption> so) {
      assertTrue(so.get(0).getSelected());
      for (int i = 1; i < so.size(); i++) {
         SelectOption selectOption = so.get(i);
         assertFalse(selectOption.getSelected());
      }
   }

   private void validateSelectedFalse(List<SelectOption> so) {
      for (SelectOption selectOption : so) {
         assertFalse(selectOption.getSelected());
      }
   }

   private void validateSetUpHomePage(ModelAndView actual) {
      assertEquals("Hobby Club Home Page for Nick", actual.getModel().get("title"));
      assertEquals(PAGE_USERHOME, actual.getViewName());
      assertEquals(USER_PAGE_SIZE, actual.getModel().size());
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick - Home Page", actual.getModel().get("navTitle"));
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(4, actualSO.size());
      validateSelectedFalse(actualSO);
   }

}
