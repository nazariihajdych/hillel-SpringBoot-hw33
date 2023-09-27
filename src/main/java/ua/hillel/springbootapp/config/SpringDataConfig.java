package ua.hillel.springbootapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"ua.hillel.springbootapp.repo"})
public class SpringDataConfig {
}
