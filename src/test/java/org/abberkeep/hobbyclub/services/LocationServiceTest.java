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
import org.abberkeep.hobbyclub.controller.SelectOption;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.State;
import org.abberkeep.hobbyclub.services.repositories.CityRepository;
import org.abberkeep.hobbyclub.services.repositories.StateRepository;
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
public class LocationServiceTest {
   @Mock
   private StateRepository stateRepository;
   @Mock
   private CityRepository cityRepository;
   @InjectMocks
   private LocationService underTest;

   @BeforeEach
   public void setUp() {
   }

   @Test
   public void testGetAllStates() {
      List<State> states = buildStates(2);
      when(stateRepository.findAll()).thenReturn(states);

      List<SelectOption> actual = underTest.getAllStates();

      assertEquals(states.size(), actual.size());
      assertEquals(states.get(0).getStateId().toString(), actual.get(0).getValue());
      assertEquals(states.get(0).getName(), actual.get(0).getLabel());
      assertEquals(states.get(1).getStateId().toString(), actual.get(1).getValue());
      assertEquals(states.get(1).getName(), actual.get(1).getLabel());
   }

   @Test
   public void testGetAllCitiesByState() {
      List<City> cities = buildCities(3);
      when(cityRepository.findByState_StateId(12)).thenReturn(cities);

      List<SelectOption> actual = underTest.getCitiesByStateId(12);

      assertEquals(cities.size(), actual.size());
      assertEquals(cities.get(0).getCityId().toString(), actual.get(0).getValue());
      assertEquals(cities.get(0).getName(), actual.get(0).getLabel());
      assertEquals(cities.get(1).getCityId().toString(), actual.get(1).getValue());
      assertEquals(cities.get(1).getName(), actual.get(1).getLabel());
      assertEquals(cities.get(2).getCityId().toString(), actual.get(2).getValue());
      assertEquals(cities.get(2).getName(), actual.get(2).getLabel());
   }

   private List<City> buildCities(int number) {
      List<City> cities = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         cities.add(new City(i + 1, "City" + i, new State(12, "ST12", LocalDateTime.now()), LocalDateTime.now()));
      }

      return cities;
   }

   private List<State> buildStates(int number) {
      List<State> states = new ArrayList<>();

      for (int i = 0; i < number; i++) {
         states.add(new State(i + 1, "ST" + i, LocalDateTime.now()));
      }

      return states;
   }

}
