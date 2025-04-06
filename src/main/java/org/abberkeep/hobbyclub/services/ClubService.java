/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.util.ArrayList;
import java.util.List;
import org.abberkeep.hobbyclub.controller.SelectOption;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title: ClubService
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 6, 2025
 * @author Gary Deken
 * @version
 */
@Service
public class ClubService {
   @Autowired
   private CategoryRepository categoryRepository;

   public List<SelectOption> getCategories() {
      List<Category> cats = categoryRepository.findAllByOrderByNameAsc();
      List<SelectOption> display = new ArrayList<>();

      display.add(new SelectOption("", "Any"));
      cats.forEach(category -> display.add(new SelectOption(category.getCategoryId().toString(), category.getName())));

      return display;
   }

}
