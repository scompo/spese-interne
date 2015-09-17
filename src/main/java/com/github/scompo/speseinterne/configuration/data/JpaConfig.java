package com.github.scompo.speseinterne.configuration.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages ="com.github.scompo.speseinterne.repositories")
public class JpaConfig {

}
