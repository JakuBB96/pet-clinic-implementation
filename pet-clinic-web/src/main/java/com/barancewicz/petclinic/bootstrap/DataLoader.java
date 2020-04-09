package com.barancewicz.petclinic.bootstrap;


import com.barancewicz.petclinic.model.*;
import com.barancewicz.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


//implementing this interface is a spring-boot specific way
//@Component annotation - whats inside is going be be tun by spring and brought up to the context
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtiesService;
    private final VisitService visitService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtiesService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
        this.petService = petService;
    }
    @Override
    public void run(String... args) throws Exception {
        //only if there is no data, in this case no petTypes we will run this method
        int count = petTypeService.findAll().size();
            if (count == 0) {
              loadData();
         }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType cat = new PetType();
        cat.setName("cat");

        PetType savedDogType = petTypeService.save(dog);
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        mikesPet.setOwner(owner1);
        owner1.getPets().add(mikesPet);
        petService.save(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("4523453");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatType);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Just Cat");
        fionasPet.setOwner(owner2);
        owner1.getPets().add(mikesPet);
        petService.save(fionasPet);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);

        Specialty surgery = new Specialty();
        Specialty dentistry = new Specialty();
        Specialty radiology = new Specialty();

        surgery.setDescription("Surgery");
        dentistry.setDescription("Dentistry");
        radiology.setDescription("Radiology");

        Specialty savedSurgery = specialtiesService.save(surgery);
        Specialty savedDentistry = specialtiesService.save(dentistry);
        Specialty savedRadiology = specialtiesService.save(radiology);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);


        System.out.println("Loaded owners");
        System.out.println("Loaded vets");
    }
}
