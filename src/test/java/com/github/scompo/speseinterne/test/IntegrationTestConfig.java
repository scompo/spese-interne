package com.github.scompo.speseinterne.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;

import com.github.scompo.speseinterne.Application;

@Retention(RetentionPolicy.RUNTIME)
@SpringApplicationConfiguration(classes = {Application.class})
@WebIntegrationTest
public @interface IntegrationTestConfig {

}
