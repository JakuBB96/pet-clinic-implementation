package com.barancewicz.petclinic.repositories;

import com.barancewicz.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
