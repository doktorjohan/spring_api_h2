package com.example.spring_api_demo_h2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Preloads some data to database
 */
@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repo) {

    return args -> {
      log.info("Preloading " + repo.save(new Employee("You have my sword", "strider!")));
      log.info("Preloading " + repo.save(new Employee("And my bow", "still only counts as one")));
      log.info("Preloading " + repo.save(new Employee("And my axe", "deadly on short distances")));
      log.info("Preloading " + repo.save(new Employee("Frodo Baggins", "Mister Underhill")));
      log.info("Preloading " + repo.save(new Employee("Meriadoc Brandybuck", "no the big one, the big one")));
    };
  }
}
