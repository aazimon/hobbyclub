/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub.services.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import java.util.StringJoiner;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Title: SearchRepository
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 20, 2025
 * @author Gary Deken
 * @version
 */
@Repository
public class SearchRepository {
   private static final String SQL_START = "SELECT c.* FROM clubs c JOIN userclubs uc ON c.club_id = uc.club_id ";
   private static final String SQL_ORDER = "GROUP BY c.club_id ORDER BY COUNT(uc.account_id) DESC, c.create_datetime DESC";
   @Autowired
   private EntityManager entityManager;

   public List<Club> searchClubs(String name, int categoryId, int stateId, int cityId, Pageable pageable) {
      StringJoiner sj = new StringJoiner("AND ", "", "");

      if (!name.isBlank()) {
         sj.add("LOWER(c.name) LIKE :title ");
      }
      if (categoryId > 0) {
         sj.add("c.category_id = :categoryId ");
      }
      if (stateId > 0) {
         sj.add("c.state_id = :stateId ");
         if (cityId > 0) {
            // City is only set if the state is set.
            sj.add("c.city_id = :cityId ");
         }
      }
      String sql = SQL_START;
      if (sj.length() > 0) {
         sql += "WHERE " + sj.toString();
      }
      sql += SQL_ORDER;

      Query query = entityManager.createNativeQuery(sql, Club.class);

      if (!name.isBlank()) {
         query.setParameter("title", "%" + name.toLowerCase() + "%");
      }
      if (categoryId > 0) {
         query.setParameter("categoryId", categoryId);
      }
      if (stateId > 0) {
         query.setParameter("stateId", stateId);
         if (cityId > 0) {
            // City is only set if the state is set.
            query.setParameter("cityId", cityId);
         }
      }

      query.setFirstResult((int) pageable.getOffset());
      query.setMaxResults(pageable.getPageSize());

      return query.getResultList();
   }

}
