/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Title: HomeController
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Mar 31, 2025
 * @author Gary Deken
 * @version
 */
@Controller
public class HomeController {
   private static final Logger log = LoggerFactory.getLogger("HomeController");

   @RequestMapping("/")
   public ModelAndView indexPage() {
      log.debug("Home Page Controller");
      ModelAndView mv = new ModelAndView();
      mv.getModel().put("title", "Hobby Club");
      mv.getModel().put("loginUser", HtmlSnippets.getLoginOptions());
      mv.getModel().put("categoryDropDown", HtmlSnippets.getCategoryOptions(Arrays.asList("Books")));
      mv.getModel().put("stateDropDown", "");
      mv.getModel().put("cityDropDown", "");

      mv.setViewName("lobby");

      return mv;
   }

}
