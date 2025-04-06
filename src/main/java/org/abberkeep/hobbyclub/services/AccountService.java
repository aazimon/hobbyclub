/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services;

import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
   @Autowired
   private AccountRepository accountRepository;

   public Account createNewAccount() {

      return null;
   }

}
