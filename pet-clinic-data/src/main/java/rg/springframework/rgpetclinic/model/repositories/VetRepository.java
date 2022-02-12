package rg.springframework.rgpetclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import rg.springframework.rgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
