/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.abberkeep.hobbyclub.controller.SelectOption;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.State;

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

   public static List<City> buildCities(int number) {
      List<City> cities = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         cities.add(new City(i + 1, "City" + i, new State(12, "ST12", LocalDateTime.now()), LocalDateTime.now()));
      }

      return cities;
   }

   public static List<SelectOption> buildSelectOptions(int number) {
      List<SelectOption> so = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         so.add(new SelectOption("1" + i, "ST" + i));
      }

      return so;
   }

   public static List<State> buildStates(int number) {
      List<State> states = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         states.add(new State(i + 1, "ST" + i, LocalDateTime.now()));
      }

      return states;
   }

}
