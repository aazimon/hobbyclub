/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.abberkeep.hobbyclub.controller.dto.ClubDisplay;
import org.abberkeep.hobbyclub.controller.dto.ClubRow;
import org.abberkeep.hobbyclub.controller.dto.SearchForm;
import org.abberkeep.hobbyclub.services.ClubSearchService;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.LocationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * Title: HomeControllerTest</p>
 *
 * <p>
 * Description: This tests the methods of the HomeControllerTest class.</p>
 *
 * Copyright: Copyright (c) Apr 5, 2025
 *
 * @author Gary Deken
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
public class HomeControllerTest extends TestBaseController {
   private static final int PAGE_HOME = 8;
   private static final int PAGE_SEARCH = 6;
   @Mock
   private ClubService clubService;
   @Mock
   private ClubSearchService clubSearchService;
   @Mock
   private LocationService locationService;
   @Mock
   private HttpSession session;
   @InjectMocks
   private HomeController underTest;

   @Test
   public void testIndexPage() {
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(clubService.getCategories("Any")).thenReturn(buildSelectOptions(4));
      when(clubSearchService.getPopularClubs()).thenReturn(buildClubDescriptions(6));

      ModelAndView actual = underTest.indexPage(session);

      validateTitleView("Hobby Club", "lobby", actual);
      assertEquals(PAGE_HOME + 1, actual.getModel().size());
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(1, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(4, actualSO.size());
      ClubDisplay actualCD = (ClubDisplay) actual.getModel().get("mostPopular");
      assertEquals("0", actualCD.getId());
      List<ClubRow> actualCDs = (List<ClubRow>) actual.getModel().get("popularClubs");
      assertEquals(2, actualCDs.size());
      ClubRow actualCR = actualCDs.get(0);
      assertEquals("1", actualCR.getFirst().getId());
      assertEquals("2", actualCR.getSecond().getId());
      actualCD = (ClubDisplay) actual.getModel().get("lastClub");
      assertEquals("5", actualCD.getId());
   }

   @Test
   public void testIndexPageNoUser() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(clubService.getCategories("Any")).thenReturn(buildSelectOptions(4));
      when(clubSearchService.getPopularClubs()).thenReturn(buildClubDescriptions(1));

      ModelAndView actual = underTest.indexPage(session);

      validateTitleView("Hobby Club", "lobby", actual);
      validateNoUserLoggedIn(actual);
   }

   @Test
   public void testGetCities() {
      when(locationService.getCitiesByStateId(12)).thenReturn(buildSelectOptions(3));

      List<SelectOption> actual = underTest.getCities("12");

      assertEquals(3, actual.size());
   }

   @Test
   public void testLogout() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(clubService.getCategories("Any")).thenReturn(buildSelectOptions(4));
      when(clubSearchService.getPopularClubs()).thenReturn(buildClubDescriptions(1));

      ModelAndView actual = underTest.logout(session);

      validateTitleView("Hobby Club", "lobby", actual);
      validateNoUserLoggedIn(actual);
      verify(session).invalidate();
   }

   @Test
   public void testSearchClubsNoEntry() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(clubService.getCategories("Any")).thenReturn(buildSelectOptions(8));
      SearchForm search = new SearchForm("", "0", "0", "0");
      when(clubSearchService.searchClubs(search)).thenReturn(buildClubDescriptions(1));

      ModelAndView actual = underTest.searchClubs(search, session);

      validateTitleView("Hobby Clubs - Search", "search", actual);
      assertEquals(PAGE_SEARCH, actual.getModel().size());
      assertEquals("", actual.getModel().get("clubName"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(1, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(8, actualSO.size());
      ClubDisplay actualCD = (ClubDisplay) actual.getModel().get("mostPopular");
      assertEquals("0", actualCD.getId());
   }

   @Test
   public void testSearchClubsTitle() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(clubService.getCategories("Any")).thenReturn(buildSelectOptions(8));
      SearchForm search = new SearchForm("Title", "0", "0", "0");
      when(clubSearchService.searchClubs(search)).thenReturn(buildClubDescriptions(1));

      ModelAndView actual = underTest.searchClubs(search, session);

      validateTitleView("Hobby Clubs - Search", "search", actual);
      assertEquals(PAGE_SEARCH, actual.getModel().size());
      assertEquals("Title", actual.getModel().get("clubName"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(1, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(8, actualSO.size());
      ClubDisplay actualCD = (ClubDisplay) actual.getModel().get("mostPopular");
      assertEquals("0", actualCD.getId());
   }

   @Test
   public void testSearchClubsCategory() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(clubService.getCategories("Any")).thenReturn(buildSelectOptions(8));
      SearchForm search = new SearchForm("", "4", "0", "0");
      when(clubSearchService.searchClubs(search)).thenReturn(buildClubDescriptions(1));

      ModelAndView actual = underTest.searchClubs(search, session);

      validateTitleView("Hobby Clubs - Search", "search", actual);
      assertEquals(PAGE_SEARCH, actual.getModel().size());
      assertEquals("", actual.getModel().get("clubName"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(1, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(8, actualSO.size());
      assertTrue(actualSO.get(4).getSelected());
      ClubDisplay actualCD = (ClubDisplay) actual.getModel().get("mostPopular");
      assertEquals("0", actualCD.getId());
   }

   @Test
   public void testSearchClubsState() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(6)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories("Any")).thenReturn(buildSelectOptions(8));
      SearchForm search = new SearchForm("", "0", "6", "0");
      when(clubSearchService.searchClubs(search)).thenReturn(buildClubDescriptions(1));

      ModelAndView actual = underTest.searchClubs(search, session);

      validateTitleView("Hobby Clubs - Search", "search", actual);
      assertEquals(PAGE_SEARCH, actual.getModel().size());
      assertEquals("", actual.getModel().get("clubName"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertTrue(actualSO.get(6).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(8, actualSO.size());
      ClubDisplay actualCD = (ClubDisplay) actual.getModel().get("mostPopular");
      assertEquals("0", actualCD.getId());
   }

   @Test
   public void testSearchClubsStateCity() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(6)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories("Any")).thenReturn(buildSelectOptions(8));
      SearchForm search = new SearchForm("", "0", "6", "2");
      when(clubSearchService.searchClubs(search)).thenReturn(buildClubDescriptions(1));

      ModelAndView actual = underTest.searchClubs(search, session);

      validateTitleView("Hobby Clubs - Search", "search", actual);
      assertEquals(PAGE_SEARCH, actual.getModel().size());
      assertEquals("", actual.getModel().get("clubName"));
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      assertTrue(actualSO.get(6).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
      assertTrue(actualSO.get(2).getSelected());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(8, actualSO.size());
      ClubDisplay actualCD = (ClubDisplay) actual.getModel().get("mostPopular");
      assertEquals("0", actualCD.getId());
   }

   private List<ClubDisplay> buildClubDescriptions(int number) {
      List<ClubDisplay> cd = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         cd.add(buildClubDisplay(Integer.toString(i), "Title" + i));
      }
      return cd;
   }

   private void validateNoUserLoggedIn(ModelAndView actual) {
      validateTitleView("Hobby Club", "lobby", actual);
      assertEquals(PAGE_HOME - 3, actual.getModel().size());
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(1, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(4, actualSO.size());
      ClubDisplay actualCD = (ClubDisplay) actual.getModel().get("mostPopular");
      assertEquals("0", actualCD.getId());
   }

}
