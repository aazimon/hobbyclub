/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

   @RequestMapping("/")
   public String indexPage(Map<String, Object> model) {
//      ModelAndView mv = new ModelAndView();
//      mv.setViewName("index");
//      mv.getModel().put("data", "Welcome home man");
//      model.put("data", "Home page");
      System.out.println("Home page");

      return "lobby";
   }

}
