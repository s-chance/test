package org.example.helloworld.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.example.helloworld.repo"})
@EntityScan(basePackages = "org.example.helloworld.po")
public class JpaConfig {
}
