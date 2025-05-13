/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import org.abberkeep.hobbyclub.controller.dto.SelectOption;
import java.util.List;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.springframework.util.StringUtils;
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

   protected List<SelectOption> setSelected(List<SelectOption> options, String value) {
      String valueId = "1";
      if (StringUtils.hasText(value)) {
         valueId = value;
      }

      return setSelectedAt(options, valueId);
   }

   protected List<SelectOption> setSelectedAt(List<SelectOption> options, String value) {
      for (SelectOption opt : options) {
         if (opt.getValue().equals(value)) {
            opt.setSelected(true);
            break;
         }
      }

      return options;
   }

   protected void setUserLoggedIn(ModelAndView mv, Account account) {
      mv.getModel().put("loginUser", "true");
      mv.getModel().put("nickName", account.getNickName());
   }

}
