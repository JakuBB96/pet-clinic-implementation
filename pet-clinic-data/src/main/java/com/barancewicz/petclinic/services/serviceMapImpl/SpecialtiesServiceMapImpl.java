package com.barancewicz.petclinic.services.serviceMapImpl;

import com.barancewicz.petclinic.model.Speciality;
import com.barancewicz.petclinic.services.SpecialtiesService;

import java.util.Set;

public class SpecialtiesServiceMapImpl extends AbstractMapService<Speciality, Long> implements SpecialtiesService {
    @Override
    public Speciality findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
