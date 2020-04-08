package com.barancewicz.petclinic.repositories;

import com.barancewicz.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
