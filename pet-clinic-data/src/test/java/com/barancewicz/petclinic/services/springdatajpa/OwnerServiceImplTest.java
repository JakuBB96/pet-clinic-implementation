package com.barancewicz.petclinic.services.springdatajpa;

import com.barancewicz.petclinic.model.Owner;
import com.barancewicz.petclinic.repositories.OwnerRepository;
import com.barancewicz.petclinic.repositories.PetRepository;
import com.barancewicz.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerServiceImpl ownerService;

    final String lastName = "Smith";
    final Long ownerId = 1L;

    Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = ownerService.save(Owner.builder().id(ownerId).lastName(lastName).build());
        System.out.println(returnedOwner);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);

        Owner owner = ownerService.findByLastName(lastName);
        
        assertEquals(lastName, owner.getLastName());

        verify(ownerRepository, times(1)).findByLastName(anyString());
    }
    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).lastName("Foo").build());
        ownerSet.add(Owner.builder().id(2L).lastName("Bar").build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownerService.findAll();

        assertNotNull(owners);
        assertEquals(2, ownerSet.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(returnedOwner));
        Owner owner = ownerService.findById(1L);
        assertNotNull(owner);
        assertEquals(returnedOwner.getId(), owner.getId());
    }
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(java.util.Optional.empty());
        Owner owner = ownerService.findById(ownerId);
        assertNull(owner);
    }

    @Test
    void save() {

        Owner owner = Owner.builder().id(2L).build();

        when(ownerRepository.save(any())).thenReturn(returnedOwner);

        Owner savedOwner = ownerService.save(owner);

        verify(ownerRepository, times(1)).save(owner);

    }

    @Test
    void delete() {
        ownerService.delete(returnedOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ownerId);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}