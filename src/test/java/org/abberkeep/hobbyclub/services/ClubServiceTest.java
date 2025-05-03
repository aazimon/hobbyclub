/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.abberkeep.hobbyclub.controller.dto.ClubDisplay;
import org.abberkeep.hobbyclub.controller.dto.SelectOption;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.State;
import org.abberkeep.hobbyclub.services.domains.Status;
import org.abberkeep.hobbyclub.services.domains.UserClub;
import org.abberkeep.hobbyclub.services.repositories.CategoryRepository;
import org.abberkeep.hobbyclub.services.repositories.ClubRepository;
import org.abberkeep.hobbyclub.services.repositories.UserClubRepository;
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
public class ClubServiceTest extends TestBaseService {
   @Mock
   private ClubRepository clubRepository;
   @Mock
   private CategoryRepository categoryRepository;
   @Mock
   private UserClubRepository userClubRepository;
   @Mock
   private LocationService locationService;
   @InjectMocks
   private ClubService underTest;

   @Test
   public void testGetCategories() {
      List<Category> categories = buildCategories(6);
      when(categoryRepository.findAllByOrderByNameAsc()).thenReturn(categories);

      List<SelectOption> actual = underTest.getCategories("Any");

      assertEquals(categories.size() + 1, actual.size());
      assertEquals("0", actual.get(0).getValue());
      assertEquals("Any", actual.get(0).getLabel());
      assertEquals(categories.get(0).getCategoryId().toString(), actual.get(1).getValue());
      assertEquals(categories.get(0).getName(), actual.get(1).getLabel());
      assertEquals(categories.get(1).getCategoryId().toString(), actual.get(2).getValue());
      assertEquals(categories.get(1).getName(), actual.get(2).getLabel());
      assertEquals(categories.get(5).getCategoryId().toString(), actual.get(6).getValue());
      assertEquals(categories.get(5).getName(), actual.get(6).getLabel());
   }

   @Test
   public void testGetClub() {
      when(clubRepository.findById(23)).thenReturn(Optional.of(buildClub(23, "Title23")));

      Club actual = underTest.getClub(23);

      assertEquals(23, actual.getClubId());
   }

   @Test
   public void testGetClubNone() {
      when(clubRepository.findById(23)).thenReturn(Optional.empty());

      Club actual = underTest.getClub(23);

      assertNull(actual);
   }

   @Test
   public void testGetYourCreatedClubs() {
      List<Club> clubs = new ArrayList<>();
      clubs.add(buildClub(12, "Title12"));
      clubs.add(buildClub(23, "Title23"));
      when(clubRepository.findByAccountAccountId(12)).thenReturn(clubs);

      List<ClubDisplay> actual = underTest.getYourCreatedClubs(12);

      assertEquals(2, actual.size());
      assertEquals("12", actual.get(0).getId());
      assertEquals("23", actual.get(1).getId());
   }

   @Test
   public void testGetYourJoinedClubs() {
      List<Club> clubs = new ArrayList<>();
      clubs.add(buildClub(12, "Title12"));
      clubs.add(buildClub(23, "Title23"));
      when(clubRepository.findByJoinedAccountId(12)).thenReturn(clubs);

      List<ClubDisplay> actual = underTest.getYourJoinedClubs(12);

      assertEquals(2, actual.size());
      assertEquals("12", actual.get(0).getId());
      assertEquals("23", actual.get(1).getId());
   }

   @Test
   public void testIsUserInClub() {
      when(userClubRepository.findById(any())).thenReturn(Optional.of(buildUserClub(10, 12)));

      assertTrue(underTest.isUserInClub(10, 12));
   }

   @Test
   public void testIsUserInClubFail() {
      when(userClubRepository.findById(any())).thenReturn(Optional.empty());

      assertFalse(underTest.isUserInClub(10, 12));
   }

   @Test
   public void testJoinClub() {
      when(clubRepository.findById(23)).thenReturn(Optional.of(buildClub(23, "Title23")));
      when(userClubRepository.save(any())).thenAnswer(invocation -> {
         UserClub uc = (UserClub) invocation.getArgument(0);
         uc.setCreateDatetime(LocalDateTime.now());
         assertEquals(Status.ACTIVE.getState(), uc.getActive());
         assertNotNull(uc.getAccount());
         assertNotNull(uc.getClub());

         return uc;
      });

      assertTrue(underTest.joinClub(buildAccount(12), 23));
   }

   @Test
   public void testSaveClub() {
      Account account = buildAccount(10);
      Club club = buildClub(0, "Title12");
      when(clubRepository.save(club)).thenAnswer(invocation -> {
         Club c = (Club) invocation.getArgument(0);
         c.setClubId(45);
         c.setCreateDatetime(LocalDateTime.now());
         return c;
      });

      Club actual = underTest.saveClub(club, account);

      assertEquals(45, actual.getClubId());
      assertEquals("Title12", actual.getName());
   }

   @Test
   public void testValidateClubByTitleState() {
      State state = buildState(12, "State");
      when(clubRepository.findByNameAndState("title", state)).thenReturn(Optional.empty());

      assertTrue(underTest.validateClubByTitleState("title", state));
   }

   @Test
   public void testValidateClubByTitleStateFail() {
      State state = buildState(12, "State");
      Club club = buildClub(45, "title");
      when(clubRepository.findByNameAndState("title", state)).thenReturn(Optional.of(club));

      assertFalse(underTest.validateClubByTitleState("title", state));
   }

   private UserClub buildUserClub(int accountId, int clubId) {
      UserClub uc = new UserClub();

      uc.setAccount(buildAccount(accountId));
      uc.setClub(buildClub(clubId, "Title" + clubId));

      return uc;
   }

}
