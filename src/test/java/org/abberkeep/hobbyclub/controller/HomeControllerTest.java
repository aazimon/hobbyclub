/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;
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
   @Mock
   private ClubService clubService;
   @Mock
   private LocationService locationService;
   @Mock
   private HttpSession session;
   @InjectMocks
   private HomeController underTest;

   @BeforeEach
   public void setUp() {
   }

   @Test
   public void testIndexPage() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(10));
      when(locationService.getCitiesByStateId(1)).thenReturn(buildSelectOptions(3));
      when(clubService.getCategories("Any")).thenReturn(buildSelectOptions(4));
      ModelAndView actual = underTest.indexPage(session);

      validateTitleView("Hobby Club", "lobby", actual);
      //assertEquals("-", actual.getModel().get("loginId"));

      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(10, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("cityDropDown");
      assertEquals(3, actualSO.size());
      actualSO = (List<SelectOption>) actual.getModel().get("categoryDropDown");
      assertEquals(4, actualSO.size());
   }

   @Test
   public void testGetCities() {
      when(locationService.getCitiesByStateId(12)).thenReturn(buildSelectOptions(3));

      List<SelectOption> actual = underTest.getCities("12");

      assertEquals(3, actual.size());
   }

}
