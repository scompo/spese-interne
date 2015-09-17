package com.github.scompo.speseinterne.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.github.scompo.speseinterne.Application;

@Retention(RetentionPolicy.RUNTIME)
@SpringApplicationConfiguration(classes = { Application.class })
@WebIntegrationTest
@TransactionConfiguration(defaultRollback = true)
public @interface IntegrationTestConfig {

}
