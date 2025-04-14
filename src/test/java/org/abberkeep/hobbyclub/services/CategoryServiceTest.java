/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Gary Deken
 */
@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest extends TestBaseService {
   private Category expectedCategory;
   @Mock
   private CategoryRepository categoryRepository;
   @InjectMocks
   private CategoryService underTest;

   @BeforeEach
   public void setUp() {
      expectedCategory = buildCategory(34, "Category");
   }

   @Test
   public void testGetCategoryById() {
      when(categoryRepository.findById(23)).thenReturn(Optional.of(expectedCategory));

      Category actual = underTest.getCategoryById(23);

      assertEquals(expectedCategory, actual);
   }

}
