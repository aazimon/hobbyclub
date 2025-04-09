/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import java.util.Optional;
import java.util.Random;
import org.abberkeep.hobbyclub.controller.RegistrationForm;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.repositories.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
   @Autowired
   private AccountRepository accountRepository;
   @Autowired
   private LocationService locationService;

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
      }

      return opt.get();
   }

   private Account convertFormToAccount(RegistrationForm regForm) throws NumberFormatException {
      // create the Account
      Account acc = new Account();

      acc.setFirstName(regForm.getFirstName());
      acc.setLastName(regForm.getLastName());
      if (StringUtils.hasText(regForm.getNickName())) {
         acc.setNickName(regForm.getNickName());
      } else {
         Random ran = new Random(System.currentTimeMillis());
         String nick = regForm.getFirstName();

         while (checkNickName(nick)) {
            nick = regForm.getFirstName() + ran.nextInt(1, 10000);
         }
         acc.setNickName(nick);
      }

      acc.setState(locationService.getStateById(Integer.valueOf(regForm.getStateId())));
      acc.setCity(locationService.getCityById(Integer.valueOf(regForm.getCityId())));
      acc.setActive(Account.ACTIVE);

      return acc;
   }

}
