package com.barancewicz.petclinic.repositories;

import com.barancewicz.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
