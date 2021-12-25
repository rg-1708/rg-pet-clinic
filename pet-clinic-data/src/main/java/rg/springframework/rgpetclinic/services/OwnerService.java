package rg.springframework.rgpetclinic.services;

import rg.springframework.rgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);
}
