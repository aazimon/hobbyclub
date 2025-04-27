/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import org.abberkeep.hobbyclub.controller.dto.ClubDisplay;
import org.abberkeep.hobbyclub.controller.dto.SearchForm;
import org.abberkeep.hobbyclub.services.repositories.ClubRepository;
import org.abberkeep.hobbyclub.services.repositories.SearchRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author Gary Deken
 */
@ExtendWith(MockitoExtension.class)
public class ClubSearchServiceTest extends TestBaseService {
   @Mock
   private ClubRepository clubRepository;
   @Mock
   private SearchRepository searchRepository;
   @InjectMocks
   private ClubSearchService underTest;

   @Test
   public void testGetPopularClubs() {
      when(clubRepository.findAllOrderByMemberCount(PageRequest.of(0, 11))).thenReturn(buildClubs(3));

      List<ClubDisplay> actual = underTest.getPopularClubs();

      assertEquals(3, actual.size());
   }

   @Test
   public void testGetPopularClubsLimit() {
      when(clubRepository.findAllOrderByMemberCount(PageRequest.of(0, 11))).thenReturn(buildClubs(11));

      List<ClubDisplay> actual = underTest.getPopularClubs();

      assertEquals(11, actual.size());
   }

   @Test
   public void testSearchClubsNoSelection() {
      when(searchRepository.searchClubs("", 0, 0, 0, PageRequest.of(0, 11))).thenReturn(buildClubs(3));
      SearchForm search = new SearchForm("", "0", "0", "0");

      List<ClubDisplay> actual = underTest.searchClubs(search);

      assertEquals(3, actual.size());
   }

   @Test
   public void testSearchClubs() {
      when(searchRepository.searchClubs("Title", 1, 3, 0, PageRequest.of(0, 11))).thenReturn(buildClubs(3));
      SearchForm search = new SearchForm("Title", "1", "3", "0");

      List<ClubDisplay> actual = underTest.searchClubs(search);

      assertEquals(3, actual.size());
   }

}
