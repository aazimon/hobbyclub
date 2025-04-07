/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services.repositories;

import org.abberkeep.hobbyclub.services.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Title: AccountRepository
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {

   @Query("SELECT count(a) > 0 FROM Account a WHERE a.nickName = ?1")
   boolean existsByNickName(String nickName);
}
