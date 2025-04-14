/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.util.Optional;
import java.util.Random;
import org.abberkeep.hobbyclub.controller.RegistrationForm;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.domains.UserInterest;
import org.abberkeep.hobbyclub.services.repositories.AccountRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Title: AccountService
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
@Service
public class AccountService {
   private static final Logger log = LoggerFactory.getLogger(AccountService.class);
   private static final String SALT = "$2a$10$JnN45cGkOUtcxxKd87MUDu";
   @Autowired
   private AccountRepository accountRepository;
   @Autowired
   private LocationService locationService;
   @Autowired
   private CategoryService categoryService;

   @Transactional
   public Account createNewAccount(RegistrationForm regForm) {
      Account acc = convertFormToAccount(regForm);

      acc = accountRepository.save(acc);

      return acc;
   }

   public boolean checkNickName(String nickName) {
      return accountRepository.existsByNickName(nickName);
   }

   public Account getAccountById(Integer accountId) {
      Optional<Account> opt = accountRepository.findById(accountId);

      if (opt.isEmpty()) {
         log.error("Account not found by ID {}, Returning null", accountId);
         return null;
      }

      return opt.get();
   }

   public Account getAccountByNickNamePassword(String nickName, String password) {
      Optional<Account> opt = accountRepository.findByNickNameAndHashPass(nickName, BCrypt.hashpw(password, SALT));

      if (opt.isEmpty()) {
         return null;
      }

      return opt.get();
   }

   public String getRandomNickName(String first) {
      Random ran = new Random(System.currentTimeMillis());
      String nick = first;
      while (checkNickName(nick)) {
         nick = first + ran.nextInt(1, 10000);
      }
      return nick;
   }

   private Account convertFormToAccount(RegistrationForm regForm) throws NumberFormatException {
      // create the Account
      Account acc = new Account();

      acc.setFirstName(regForm.getFirstName());
      acc.setLastName(regForm.getLastName());
      if (StringUtils.hasText(regForm.getNickName())) {
         acc.setNickName(regForm.getNickName());
      } else {
         String nick = getRandomNickName(regForm.getFirstName());
         acc.setNickName(nick);
      }
      acc.setHashPass(BCrypt.hashpw(regForm.getPassword(), SALT));

      acc.setState(locationService.getStateById(Integer.valueOf(regForm.getStateId())));
      acc.setCity(locationService.getCityById(Integer.valueOf(regForm.getCityId())));
      acc.setActive(Account.ACTIVE);
      // save user interests
      if (StringUtils.hasText(regForm.getInterestOne())) {
         Category cat = categoryService.getCategoryById(Integer.valueOf(regForm.getInterestOne()));
         acc.addUserInterest(new UserInterest(acc, cat));
      }
      if (StringUtils.hasText(regForm.getInterestTwo())) {
         Category cat = categoryService.getCategoryById(Integer.valueOf(regForm.getInterestTwo()));
         acc.addUserInterest(new UserInterest(acc, cat));
      }
      if (StringUtils.hasText(regForm.getInterestThree())) {
         Category cat = categoryService.getCategoryById(Integer.valueOf(regForm.getInterestThree()));
         acc.addUserInterest(new UserInterest(acc, cat));
      }

      return acc;
   }

}
