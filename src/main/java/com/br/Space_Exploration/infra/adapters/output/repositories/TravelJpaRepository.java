package com.br.Space_Exploration.infra.adapters.output.repositories;

import com.br.Space_Exploration.App.ports.output.TravelRepository;
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
    public TravelEntity getById(int id) {
        Optional<TravelEntity> entity = repository.findById(id);
        return entity.get();
    }

    @Override
    public TravelEntity save(TravelEntity travelEntity) {
        return repository.save(travelEntity);
    }
}

interface JpaTravelRepository extends JpaRepository<TravelEntity, Integer> {

}
