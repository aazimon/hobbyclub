/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.util.ArrayList;
import java.util.List;
import org.abberkeep.hobbyclub.controller.SelectOption;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.State;
import org.abberkeep.hobbyclub.services.repositories.CityRepository;
import org.abberkeep.hobbyclub.services.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title: LocationService
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
@Service
public class LocationService {
   @Autowired
   private StateRepository stateRepository;
   @Autowired
   private CityRepository cityRepository;

   public List<SelectOption> getAllStates() {
      List<State> states = stateRepository.findAll();
      List<SelectOption> display = new ArrayList<>();

      states.forEach(state -> display.add(new SelectOption(state.getStateId().toString(), state.getName())));

      return display;
   }

   public List<SelectOption> getCitiesByStateId(Integer stateId) {
      List<City> cities = cityRepository.findByState_StateId(stateId);
      List<SelectOption> display = new ArrayList<>();

      display.add(new SelectOption("*", "Any City"));
      cities.forEach(city -> display.add(new SelectOption(city.getCityId().toString(), city.getName())));

      return display;
   }

}
