package com.github.scompo.speseinterne.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Profile(value = "production")
public @interface Production {

}
