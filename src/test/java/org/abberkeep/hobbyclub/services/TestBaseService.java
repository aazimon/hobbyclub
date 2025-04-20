/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.util.ArrayList;
import java.util.List;
import org.abberkeep.hobbyclub.TestBase;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.State;

/**
 * Title: BaseServiceTest
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 8, 2025
 * @author Gary Deken
 * @version
 */
public class TestBaseService extends TestBase {

   protected List<Category> buildCategories(int number) {
      List<Category> cats = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         cats.add(buildCategory(i + 1, "Cat" + i + " Club"));
      }

      return cats;
   }

   protected List<City> buildCities(int number) {
      List<City> cities = new ArrayList<>();
      State state = buildState(12, "ST12");

      for (int i = 0; i < number; i++) {
         cities.add(buildCity(i, "City" + i, state));
      }

      return cities;
   }

   protected List<Club> buildClubs(int number) {
      List<Club> c = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         c.add(buildClub(i, "Title" + i));
      }
      return c;
   }

   protected List<State> buildStates(int number) {
      List<State> states = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         states.add(buildState(i, "ST" + i));
      }

      return states;
   }

}
