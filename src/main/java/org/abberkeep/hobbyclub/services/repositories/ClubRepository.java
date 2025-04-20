/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.hobbyclub.services.repositories;

import java.util.List;
import java.util.Optional;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.State;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Title: ClubRepository
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 14, 2025
 * @author Gary Deken
 * @version
 */
public interface ClubRepository extends JpaRepository<Club, Integer> {

   @Query(value = "SELECT c.* FROM clubs c JOIN userclubs uc ON c.club_id = uc.club_id GROUP BY c.club_id ORDER BY COUNT(uc.account_id) DESC", nativeQuery = true)
   List<Club> findAllOrderByMemberCount(Pageable pageable);

   List<Club> findByAccountAccountId(Integer accountId);

   Optional<Club> findByNameAndState(String name, State state);

}
