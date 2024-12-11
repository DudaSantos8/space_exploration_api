package com.br.Space_Exploration.App.config;

import com.br.Space_Exploration.infra.adapters.input.mapper.SpacecraftMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsecaseConfig {

    @Bean
    public SpacecraftMapper spacecraftMapper() {
        return new SpacecraftMapper();
    }
}
