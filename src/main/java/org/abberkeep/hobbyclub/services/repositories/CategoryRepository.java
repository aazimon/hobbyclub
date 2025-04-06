/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.hobbyclub.services.repositories;

import java.util.List;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Title: CategoryRepository
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 6, 2025
 * @author Gary Deken
 * @version
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

   List<Category> findAllByOrderByNameAsc();

}
