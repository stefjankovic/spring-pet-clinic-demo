package com.demo.springpetclinicdemo.model.services.map;

import com.demo.springpetclinicdemo.model.model.Specialty;
import com.demo.springpetclinicdemo.model.model.Vet;
import com.demo.springpetclinicdemo.model.services.SpecialtyService;
import com.demo.springpetclinicdemo.model.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap  extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        checkVetDataOnSave(object);
        return super.save(object);
    }

    private void checkVetDataOnSave(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
