package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Ulazna tacka za aplikaciju
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo.dao")
@ComponentScan(basePackages = "com.example.demo")
public class ElectionsappApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ElectionsappApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ElectionsappApplication.class);
    }
}
