/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.abberkeep.hobbyclub.services.AccountService;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.LocationService;
import org.abberkeep.hobbyclub.services.domains.Account;
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
   @Mock
   private ClubService clubService;
   @Mock
   private LocationService locationService;
   @Mock
   private AccountService accountService;
   @Mock
   private HttpSession session;
   @InjectMocks
   private AccountController underTest;

   @BeforeEach
   public void setUp() {
   }

   @Test
   public void testLoginHobbyClub() {
      Account acc = buildAccount(11);
      when(accountService.getAccountByNickNamePassword("Nick", "Pass")).thenReturn(acc);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));
      ModelAndView actual = underTest.loginHobbyClub(buildLogInForm("Nick", "Pass"), session);

      validateTitleView("Hobby Club Home Page for Nick", "userhome", actual);
      assertEquals(5, actual.getModel().size());
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      verify(session).setAttribute("userAccount", acc);
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(4, actualSO.size());
   }

   @Test
   public void testLoginHobbyClubFail1() {
      ModelAndView actual = underTest.loginHobbyClub(buildLogInForm(null, null), session);

      validateTitleView("Log in to Hobby Club", "login", actual);
      assertEquals(5, actual.getModel().size());
      assertEquals("true", actual.getModel().get("missingNick"));
      assertEquals("true", actual.getModel().get("missingPass"));
      assertNull(actual.getModel().get("password"));
   }

   @Test
   public void testLoginHobbyClubFail2() {
      when(accountService.getAccountByNickNamePassword("Nick", "Pass")).thenReturn(null);
      ModelAndView actual = underTest.loginHobbyClub(buildLogInForm("Nick", "Pass"), session);

      validateTitleView("Log in to Hobby Club", "login", actual);
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

      validateTitleView("Hobby Club Registration", "registration", actual);
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
   public void testRegisterNewMember1() {
      when(accountService.checkNickName("Gary")).thenReturn(Boolean.FALSE);
      RegistrationForm regForm = buildRegistrationForm("Gary", "Deken", "Gary", "12", "45", "password123");
      addInterests(regForm, "Books", "Games", "Photography");
      when(accountService.createNewAccount(regForm)).thenReturn(buildAccount(11));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Home Page for Nick", "userhome", actual);
      assertEquals(5, actual.getModel().size());
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      verify(session).setAttribute(eq("userAccount"), any(Account.class));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(4, actualSO.size());
   }

   @Test
   public void testRegisterNewMember2() {
      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "12", "45", "password123");
      addInterests(regForm, "Interest", null, null);
      when(accountService.createNewAccount(regForm)).thenReturn(buildAccount(11));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Home Page for Nick", "userhome", actual);
      assertEquals(5, actual.getModel().size());
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      verify(session).setAttribute(eq("userAccount"), any(Account.class));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(4, actualSO.size());
   }

   @Test
   public void testRegisterNewMember3() {
      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "12", "45", "password123");
      addInterests(regForm, null, "Interest", null);
      when(accountService.createNewAccount(regForm)).thenReturn(buildAccount(11));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Home Page for Nick", "userhome", actual);
      assertEquals(5, actual.getModel().size());
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      verify(session).setAttribute(eq("userAccount"), any(Account.class));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(4, actualSO.size());
   }

   @Test
   public void testRegisterNewMember4() {
      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "12", "45", "password123");
      addInterests(regForm, null, null, "Interest");
      when(accountService.createNewAccount(regForm)).thenReturn(buildAccount(11));
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(4));

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Home Page for Nick", "userhome", actual);
      assertEquals(5, actual.getModel().size());
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      verify(session).setAttribute(eq("userAccount"), any(Account.class));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(4, actualSO.size());
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

      validateTitleView("Hobby Club Registration", "registration", actual);
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
      validateSelectedFalse(actualSO);
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

      validateTitleView("Hobby Club Registration", "registration", actual);
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
      validateSelectedFalse(actualSO);
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

      validateTitleView("Hobby Club Registration", "registration", actual);
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
      validateSelectedFalse(actualSO);
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
      cities.add(0, new SelectOption("*", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", null, null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", "registration", actual);
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
      cities.add(0, new SelectOption("*", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", "2", null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", "registration", actual);
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

      validateTitleView("Hobby Club Registration", "registration", actual);
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
      validateSelectedFalse(actualSO);
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
      cities.add(0, new SelectOption("*", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", "Taken", "8", "2", null);
      addInterests(regForm, "2", null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", "registration", actual);
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
      cities.add(0, new SelectOption("*", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", "2", "pass");
      addInterests(regForm, "2", null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", "registration", actual);
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
      cities.add(0, new SelectOption("*", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", "2", "           ");
      addInterests(regForm, "2", null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", "registration", actual);
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
      cities.add(0, new SelectOption("*", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories("Choose")).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", "2", "     pass      ");
      addInterests(regForm, "2", null, null);

      ModelAndView actual = underTest.registerNewMember(regForm, session);

      validateTitleView("Hobby Club Registration", "registration", actual);
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

}
