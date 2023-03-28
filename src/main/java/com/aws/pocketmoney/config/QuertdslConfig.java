package com.aws.pocketmoney.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QuertdslConfig {

    @PersistenceContext
    private EntityManager entityManager;

}
