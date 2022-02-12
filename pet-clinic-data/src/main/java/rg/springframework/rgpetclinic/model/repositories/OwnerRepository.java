package rg.springframework.rgpetclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import rg.springframework.rgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

}
