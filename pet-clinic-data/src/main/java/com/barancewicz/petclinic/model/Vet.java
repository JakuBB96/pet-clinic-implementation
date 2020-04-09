package com.barancewicz.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person {

    //be default anything that is many is lazily initialized
    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(name = "vet_specialties",
                    joinColumns = @JoinColumn(name = "vet_id"),
                    inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    Set<Specialty> specialities = new HashSet<>();

}
