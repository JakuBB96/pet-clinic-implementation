package com.barancewicz.petclinic.bootstrap;


import com.barancewicz.petclinic.model.Owner;
import com.barancewicz.petclinic.model.PetType;
import com.barancewicz.petclinic.model.Vet;
import com.barancewicz.petclinic.services.OwnerService;
import com.barancewicz.petclinic.services.PetTypeService;
import com.barancewicz.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//implementing this interface is a spring-boot specific way
//@Component annotation - whats inside is going be be tun by spring and brought up to the context
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }
    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType cat = new PetType();
        cat.setName("cat");

        PetType savedDogType = petTypeService.save(dog);
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");


        vetService.save(vet2);

        System.out.println("Loaded owners");
        System.out.println("Loaded vets");
    }
}
