/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Optional;
import org.abberkeep.hobbyclub.controller.dto.RegistrationForm;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.State;
import org.abberkeep.hobbyclub.services.domains.UserInterest;
import org.abberkeep.hobbyclub.services.repositories.AccountRepository;
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
public class AccountServiceTest extends TestBaseService {
   private static final String PASS = "$2a$10$JnN45cGkOUtcxxKd87MUDu.2.vLegxM4oYTsT6GLDsZTMWjix6t.C";
   private City cityExpected;
   private State stateExpected;
   @Mock
   private AccountRepository accountRepository;
   @Mock
   private LocationService locationService;
   @Mock
   private CategoryService categoryService;
   @InjectMocks
   private AccountService underTest;

   @BeforeEach
   public void setUp() {
      stateExpected = buildState(12, "State Name");
      cityExpected = buildCity(23, "City Name", stateExpected);
   }

   @Test
   public void testCreateNewAccount() {
      when(locationService.getStateById(12)).thenReturn(stateExpected);
      when(locationService.getCityById(23)).thenReturn(cityExpected);
      when(accountRepository.save(any())).thenAnswer(invocation -> {
         Account a = (Account) invocation.getArgument(0);
         a.setAccountId(45);
         a.setCreateDatetime(LocalDateTime.now());
         return a;
      });
      RegistrationForm form = buildRegistrationForm("Gary", "GaryD");

      Account actual = underTest.createNewAccount(form);

      assertEquals(45, actual.getAccountId());
      assertEquals("Gary", actual.getFirstName());
      assertEquals("Last", actual.getLastName());
      assertEquals("GaryD", actual.getNickName());
      assertEquals("$2a$10$JnN45cGkOUtcxxKd87MUDuUJ6fM/V2apBUKK7/lQ7X6XT/b7em0qW", actual.getHashPass());
      assertEquals(stateExpected, actual.getState());
      assertEquals(cityExpected, actual.getCity());
      assertEquals('A', actual.getActive());
      assertNotNull(actual.getCreateDatetime());
      verify(categoryService, never()).getCategoryById(any());
   }

   @Test
   public void testCreateNewAccountNoNickName1() {
      when(locationService.getStateById(12)).thenReturn(stateExpected);
      when(locationService.getCityById(23)).thenReturn(cityExpected);
      when(accountRepository.existsByNickName("Gary")).thenReturn(Boolean.FALSE);
      when(accountRepository.save(any())).thenAnswer(invocation -> {
         Account a = (Account) invocation.getArgument(0);
         a.setAccountId(45);
         a.setCreateDatetime(LocalDateTime.now());
         return a;
      });
      RegistrationForm form = buildRegistrationForm("Gary", null);

      Account actual = underTest.createNewAccount(form);

      assertEquals(45, actual.getAccountId());
      assertEquals("Gary", actual.getFirstName());
      assertEquals("Last", actual.getLastName());
      assertEquals("Gary", actual.getNickName());
      assertEquals("$2a$10$JnN45cGkOUtcxxKd87MUDuUJ6fM/V2apBUKK7/lQ7X6XT/b7em0qW", actual.getHashPass());
      assertEquals(stateExpected, actual.getState());
      assertEquals(cityExpected, actual.getCity());
      assertEquals('A', actual.getActive());
      assertNotNull(actual.getCreateDatetime());
      verify(categoryService, never()).getCategoryById(any());
   }

   @Test
   public void testCreateNewAccountNoNickName2() {
      when(locationService.getStateById(12)).thenReturn(stateExpected);
      when(locationService.getCityById(23)).thenReturn(cityExpected);
      when(accountRepository.existsByNickName(any())).thenReturn(Boolean.TRUE).thenReturn(Boolean.FALSE);
      when(accountRepository.save(any())).thenAnswer(invocation -> {
         Account a = (Account) invocation.getArgument(0);
         a.setAccountId(45);
         a.setCreateDatetime(LocalDateTime.now());
         return a;
      });
      when(categoryService.getCategoryById(56)).thenReturn(buildCategory(56, "Cat1 Club"));

      RegistrationForm form = buildRegistrationForm("Gary", null);
      form.setInterestOne("56");

      Account actual = underTest.createNewAccount(form);

      assertEquals(45, actual.getAccountId());
      assertEquals("Gary", actual.getFirstName());
      assertEquals("Last", actual.getLastName());
      assertTrue(actual.getNickName().startsWith("Gary"));
      assertTrue(actual.getNickName().length() > 4);
      assertEquals("$2a$10$JnN45cGkOUtcxxKd87MUDuUJ6fM/V2apBUKK7/lQ7X6XT/b7em0qW", actual.getHashPass());
      assertEquals(stateExpected, actual.getState());
      assertEquals(cityExpected, actual.getCity());
      assertEquals('A', actual.getActive());
      assertNotNull(actual.getCreateDatetime());
      assertEquals(1, actual.getUserInterests().size());
      Iterator<UserInterest> iter = actual.getUserInterests().iterator();
      UserInterest actualUserInterest = iter.next();
      assertEquals(56, actualUserInterest.getCategory().getCategoryId());
      assertEquals("Cat1 Club", actualUserInterest.getCategory().getName());
   }

   @Test
   public void testCheckNickName() {
      when(accountRepository.existsByNickName("Gary")).thenReturn(Boolean.TRUE);
      when(accountRepository.existsByNickName("Sam")).thenReturn(Boolean.FALSE);

      assertTrue(underTest.checkNickName("Gary"));
      assertFalse(underTest.checkNickName("Sam"));
   }

   @Test
   public void testGetAccountById() {
      when(accountRepository.findById(12)).thenReturn(Optional.of(buildAccount(12)));

      Account actual = underTest.getAccountById(12);

      assertNotNull(actual);
      assertEquals(12, actual.getAccountId());
   }

   @Test
   public void testGetAccountByIdNone() {
      when(accountRepository.findById(12)).thenReturn(Optional.empty());

      Account actual = underTest.getAccountById(12);

      assertNull(actual);
   }

   @Test
   public void testGetAccountByNickNamePassword() {
      when(accountRepository.findByNickNameAndHashPass("First", PASS)).thenReturn(Optional.of(buildAccount(12)));

      Account actual = underTest.getAccountByNickNamePassword("First", "Pass");

      assertNotNull(actual);
      assertEquals(12, actual.getAccountId());
   }

   @Test
   public void testGetAccountByNickNamePasswordNone() {
      when(accountRepository.findByNickNameAndHashPass("First", PASS)).thenReturn(Optional.empty());

      Account actual = underTest.getAccountByNickNamePassword("First", "Pass");

      assertNull(actual);
   }

   @Test
   public void testGetRandomNickName() {
      //
   }

   private RegistrationForm buildRegistrationForm(String first, String nick) {
      RegistrationForm form = new RegistrationForm();

      form.setFirstName(first);
      form.setLastName("Last");
      form.setNickName(nick);
      form.setPassword("abc#123@def456");
      form.setCityId("23");
      form.setStateId("12");
      form.setInterestOne("0");
      form.setInterestTwo("0");
      form.setInterestThree("0");

      return form;
   }

}
