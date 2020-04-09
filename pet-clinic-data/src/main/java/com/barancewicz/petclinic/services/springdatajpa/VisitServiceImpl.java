package com.barancewicz.petclinic.services.springdatajpa;

import com.barancewicz.petclinic.model.Visit;
import com.barancewicz.petclinic.repositories.VisitRepository;
import com.barancewicz.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long aLong) {
        Optional<Visit> visitOptional = visitRepository.findById(aLong);
        return visitOptional.orElse(null);
    }

    @Override
    public Visit save(Visit object) {
       return visitRepository.save(object);
    }

    @Override
    public Set<Visit> findAll() {
       Set<Visit> visits = new HashSet<>();
       visitRepository.findAll().forEach(visits::add);
       return visits;
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
