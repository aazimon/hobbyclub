/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.hobbyclub.services.repositories;

import java.util.List;
import org.abberkeep.hobbyclub.services.domains.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Title: CityRepository
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2025
 * @author Gary Deken
 * @version
 */
public interface CityRepository extends JpaRepository<City, Integer> {

   List<City> findByState_StateId(Integer stateId);
}
