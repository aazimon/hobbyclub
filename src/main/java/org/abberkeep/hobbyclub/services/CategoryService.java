/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.util.Optional;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title: CategoryService
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 9, 2025
 * @author Gary Deken
 * @version
 */
@Service
public class CategoryService {
   private static final Logger log = LoggerFactory.getLogger(CategoryService.class);
   @Autowired
   private CategoryRepository categoryRepository;

   public Category getCategoryById(Integer categoryId) {
      Optional<Category> opt = categoryRepository.findById(categoryId);

      if (opt.isEmpty()) {
         log.error("Category not found by ID {}, Returning null", categoryId);
      }

      return opt.get();
   }

}
