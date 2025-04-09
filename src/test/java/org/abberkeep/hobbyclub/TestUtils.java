/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.abberkeep.hobbyclub.services.domains.Category;

/**
 * Title: TestUtils
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 6, 2025
 * @author Gary Deken
 * @version
 */
public class TestUtils {

   public static List<Category> buildCategories(int number) {
      List<Category> cats = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         cats.add(new Category(i + 1, "Cat" + i + " Club", LocalDateTime.now()));
      }

      return cats;
   }

}
