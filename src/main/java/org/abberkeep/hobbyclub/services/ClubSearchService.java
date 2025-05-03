/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.abberkeep.hobbyclub.controller.dto.ClubDisplay;
import org.abberkeep.hobbyclub.controller.dto.SearchForm;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.repositories.ClubRepository;
import org.abberkeep.hobbyclub.services.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Title: ClubSearchService
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 22, 2025
 * @author Gary Deken
 * @version
 */
@Service
public class ClubSearchService {
   @Autowired
   private ClubRepository clubRepository;
   @Autowired
   private SearchRepository searchRepository;

   public List<ClubDisplay> getPopularClubs() {
      List<Club> clubs = clubRepository.findAllOrderByMemberCount(PageRequest.of(0, 11));

      return clubs.stream().map(c -> new ClubDisplay(c.getClubId().toString(), c.getName(), c.getDescription())).collect(
         Collectors.toList());
   }

   public List<ClubDisplay> searchClubs(SearchForm search) {
      List<ClubDisplay> cd = new ArrayList<>();
      String name = search.getClubName();
      int categoryId = Integer.parseInt(search.getCategoryId());
      int stateId = Integer.parseInt(search.getStateId());
      int cityId = Integer.parseInt(search.getCityId());

      List<Club> clubs = searchRepository.searchClubs(name, categoryId, stateId, cityId, PageRequest.of(0, 11));

      clubs.forEach(cl -> cd.add(new ClubDisplay(cl.getClubId().toString(), cl.getName(), cl.getDescription())));
      return cd;
   }

}
