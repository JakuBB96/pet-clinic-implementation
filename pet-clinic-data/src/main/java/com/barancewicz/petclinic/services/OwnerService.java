package com.barancewicz.petclinic.services;

import com.barancewicz.petclinic.model.Owner;

import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
