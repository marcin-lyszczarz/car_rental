package com.lyszczarzmarcin.portfolio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRental implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CarRental.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
