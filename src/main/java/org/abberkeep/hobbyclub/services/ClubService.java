/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.abberkeep.hobbyclub.controller.dto.ClubDisplay;
import org.abberkeep.hobbyclub.controller.dto.SelectOption;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.State;
import org.abberkeep.hobbyclub.services.domains.Status;
import org.abberkeep.hobbyclub.services.domains.UserClub;
import org.abberkeep.hobbyclub.services.domains.UserClubId;
import org.abberkeep.hobbyclub.services.repositories.CategoryRepository;
import org.abberkeep.hobbyclub.services.repositories.ClubRepository;
import org.abberkeep.hobbyclub.services.repositories.UserClubRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
   private final static Logger log = LoggerFactory.getLogger(ClubService.class);
   private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
   @Autowired
   private ClubRepository clubRepository;
   @Autowired
   private CategoryRepository categoryRepository;
   @Autowired
   private UserClubRepository userClubRepository;
   @Autowired
   private LocationService locationService;

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

   public List<ClubDisplay> getYourCreatedClubs(int accountID) {
      List<Club> clubs = clubRepository.findByAccountAccountId(accountID);
      List<ClubDisplay> yourClubs = new ArrayList<>();

      clubs.forEach(cl -> yourClubs.add(new ClubDisplay(cl.getClubId().toString(), cl.getName(), cl.getDescription())));

      return yourClubs;
   }

   public List<ClubDisplay> getYourJoinedClubs(int accountID) {
      List<Club> clubs = clubRepository.findByJoinedAccountId(accountID);
      List<ClubDisplay> yourClubs = new ArrayList<>();

      clubs.forEach(cl -> yourClubs.add(new ClubDisplay(cl.getClubId().toString(), cl.getName(), cl.getDescription())));

      return yourClubs;
   }

   public boolean isUserInClub(int accountId, int clubId) {
      Optional<UserClub> opt = userClubRepository.findById(new UserClubId(accountId, clubId));

      if (opt.isEmpty()) {
         return false;
      }
      return true;
   }

   @Transactional
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

   @Transactional
   public Club saveClub(Club club, Account account) {
      State state = account.getState();
      City city = account.getCity();

      club.setCity(city);
      club.setState(state);
      club.setAccount(account);
      club.setActive(Status.ACTIVE.getState());

      club = clubRepository.save(club);
      UserClubId uci = new UserClubId(account.getAccountId(), club.getClubId());
      UserClub uc = new UserClub();
      uc.setId(uci);
      uc.setAccount(account);
      uc.setClub(club);
      uc.setActive(Status.ACTIVE.getState());

      userClubRepository.save(uc);

      return club;
   }

   public boolean validateClubByTitleState(String title, State state) {
      Optional<Club> opt = clubRepository.findByNameAndState(title, state);

      if (opt.isEmpty()) {
         return true;
      }

      return false;
   }

}
