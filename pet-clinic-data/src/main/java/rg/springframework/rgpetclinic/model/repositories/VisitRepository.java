package rg.springframework.rgpetclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import rg.springframework.rgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
