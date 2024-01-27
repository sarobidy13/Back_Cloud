package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.demo.vehicule.repository") // Remplacez par le chemin de votre package de
                                                                        // repository
public class MongoConfig {
}
