/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.abberkeep.hobbyclub.TestBase;
import org.abberkeep.hobbyclub.controller.dto.ClubDisplay;
import org.abberkeep.hobbyclub.controller.dto.TopicDisplay;
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
public abstract class TestBaseController extends TestBase {

   protected ClubDisplay buildClubDisplay(String id, String title) {
      return new ClubDisplay(id, title, "This is a basic Description");
   }

   protected List<SelectOption> buildSelectOptions(int number) {
      List<SelectOption> so = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         so.add(new SelectOption("" + i, "ST" + i));
      }

      return so;
   }

   protected TopicDisplay buildTopicDisplay(String topicId) {
      TopicDisplay td = new TopicDisplay();

      td.setTopicId(topicId);
      td.setMessage("Topic Message");
      td.setPostDate("04/21/2025 19:15");
      td.setPoster("Sam the Member");

      return td;
   }

   protected void validateTitleView(String expectedTitle, String expectedView, ModelAndView actual) {
      assertEquals(expectedTitle, actual.getModel().get("title"));
      assertEquals(expectedView, actual.getViewName());
   }

}
