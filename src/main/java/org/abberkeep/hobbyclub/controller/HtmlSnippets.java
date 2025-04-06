/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import java.util.List;

/**
 * Title: HtmlSnippets
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 4, 2025
 * @author Gary Deken
 * @version
 */
public class HtmlSnippets {

   public static String getCategoryOptions(List<String> categories) {
      StringBuilder str = new StringBuilder();

      for (String category : categories) {
         str.append("<option value=\"").append(category).append("\">").append(category).append("</option>\n");
      }

      return str.toString();
   }

}
