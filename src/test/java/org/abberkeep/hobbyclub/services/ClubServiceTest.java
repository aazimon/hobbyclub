/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import org.abberkeep.hobbyclub.TestUtils;
import org.abberkeep.hobbyclub.controller.SelectOption;
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
public class ClubServiceTest {
   @Mock
   private CategoryRepository categoryRepository;
   @InjectMocks
   private ClubService underTest;

   @BeforeEach
   public void setUp() {
   }

   @Test
   public void testGetCategories() {
      List<Category> categories = TestUtils.buildCategories(6);
      when(categoryRepository.findAllByOrderByNameAsc()).thenReturn(categories);

      List<SelectOption> actual = underTest.getCategories();

      assertEquals(categories.size() + 1, actual.size());
      assertEquals("", actual.get(0).getValue());
      assertEquals("Any", actual.get(0).getLabel());
      assertEquals(categories.get(0).getCategoryId().toString(), actual.get(1).getValue());
      assertEquals(categories.get(0).getName(), actual.get(1).getLabel());
      assertEquals(categories.get(1).getCategoryId().toString(), actual.get(2).getValue());
      assertEquals(categories.get(1).getName(), actual.get(2).getLabel());
      assertEquals(categories.get(5).getCategoryId().toString(), actual.get(6).getValue());
      assertEquals(categories.get(5).getName(), actual.get(6).getLabel());
   }

}
