package com.barancewicz.petclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    //be default anything that is many is lazily initialized
    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(name = "vet_specialties",
                    joinColumns = @JoinColumn(name = "vet_id"),
                    inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    Set<Specialty> specialities = new HashSet<>();

    public Set<Specialty> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Specialty> specialities) {
        this.specialities = specialities;
    }
}
