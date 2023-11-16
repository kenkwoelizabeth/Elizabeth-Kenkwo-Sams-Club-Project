package com.samsclub;


import com.samsclub.store.StoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SamsClubProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SamsClubProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StoreService storeService) {
        return args -> System.out.println("My application got started!!");
    }




}
