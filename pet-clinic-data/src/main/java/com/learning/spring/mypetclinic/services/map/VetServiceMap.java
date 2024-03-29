package com.learning.spring.mypetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.learning.spring.mypetclinic.model.Speciality;
import com.learning.spring.mypetclinic.model.Vet;
import com.learning.spring.mypetclinic.services.SpecialityService;
import com.learning.spring.mypetclinic.services.VetService;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;
	
	public VetServiceMap(SpecialityService specialityService) {
		super();
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
		//	We need to check if the specialities are persisted into 
		//	into the database by checking whether the IDs are set.
		if(object.getSpecialities().size() > 0){
			object.getSpecialities().forEach(speciality -> {
				if(speciality.getId() == null){
					Speciality savedSpeciality = specialityService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

}