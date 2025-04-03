/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.hobbyclub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Title: HobbyClubConfiguration
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Mar 31, 2025
 * @author Gary Deken
 * @version
 */
@Configuration
@ComponentScan(basePackages = "org.abberkeep.hobbyclub")
public class HobbyClubConfiguration {

   @Bean
   public String start() {
      System.out.println("Starting the application.");
      return "start";
   }

}
