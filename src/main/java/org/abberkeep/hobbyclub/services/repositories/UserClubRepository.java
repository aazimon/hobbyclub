/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.hobbyclub.services.repositories;

import org.abberkeep.hobbyclub.services.domains.UserClub;
import org.abberkeep.hobbyclub.services.domains.UserClubId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Title: UserClubRepository
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 16, 2025
 * @author Gary Deken
 * @version
 */
public interface UserClubRepository extends JpaRepository<UserClub, UserClubId> {

}
