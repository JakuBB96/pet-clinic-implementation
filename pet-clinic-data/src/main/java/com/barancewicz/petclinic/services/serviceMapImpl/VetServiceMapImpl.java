package com.barancewicz.petclinic.services.serviceMapImpl;

import com.barancewicz.petclinic.model.Specialty;
import com.barancewicz.petclinic.model.Vet;
import com.barancewicz.petclinic.services.SpecialtyService;
import com.barancewicz.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMapImpl(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
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
