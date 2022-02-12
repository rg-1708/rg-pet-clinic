package rg.springframework.rgpetclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import rg.springframework.rgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
