package com.br.Space_Exploration.App.config;

import com.br.Space_Exploration.Domain.usercases.Spacecraft;
import com.br.Space_Exploration.Domain.usercases.impl.SpacecraftImpl;
import com.br.Space_Exploration.infra.adapters.input.mapper.PlanetMapper;
import com.br.Space_Exploration.infra.adapters.input.mapper.SpacecraftMapper;
import com.br.Space_Exploration.infra.adapters.input.mapper.TravelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsecaseConfig {

    @Bean
    public SpacecraftMapper spacecraftMapper() {
        return new SpacecraftMapper();
    }

    @Bean
    public TravelMapper travelMapper() {
        return new TravelMapper();
    }

    @Bean
    public PlanetMapper planetMapper() {
        return new PlanetMapper();
    }

    @Bean
    public Spacecraft spacecraft(){
        return new SpacecraftImpl();
    }
}
