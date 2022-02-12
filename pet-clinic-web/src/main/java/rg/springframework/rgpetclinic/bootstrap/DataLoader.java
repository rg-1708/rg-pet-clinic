package rg.springframework.rgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rg.springframework.rgpetclinic.model.*;
import rg.springframework.rgpetclinic.services.OwnerService;
import rg.springframework.rgpetclinic.services.PetTypeService;
import rg.springframework.rgpetclinic.services.SpecialityService;
import rg.springframework.rgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int petTypeCount = petTypeService.findAll().size();

        if(petTypeCount == 0) {
        loadData();
        }
    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialityService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialityService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("17 Brickroad");
        owner1.setCity("London");
        owner1.setTelephone("+0111222333");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Andrey");
        owner2.setLastName("Pechorin");
        owner2.setAddress("24 Micrelroad");
        owner2.setCity("London");
        owner2.setTelephone("+012345667");

        Pet andreysCat = new Pet();
        andreysCat.setName("Sleepy");
        andreysCat.setOwner(owner2);
        andreysCat.setBirthDate(LocalDate.now());
        andreysCat.setPetType(savedCatType);
        owner2.getPets().add(andreysCat);

        ownerService.save(owner2);
        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Fionna");
        vet1.setLastName("Carlsen");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Loaded Vets...");
    }
}
