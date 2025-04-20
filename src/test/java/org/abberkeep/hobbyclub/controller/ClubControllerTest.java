/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import org.abberkeep.hobbyclub.services.CategoryService;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.State;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gary Deken
 */
@ExtendWith(MockitoExtension.class)
public class ClubControllerTest extends TestBaseController {
   private static final int PAGE_CLUB = 6;
   @Mock
   private ClubService clubService;
   @Mock
   private CategoryService categoryService;
   @Mock
   private HttpSession session;
   @InjectMocks
   private ClubController underTest;

   @Test
   public void testClubHome() {
      when(clubService.getClub(23)).thenReturn(buildClub(23, "Title23"));
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.TRUE);

      ModelAndView actual = underTest.clubHome("23", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB, actual.getModel().size());
      assertEquals("Title23", actual.getModel().get("navTitle"));
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      assertEquals("true", actual.getModel().get("userClub"));
      assertEquals("23", actual.getModel().get("clubId"));

   }

   @Test
   public void testClubHomeNotInClub() {
      when(clubService.getClub(23)).thenReturn(buildClub(23, "Title23"));
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.FALSE);

      ModelAndView actual = underTest.clubHome("23", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB - 1, actual.getModel().size());
      assertEquals("Title23", actual.getModel().get("navTitle"));
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
      assertNull(actual.getModel().get("userClub"));
      assertEquals("23", actual.getModel().get("clubId"));
   }

   @Test
   public void testClubHomeNotLoggedIn() {
      when(clubService.getClub(23)).thenReturn(buildClub(23, "Title23"));
      when(session.getAttribute("userAccount")).thenReturn(null);

      ModelAndView actual = underTest.clubHome("23", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB - 3, actual.getModel().size());
      assertEquals("Title23", actual.getModel().get("navTitle"));
      assertNull(actual.getModel().get("loginUser"));
      assertNull(actual.getModel().get("nickName"));
      assertNull(actual.getModel().get("userClub"));
      assertEquals("23", actual.getModel().get("clubId"));
   }

   @Test
   public void testClubHomeNone() {
      when(clubService.getClub(23)).thenReturn(null);

      ModelAndView actual = underTest.clubHome("23", session);

      assertEquals("error", actual.getViewName());
   }

   @Test
   public void testJoinClub() {
      when(clubService.getClub(23)).thenReturn(buildClub(23, "Title23"));
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.isUserInClub(10, 23)).thenReturn(Boolean.TRUE);

      ModelAndView actual = underTest.joinClub("23", session);

      validateTitleView("Title23", "club", actual);
      assertEquals(PAGE_CLUB, actual.getModel().size());
      assertEquals("Title23", actual.getModel().get("navTitle"));
      assertEquals("true", actual.getModel().get("loginUser"));
      assertEquals("Nick", actual.getModel().get("nickName"));
   }

   @Test
   public void testSaveClub() {
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(categoryService.getCategoryById(Integer.valueOf("3"))).thenReturn(buildCategory(3, "Category"));
      when(clubService.saveClub(any())).thenAnswer(invocation -> {
         Club c = (Club) invocation.getArgument(0);
         c.setClubId(45);
         c.setCreateDatetime(LocalDateTime.now());
         return c;
      });

      YourClub actual = underTest.saveClub(new ClubForm("title", "3", "description"), session);

      assertEquals("title", actual.getName());
      assertEquals("45", actual.getId());
   }

   @Test
   public void testValidateClubForUser() {
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.validateClubByTitleState(eq("Title"), any(State.class))).thenReturn(Boolean.TRUE);

      ResponseEntity<String> actual = underTest.validateClubForUser("Title", session);

      assertTrue(actual.getStatusCode().is2xxSuccessful());
      assertEquals("valid", actual.getBody());
   }

   @Test
   public void testValidateClubForUserFail() {
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.validateClubByTitleState(eq("Title"), any(State.class))).thenReturn(Boolean.FALSE);

      ResponseEntity<String> actual = underTest.validateClubForUser("Title", session);

      assertTrue(actual.getStatusCode().is4xxClientError());
      assertEquals("invalid", actual.getBody());
   }

}
