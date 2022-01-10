package rg.springframework.rgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rg.springframework.rgpetclinic.model.Owner;
import rg.springframework.rgpetclinic.model.Pet;
import rg.springframework.rgpetclinic.model.PetType;
import rg.springframework.rgpetclinic.model.Vet;
import rg.springframework.rgpetclinic.services.OwnerService;
import rg.springframework.rgpetclinic.services.PetTypeService;
import rg.springframework.rgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService PetTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        PetTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = PetTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = PetTypeService.save(dog);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Andrey");
        owner2.setLastName("Pechorin");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Fionna");
        vet1.setLastName("Carlsen");
        vetService.save(vet1);
        System.out.println("Loaded Vets...");
    }
}
