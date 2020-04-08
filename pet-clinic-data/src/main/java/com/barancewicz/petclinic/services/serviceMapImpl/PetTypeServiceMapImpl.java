package com.barancewicz.petclinic.services.serviceMapImpl;

import com.barancewicz.petclinic.model.PetType;
import com.barancewicz.petclinic.services.PetTypeService;

import java.util.Set;

public class PetTypeServiceMapImpl extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }
}
