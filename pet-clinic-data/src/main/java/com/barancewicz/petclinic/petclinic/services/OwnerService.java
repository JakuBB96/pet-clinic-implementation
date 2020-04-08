package com.barancewicz.petclinic.petclinic.services;

import com.barancewicz.petclinic.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
