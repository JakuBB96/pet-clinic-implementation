package com.barancewicz.petclinic.repositories;

import com.barancewicz.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
