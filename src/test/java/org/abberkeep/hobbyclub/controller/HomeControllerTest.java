/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
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
public class HomeControllerTest extends BaseControllerTest {
   @Mock
   private LocationService locationService;
   @InjectMocks
   private HomeController underTest;

   @BeforeEach
   public void setUp() {
   }

   @Test
   public void testIndexPage() {
      when(locationService.getAllStates()).thenReturn(buildSelectOptions(3));
      ModelAndView actual = underTest.indexPage();

      validateTitleView("Hobby Club", "lobby", actual);
      //assertEquals("-", actual.getModel().get("loginId"));
      validateOptionList((String) actual.getModel().get("categoryDropDown"), "Books");

      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(3, actualSO.size());
   }

   @Test
   public void testGetCities() {
      when(locationService.getCitiesByStateId(12)).thenReturn(buildSelectOptions(3));

      List<SelectOption> actual = underTest.getCities("12");

      assertEquals(3, actual.size());
   }

   private List<SelectOption> buildSelectOptions(int number) {
      List<SelectOption> so = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         so.add(new SelectOption("1" + i, "ST" + i));
      }

      return so;
   }

}
