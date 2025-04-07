/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import org.abberkeep.hobbyclub.services.AccountService;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.LocationService;
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
public class AccountControllerTest extends BaseControllerTest {
   @Mock
   private ClubService clubService;
   @Mock
   private LocationService locationService;
   @Mock
   private AccountService accountService;
   @InjectMocks
   private AccountController underTest;

   @BeforeEach
   public void setUp() {
   }

   @Test
   public void testRegistrationPage() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(1)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories()).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
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
      assertEquals(4, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown3");
      assertEquals(6, actualSO.size());
   }

   @Test
   public void testRegisterNewMember1() {
      when(accountService.checkNickName("Gary")).thenReturn(Boolean.FALSE);
      RegistrationForm regForm = buildRegistrationForm("Gary", "Deken", "Gary", "MO", "St Louis");
      addInterests(regForm, "Books", "Games", "Photography");

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "userhome", actual);
   }

   @Test
   public void testRegisterNewMember2() {
      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "12", "45");
      addInterests(regForm, "Interest", null, null);

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "userhome", actual);
      assertEquals(1, actual.getModel().size());
   }

   @Test
   public void testRegisterNewMember3() {
      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "12", "45");
      addInterests(regForm, null, "Interest", null);

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "userhome", actual);
      assertEquals(1, actual.getModel().size());
   }

   @Test
   public void testRegisterNewMember4() {
      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "12", "45");
      addInterests(regForm, null, null, "Interest");

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "userhome", actual);
      assertEquals(1, actual.getModel().size());
   }

   @Test
   public void testRegisterNewMemberFail1() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(1)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories()).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm(null, null, null, null, null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "registration", actual);
      assertEquals(14, actual.getModel().size());
      assertNull(actual.getModel().get("firstName"));
      assertNull(actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
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
      assertNotNull(actual.getModel().get("missingState"));
      assertNotNull(actual.getModel().get("missingCity"));
      assertNotNull(actual.getModel().get("missingInterest"));
   }

   @Test
   public void testRegisterNewMemberFail2() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(1)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories()).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", null, null, null, null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "registration", actual);
      assertEquals(13, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertNull(actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
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
      assertNotNull(actual.getModel().get("missingState"));
      assertNotNull(actual.getModel().get("missingCity"));
      assertNotNull(actual.getModel().get("missingInterest"));
   }

   @Test
   public void testRegisterNewMemberFail3() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(1)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories()).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, null, null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "registration", actual);
      assertEquals(12, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
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
      when(clubService.getCategories()).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "registration", actual);
      assertEquals(11, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
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
      assertNotNull(actual.getModel().get("missingCity"));
      assertNotNull(actual.getModel().get("missingInterest"));

   }

   @Test
   public void testRegisterNewMemberFail5() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      List<SelectOption> cities = buildSelectOptions(3);
      cities.add(0, new SelectOption("*", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories()).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, "8", "2");
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "registration", actual);
      assertEquals(10, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
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
      assertNotNull(actual.getModel().get("missingInterest"));
   }

   @Test
   public void testRegisterNewMemberFail6() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(1)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories()).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", null, null, null);
      addInterests(regForm, null, "2", null);

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "registration", actual);
      assertEquals(11, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertNull(actual.getModel().get("nickName"));
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
      assertNotNull(actual.getModel().get("missingState"));
      assertNotNull(actual.getModel().get("missingCity"));
   }

   @Test
   public void testRegisterNewMemberFail7() {
      when(accountService.checkNickName("Taken")).thenReturn(Boolean.TRUE);
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      List<SelectOption> cities = buildSelectOptions(3);
      cities.add(0, new SelectOption("*", "Any City"));
      when(locationService.getCitiesByStateId(8)).thenReturn(cities);
      when(clubService.getCategories()).thenReturn(buildSelectOptions(5)).thenReturn(buildSelectOptions(4)).thenReturn(
         buildSelectOptions(6));

      RegistrationForm regForm = buildRegistrationForm("First", "Last", "Taken", "8", "2");
      addInterests(regForm, "2", null, null);

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "registration", actual);
      assertEquals(10, actual.getModel().size());
      assertEquals("First", actual.getModel().get("firstName"));
      assertEquals("Last", actual.getModel().get("lastName"));
      assertEquals("Taken", actual.getModel().get("nickName"));
      assertEquals("true", actual.getModel().get("takenNick"));
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
   }

   private void addInterests(RegistrationForm regForm, String ints1, String ints2, String ints3) {
      regForm.setInterestOne(ints1);
      regForm.setInterestTwo(ints2);
      regForm.setInterestThree(ints3);
   }

   private RegistrationForm buildRegistrationForm(String first, String last, String nick, String state, String city) {
      RegistrationForm regForm = new RegistrationForm();
      regForm.setFirstName(first);
      regForm.setLastName(last);
      regForm.setNickName(nick);
      regForm.setStateId(state);
      regForm.setCityId(city);

      return regForm;
   }

}
