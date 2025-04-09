/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import org.abberkeep.hobbyclub.controller.RegistrationForm;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.State;
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
public class AccountServiceTest extends BaseServiceTest {
   private City cityExpected;
   private State stateExpected;
   @Mock
   private AccountRepository accountRepository;
   @Mock
   private LocationService locationService;
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
      assertEquals(stateExpected, actual.getState());
      assertEquals(cityExpected, actual.getCity());
      assertEquals('A', actual.getActive());
      assertNotNull(actual.getCreateDatetime());
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
      assertEquals(stateExpected, actual.getState());
      assertEquals(cityExpected, actual.getCity());
      assertEquals('A', actual.getActive());
      assertNotNull(actual.getCreateDatetime());
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
      RegistrationForm form = buildRegistrationForm("Gary", null);

      Account actual = underTest.createNewAccount(form);

      assertEquals(45, actual.getAccountId());
      assertEquals("Gary", actual.getFirstName());
      assertEquals("Last", actual.getLastName());
      assertTrue(actual.getNickName().startsWith("Gary"));
      assertTrue(actual.getNickName().length() > 4);
      assertEquals(stateExpected, actual.getState());
      assertEquals(cityExpected, actual.getCity());
      assertEquals('A', actual.getActive());
      assertNotNull(actual.getCreateDatetime());
   }

   @Test
   public void testCheckNickName() {
      when(accountRepository.existsByNickName("Gary")).thenReturn(Boolean.TRUE);
      when(accountRepository.existsByNickName("Sam")).thenReturn(Boolean.FALSE);

      assertTrue(underTest.checkNickName("Gary"));
      assertFalse(underTest.checkNickName("Sam"));
   }

   private RegistrationForm buildRegistrationForm(String first, String nick) {
      RegistrationForm form = new RegistrationForm();

      form.setFirstName(first);
      form.setLastName("Last");
      form.setNickName(nick);
      form.setCityId("23");
      form.setStateId("12");

      return form;
   }

}
