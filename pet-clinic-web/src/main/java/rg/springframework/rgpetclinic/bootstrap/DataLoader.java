package rg.springframework.rgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rg.springframework.rgpetclinic.model.Owner;
import rg.springframework.rgpetclinic.model.Vet;
import rg.springframework.rgpetclinic.services.OwnerService;
import rg.springframework.rgpetclinic.services.VetService;
import rg.springframework.rgpetclinic.services.map.OwnerMapService;
import rg.springframework.rgpetclinic.services.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        //Will Be Refactored to use DI
        this.ownerService = new OwnerMapService();
        this.vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFistName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);
        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFistName("Fionna");
        vet1.setLastName("Carlsen");
        vetService.save(vet1);
        System.out.println("Loaded Vets...");
    }
}
