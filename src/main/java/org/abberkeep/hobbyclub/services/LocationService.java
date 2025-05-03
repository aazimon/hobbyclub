/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.abberkeep.hobbyclub.controller.SelectOption;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.State;
import org.abberkeep.hobbyclub.services.repositories.CityRepository;
import org.abberkeep.hobbyclub.services.repositories.StateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
   private static final Logger log = LoggerFactory.getLogger(LocationService.class);
   @Autowired
   private StateRepository stateRepository;
   @Autowired
   private CityRepository cityRepository;

   public List<SelectOption> getAllStates() {
      List<State> states = stateRepository.findAll();
      List<SelectOption> display = new ArrayList<>();

      display.add(new SelectOption("0", "Any State"));
      states.forEach(state -> display.add(new SelectOption(state.getStateId().toString(), state.getName())));

      return display;
   }

   public City getCityById(Integer cityId) {
      Optional<City> opt = cityRepository.findById(cityId);

      if (opt.isEmpty()) {
         log.error("City not found by ID {}, Returning null", cityId);
      }

      return opt.get();
   }

   public List<SelectOption> getCitiesByStateId(Integer stateId) {
      List<City> cities = cityRepository.findByState_StateId(stateId);
      List<SelectOption> display = new ArrayList<>();

      display.add(new SelectOption("0", "Any City"));
      cities.forEach(city -> display.add(new SelectOption(city.getCityId().toString(), city.getName())));

      return display;
   }

   public List<SelectOption> getCitiesSelected(int stateId, int cityId) {
      List<City> cities = cityRepository.findByState_StateId(stateId);
      List<SelectOption> display = new ArrayList<>();

      cities.forEach(city -> {
         SelectOption so = new SelectOption(city.getCityId().toString(), city.getName());
         if (city.getCityId() == cityId) {
            so.setSelected(true);
         }
         display.add(so);
      });

      return display;
   }

   public State getStateById(Integer stateId) {
      Optional<State> opt = stateRepository.findById(stateId);

      if (opt.isEmpty()) {
         log.error("State not found by ID {}, Returning null", stateId);
      }

      return opt.get();
   }

   public List<SelectOption> getStatesSelected(int stateId) {
      List<State> states = stateRepository.findAll();
      List<SelectOption> display = new ArrayList<>();

      states.forEach(state -> {
         SelectOption so = new SelectOption(state.getStateId().toString(), state.getName());
         if (state.getStateId() == stateId) {
            so.setSelected(true);
         }
         display.add(so);
      });

      return display;
   }

}
