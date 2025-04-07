/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
public class AccountServiceTest {
   @Mock
   private AccountRepository accountRepository;
   @InjectMocks
   private AccountService underTest;

   @BeforeEach
   public void setUp() {
   }

   @Test
   public void testCreateNewAccount() {
   }

   @Test
   public void testCheckNickName() {
      when(accountRepository.existsByNickName("Gary")).thenReturn(Boolean.TRUE);
      when(accountRepository.existsByNickName("Sam")).thenReturn(Boolean.FALSE);

      assertTrue(underTest.checkNickName("Gary"));
      assertFalse(underTest.checkNickName("Sam"));
   }

}
