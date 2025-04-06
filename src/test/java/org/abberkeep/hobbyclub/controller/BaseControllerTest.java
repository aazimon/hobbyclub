/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.web.servlet.ModelAndView;

/**
 * Title: BaseControllerTest
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
public abstract class BaseControllerTest {

   protected void validateTitleView(String expectedTitle, String expectedView, ModelAndView actual) {
      assertEquals(expectedTitle, actual.getModel().get("title"));
      assertEquals(expectedView, actual.getViewName());
   }

}
