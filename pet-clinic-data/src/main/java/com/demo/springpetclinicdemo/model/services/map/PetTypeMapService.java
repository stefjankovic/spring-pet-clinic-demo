package com.demo.springpetclinicdemo.model.services.map;

import com.demo.springpetclinicdemo.model.model.PetType;
import com.demo.springpetclinicdemo.model.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    void delete(PetType object) {
        super.delete(object);
    }
}
