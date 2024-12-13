package com.br.Space_Exploration.infra.adapters.output.repositories;

import com.br.Space_Exploration.App.ports.output.TravelRepository;
import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;
import com.br.Space_Exploration.infra.adapters.output.entities.TravelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TravelJpaRepository implements TravelRepository {

    private final JpaTravelRepository repository;

    public TravelJpaRepository(JpaTravelRepository repository) {
        this.repository = repository;
    }


    @Override
    public Optional<TravelEntity> findTopBySpacecraftOrderByIdDesc(SpacecraftEntity spacecraft) {
        return repository.findTopBySpacecraftOrderByIdDesc(spacecraft);
    }

    @Override
    public TravelEntity save(TravelEntity travelEntity) {
        return repository.save(travelEntity);
    }
}

interface JpaTravelRepository extends JpaRepository<TravelEntity, Integer> {
    Optional<TravelEntity> findTopBySpacecraftOrderByIdDesc(SpacecraftEntity spacecraft);
}
