package rg.springframework.rgpetclinic.services.map;

import org.springframework.stereotype.Service;
import rg.springframework.rgpetclinic.model.Specialty;
import rg.springframework.rgpetclinic.model.Vet;
import rg.springframework.rgpetclinic.services.SpecialityService;
import rg.springframework.rgpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(speciality -> {
                if(speciality.getId() == null) {
                    Specialty savedSpeciality = specialityService.save(speciality);
                    savedSpeciality.setId(savedSpeciality.getId());

                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
