/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.hobbyclub.services.repositories;

import java.util.List;
import org.abberkeep.hobbyclub.services.domains.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Title: EventRepository
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 22, 2025
 * @author Gary Deken
 * @version
 */
public interface EventRepository extends JpaRepository<Event, Integer> {

   @Query(value = "SELECT e.* FROM events e WHERE e.account_id = :id and e.datetime > CURDATE()", nativeQuery = true)
   List<Event> findByAccountAccountId(@Param("id") Integer accountId);

   @Query(value = "SELECT e.* FROM events e WHERE e.account_id = :id and e.club_id = :clubId and e.datetime > CURDATE()", nativeQuery = true)
   List<Event> findByAccountAccountIdClubId(@Param("id") Integer accountId, @Param("clubId") Integer clubId);

   @Query(value = "SELECT e.* FROM events e WHERE e.club_id = :id and e.datetime > CURDATE()", nativeQuery = true)
   List<Event> findByClubClubId(@Param("id") Integer clubId);

   @Query(value = "SELECT e.* FROM events e JOIN userclubs uc ON uc.club_id = e.club_id WHERE uc.account_id = :id and e.datetime > CURDATE()", nativeQuery = true)
   List<Event> findByClubAccountId(@Param("id") Integer accountId);

   @Query(value = "SELECT e.* FROM events e JOIN userclubs uc ON uc.club_id = e.club_id WHERE uc.account_id = :id and e.club_id = :clubId and e.datetime > CURDATE()", nativeQuery = true)
   List<Event> findByClubAccountIdClubId(@Param("id") Integer accountId, @Param("clubId") Integer clubId);
}
