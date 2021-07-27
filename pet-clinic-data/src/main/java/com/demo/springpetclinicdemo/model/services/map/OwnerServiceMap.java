package com.demo.springpetclinicdemo.model.services.map;

import com.demo.springpetclinicdemo.model.model.Owner;
import com.demo.springpetclinicdemo.model.model.Pet;
import com.demo.springpetclinicdemo.model.services.OwnerService;
import com.demo.springpetclinicdemo.model.services.PetService;
import com.demo.springpetclinicdemo.model.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            checkPetDataOnSave(object);
            return super.save(object);
        } else {
            return null;
        }
    }

    private void checkPetDataOnSave(Owner object) {
        if (object.getPets() != null) {
            object.getPets().forEach( pet -> {
                if (pet.getPetType() != null)  {
                    if (pet.getPetType().getId() == null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                } else {
                    throw new RuntimeException("PetType is required");
                }
                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
