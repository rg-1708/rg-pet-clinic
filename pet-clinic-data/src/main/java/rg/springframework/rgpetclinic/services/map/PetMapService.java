package rg.springframework.rgpetclinic.services.map;

import rg.springframework.rgpetclinic.model.Pet;
import rg.springframework.rgpetclinic.services.CrudService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}