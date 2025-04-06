/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import org.springframework.web.servlet.ModelAndView;

/**
 * Title: BaseController
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
public class BaseController {

   protected ModelAndView getModelAndView(String title, String view) {
      ModelAndView mv = new ModelAndView();

      mv.getModel().put("title", title);
      mv.setViewName(view);

      return mv;
   }

}
