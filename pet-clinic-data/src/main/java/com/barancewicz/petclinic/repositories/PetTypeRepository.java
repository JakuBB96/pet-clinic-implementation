package com.barancewicz.petclinic.repositories;

import com.barancewicz.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
