/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import org.abberkeep.hobbyclub.services.domains.Account;
import org.abberkeep.hobbyclub.services.domains.Category;
import org.abberkeep.hobbyclub.services.domains.City;
import org.abberkeep.hobbyclub.services.domains.Club;
import org.abberkeep.hobbyclub.services.domains.Event;
import org.abberkeep.hobbyclub.services.domains.EventAttendance;
import org.abberkeep.hobbyclub.services.domains.State;
import org.abberkeep.hobbyclub.services.domains.Status;

/**
 * Title: BaseTest
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 11, 2025
 * @author Gary Deken
 * @version
 */
public class TestBase {
   protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

   protected Account buildAccount(int id) {
      Account acc = new Account();

      acc.setAccountId(id);
      acc.setFirstName("First");
      acc.setLastName("Last");
      acc.setNickName("Nick");
      State state = buildState(12, "State");
      acc.setState(state);
      acc.setCity(buildCity(23, "City", state));

      return acc;
   }

   protected Category buildCategory(int id, String category) {
      return new Category(id, category);
   }

   protected City buildCity(int id, String city, State state) {
      return new City(id + 1, city, state);
   }

   protected Club buildClub(int id, String title) {
      Club club = new Club();

      club.setClubId(id);
      club.setName(title);
      club.setActive(Status.ACTIVE.getState());

      return club;
   }

   protected Event buildEvent(int id, String title, Account account) {
      Event ev = new Event();

      ev.setEventId(id);
      ev.setTitle(title);
      ev.setDetails("This is the details");
      ev.setDatetime(LocalDateTime.of(2025, Month.APRIL, 3, 19, 5));
      ev.setAccount(account);
      ev.setClub(buildClub(id + 20, "Club" + id));
      ev.setState(buildState(id + 12, "State" + id));
      ev.setCity(buildCity(id + 30, "City 3" + id, ev.getState()));
      Set<EventAttendance> ea = new HashSet<>();

      ea.add(new EventAttendance(buildAccount(40 + id), ev, EventAttendance.WILL_ATTEND));
      ea.add(new EventAttendance(buildAccount(45 + id), ev, EventAttendance.MAY_ATTEND));
      ea.add(new EventAttendance(buildAccount(50 + id), ev, EventAttendance.INTERESTED));
      ea.add(new EventAttendance(buildAccount(55 + id), ev, EventAttendance.NOT_INTERESTED));

      ev.setEventAttendances(ea);

      return ev;
   }

   protected State buildState(int id, String state) {
      return new State(id + 1, state);
   }

}
