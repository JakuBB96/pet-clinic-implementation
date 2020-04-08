package com.barancewicz.petclinic.services.serviceMapImpl;

import com.barancewicz.petclinic.model.Vet;
import com.barancewicz.petclinic.services.VetService;

import java.util.Set;

public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
