/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.hobbyclub.services.repositories;

import java.util.List;
import org.abberkeep.hobbyclub.services.domains.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Title: TopicRepository
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 27, 2025
 * @author Gary Deken
 * @version
 */
public interface TopicRepository extends JpaRepository<Topic, Integer> {

   List<Topic> findByAccountAccountId(Integer accountId);

   List<Topic> findByClubClubId(Integer clubId);

}
