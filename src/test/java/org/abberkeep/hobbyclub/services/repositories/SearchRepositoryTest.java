/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.services.repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import org.abberkeep.hobbyclub.services.TestBaseService;
import org.abberkeep.hobbyclub.services.domains.Club;
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
public class SearchRepositoryTest extends TestBaseService {
   private static final String SQL_START = "SELECT c.* FROM clubs c JOIN userclubs uc ON c.club_id = uc.club_id ";
   private static final String SQL_ORDER = "GROUP BY c.club_id ORDER BY COUNT(uc.account_id) DESC, c.create_datetime DESC";
   @Mock
   private EntityManager entityManager;
   @Mock
   private Query query;
   @InjectMocks
   private SearchRepository underTest;

   @Test
   public void testSearchClubsNone() {
      String sql = SQL_START + SQL_ORDER;
      when(entityManager.createNativeQuery(sql, Club.class)).thenReturn(query);
      when(query.setFirstResult(0)).thenReturn(query);
      when(query.setMaxResults(11)).thenReturn(query);
      when(query.getResultList()).thenReturn(buildClubs(3));

      List<Club> actual = underTest.searchClubs("", 0, 0, 0, PageRequest.of(0, 11));

      assertEquals(3, actual.size());
   }

   @Test
   public void testSearchClubsState() {
      String sql = SQL_START + "WHERE c.state_id = :stateId " + SQL_ORDER;
      when(entityManager.createNativeQuery(sql, Club.class)).thenReturn(query);
      when(query.setParameter("stateId", 4)).thenReturn(query);
      when(query.setFirstResult(0)).thenReturn(query);
      when(query.setMaxResults(11)).thenReturn(query);
      when(query.getResultList()).thenReturn(buildClubs(3));

      List<Club> actual = underTest.searchClubs("", 0, 4, 0, PageRequest.of(0, 11));

      assertEquals(3, actual.size());
   }

   @Test
   public void testSearchClubsStateCity() {
      String sql = SQL_START + "WHERE c.state_id = :stateId AND c.city_id = :cityId " + SQL_ORDER;
      when(entityManager.createNativeQuery(sql, Club.class)).thenReturn(query);
      when(query.setParameter("stateId", 4)).thenReturn(query);
      when(query.setParameter("cityId", 24)).thenReturn(query);
      when(query.setFirstResult(0)).thenReturn(query);
      when(query.setMaxResults(11)).thenReturn(query);
      when(query.getResultList()).thenReturn(buildClubs(3));

      List<Club> actual = underTest.searchClubs("", 0, 4, 24, PageRequest.of(0, 11));

      assertEquals(3, actual.size());
   }

   @Test
   public void testSearchClubsTitle() {
      String sql = SQL_START + "WHERE LOWER(c.name) LIKE :title " + SQL_ORDER;
      when(entityManager.createNativeQuery(sql, Club.class)).thenReturn(query);
      when(query.setParameter("title", "%title%")).thenReturn(query);
      when(query.setFirstResult(0)).thenReturn(query);
      when(query.setMaxResults(11)).thenReturn(query);
      when(query.getResultList()).thenReturn(buildClubs(3));

      List<Club> actual = underTest.searchClubs("Title", 0, 0, 0, PageRequest.of(0, 11));

      assertEquals(3, actual.size());
   }

   @Test
   public void testSearchClubsTitleCategory() {
      String sql = SQL_START + "WHERE LOWER(c.name) LIKE :title AND c.category_id = :categoryId " + SQL_ORDER;
      when(entityManager.createNativeQuery(sql, Club.class)).thenReturn(query);
      when(query.setParameter("title", "%title%")).thenReturn(query);
      when(query.setParameter("categoryId", 3)).thenReturn(query);
      when(query.setFirstResult(0)).thenReturn(query);
      when(query.setMaxResults(11)).thenReturn(query);
      when(query.getResultList()).thenReturn(buildClubs(3));

      List<Club> actual = underTest.searchClubs("Title", 3, 0, 0, PageRequest.of(0, 11));

      assertEquals(3, actual.size());
   }

}
