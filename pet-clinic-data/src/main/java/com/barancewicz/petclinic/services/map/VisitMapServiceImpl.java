package com.barancewicz.petclinic.services.map;

import com.barancewicz.petclinic.model.Visit;
import com.barancewicz.petclinic.services.VisitService;

import java.util.Set;

public class VisitMapServiceImpl extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {

        if (object.getPet() == null || object.getPet().getOwner() == null
                || object.getPet().getId() == null ||
                object.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid visit");
        }
        return super.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }
}
