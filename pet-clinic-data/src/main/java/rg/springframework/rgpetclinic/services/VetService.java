package rg.springframework.rgpetclinic.services;

import rg.springframework.rgpetclinic.model.Vet;
import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
