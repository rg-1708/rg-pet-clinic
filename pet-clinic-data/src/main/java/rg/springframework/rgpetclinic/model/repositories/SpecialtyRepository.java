package rg.springframework.rgpetclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import rg.springframework.rgpetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}
