package com.barancewicz.petclinic.services.serviceJPAImpl;

import com.barancewicz.petclinic.model.PetType;
import com.barancewicz.petclinic.repositories.PetTypeRepository;
import com.barancewicz.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PetTypeServiceImpl implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long aLong) {
        return null;
    }

    @Override
    public PetType save(PetType object) {
        return null;
    }

    @Override
    public Set<PetType> findAll() {
        return null;
    }

    @Override
    public void delete(PetType object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
