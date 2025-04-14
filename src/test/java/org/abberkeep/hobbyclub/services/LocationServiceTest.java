/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
public class LocationServiceTest extends TestBaseService {
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

      assertEquals(cities.size() + 1, actual.size());
      assertEquals("*", actual.get(0).getValue());
      assertEquals("Any City", actual.get(0).getLabel());
      assertEquals(cities.get(0).getCityId().toString(), actual.get(1).getValue());
      assertEquals(cities.get(0).getName(), actual.get(1).getLabel());
      assertEquals(cities.get(1).getCityId().toString(), actual.get(2).getValue());
      assertEquals(cities.get(1).getName(), actual.get(2).getLabel());
      assertEquals(cities.get(2).getCityId().toString(), actual.get(3).getValue());
      assertEquals(cities.get(2).getName(), actual.get(3).getLabel());
   }

}
