package com.barancewicz.petclinic.services.serviceMapImpl;

import com.barancewicz.petclinic.model.Specialty;
import com.barancewicz.petclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtiesServiceMapImpl extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Specialty findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
