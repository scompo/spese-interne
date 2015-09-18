package com.github.scompo.speseinterne.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.constraints.Digits;

@Retention(RetentionPolicy.RUNTIME)
@Digits(integer = 12, fraction = 2)
public @interface MoneyFormat {

}
