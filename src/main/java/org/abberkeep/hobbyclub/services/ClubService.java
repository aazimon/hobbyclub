/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.abberkeep.hobbyclub.controller.ClubDisplay;
import org.abberkeep.hobbyclub.controller.SearchForm;
import org.abberkeep.hobbyclub.controller.SelectOption;
import org.abberkeep.hobbyclub.controller.YourClub;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.State;
import org.abberkeep.hobbyclub.services.domains.Status;
import org.abberkeep.hobbyclub.services.domains.UserClub;
import org.abberkeep.hobbyclub.services.domains.UserClubId;
import org.abberkeep.hobbyclub.services.repositories.CategoryRepository;
import org.abberkeep.hobbyclub.services.repositories.ClubRepository;
import org.abberkeep.hobbyclub.services.repositories.SearchRepository;
import org.abberkeep.hobbyclub.services.repositories.UserClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Title: ClubService
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 6, 2025
 * @author Gary Deken
 * @version
 */
@Service
public class ClubService {
   @Autowired
   private ClubRepository clubRepository;
   @Autowired
   private CategoryRepository categoryRepository;
   @Autowired
   private UserClubRepository userClubRepository;
   @Autowired
   private SearchRepository searchRepository;

   public List<SelectOption> getCategories(String firstLabel) {
      List<Category> cats = categoryRepository.findAllByOrderByNameAsc();
      List<SelectOption> display = new ArrayList<>();

      display.add(new SelectOption("0", firstLabel));
      cats.forEach(category -> display.add(new SelectOption(category.getCategoryId().toString(), category.getName())));

      return display;
   }

   public Club getClub(int clubId) {
      Optional<Club> opt = clubRepository.findById(clubId);

      if (opt.isEmpty()) {
         return null;
      }

      return opt.get();
   }

   public List<ClubDisplay> getPopularClubs() {
      List<Club> clubs = clubRepository.findAllOrderByMemberCount(PageRequest.of(0, 11));

      return clubs.stream().map(c -> new ClubDisplay(c.getClubId().toString(), c.getName(), c.getDescription())).collect(
         Collectors.toList());
   }

   public List<YourClub> getYourClubs(int accountID) {
      List<Club> clubs = clubRepository.findByAccountAccountId(accountID);
      List<YourClub> yourClubs = new ArrayList<>();

      clubs.forEach(cl -> yourClubs.add(new YourClub(cl.getName(), cl.getClubId().toString())));

      return yourClubs;
   }

   public boolean isUserInClub(int accountId, int clubId) {
      Optional<UserClub> opt = userClubRepository.findById(new UserClubId(accountId, clubId));

      if (opt.isEmpty()) {
         return false;
      }
      return true;
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

   public boolean joinClub(Account account, int clubId) {
      UserClubId uci = new UserClubId(account.getAccountId(), clubId);
      UserClub uc = new UserClub();
      uc.setId(uci);
      uc.setAccount(account);
      uc.setClub(getClub(clubId));
      uc.setActive(Status.ACTIVE.getState());

      uc = userClubRepository.save(uc);

      return true;
   }

   public Club saveClub(Club club) {
      return clubRepository.save(club);
   }

   public boolean validateClubByTitleState(String title, State state) {
      Optional<Club> opt = clubRepository.findByNameAndState(title, state);

      if (opt.isEmpty()) {
         return true;
      }

      return false;
   }
}
