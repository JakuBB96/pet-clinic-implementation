package com.barancewicz.petclinic.services.map;

import com.barancewicz.petclinic.model.Owner;
import com.barancewicz.petclinic.model.Pet;
import com.barancewicz.petclinic.services.OwnerService;
import com.barancewicz.petclinic.services.PetService;
import com.barancewicz.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Profile({"default", "map"})
public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMapImpl(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                   .stream()
                   .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                   .findFirst()
                   .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {

        return this.findAll()
                    .stream()
                    .filter(owner -> lastName.replaceAll("%","").matches(owner.getLastName()))
                    .collect(Collectors.toList());
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        Owner savedOwner = null;

        if (object != null){
            if (object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null){
                        if (pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if (pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }
        else {
            return null;
        }
    }

    @Override
    public Set<Owner> findAll() {
       return  super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
            super.delete(object);
    }
}
