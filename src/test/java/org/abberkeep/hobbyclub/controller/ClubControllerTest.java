/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.servlet.http.HttpSession;
import org.abberkeep.hobbyclub.services.ClubService;
import org.abberkeep.hobbyclub.services.domains.State;
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
public class ClubControllerTest extends TestBaseController {
   @Mock
   private ClubService clubService;
   @Mock
   private HttpSession session;
   @InjectMocks
   private ClubController underTest;

   @Test
   public void testValidateClubForUser() {
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.validateClubByTitleState(eq("Title"), any(State.class))).thenReturn(Boolean.TRUE);

      assertEquals("valid", underTest.validateClubForUser("Title", session));
   }

   @Test
   public void testValidateClubForUserNot() {
      when(session.getAttribute("userAccount")).thenReturn(buildAccount(10));
      when(clubService.validateClubByTitleState(eq("Title"), any(State.class))).thenReturn(Boolean.FALSE);

      assertEquals("Club name is already taken. Please choose another.", underTest.validateClubForUser("Title", session));
   }

}
