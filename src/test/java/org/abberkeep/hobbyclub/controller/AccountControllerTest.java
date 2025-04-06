/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import org.abberkeep.hobbyclub.services.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gary Deken
 */
@ExtendWith(MockitoExtension.class)
public class AccountControllerTest extends BaseControllerTest {
   @Mock
   private LocationService locationService;
   @InjectMocks
   private AccountController underTest;

   @BeforeEach
   public void setUp() {
   }

   @Test
   public void testRegistrationPage() {
      when(locationService.getAllStates()).thenReturn(buildStates(3));
      ModelAndView actual = underTest.registrationPage();

      validateTitleView("Hobby Club Registration", "registration", actual);
      List<SelectOption> actualSO = (List<SelectOption>) actual.getModel().get("stateDropDown");
      assertEquals(3, actualSO.size());
   }

   @Test
   public void testRegisterNewMember() {
      RegistrationForm regForm = buildRegistrationForm("Gary", "Deken", "Gary", "MO", "St Louis");
      addInterests(regForm, "Books", "Games", "Photography");

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "registration", actual);
   }

   @Test
   public void testRegisterNewMemberFail1() {
      RegistrationForm regForm = buildRegistrationForm(null, null, null, null, null);
      addInterests(regForm, null, null, null);

      ModelAndView actual = underTest.registerNewMember(regForm);

      validateTitleView("Hobby Club Registration", "registration", actual);
   }

   private void addInterests(RegistrationForm regForm, String ints1, String ints2, String ints3) {
      regForm.setInterestOne(ints1);
      regForm.setInterestTwo(ints2);
      regForm.setInterestThree(ints3);
   }

   private RegistrationForm buildRegistrationForm(String first, String last, String nick, String state, String city) {
      RegistrationForm regForm = new RegistrationForm();
      regForm.setFirstName(first);
      regForm.setLastName(last);
      regForm.setNickName(nick);
      regForm.setStateId(state);
      regForm.setCityId(city);

      return regForm;
   }

   private List<SelectOption> buildStates(int number) {
      List<SelectOption> so = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         so.add(new SelectOption("1" + i, "ST" + i));
      }

      return so;
   }

}
