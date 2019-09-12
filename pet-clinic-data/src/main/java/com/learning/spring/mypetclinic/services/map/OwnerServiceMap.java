package com.learning.spring.mypetclinic.services.map;

import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.learning.spring.mypetclinic.model.Owner;
import com.learning.spring.mypetclinic.model.Pet;
import com.learning.spring.mypetclinic.model.repositories.OwnerRepository;
import com.learning.spring.mypetclinic.services.OwnerService;
import com.learning.spring.mypetclinic.services.PetService;
import com.learning.spring.mypetclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{
	
	private final PetTypeService petTypeService;
	private final PetService petService; 
	
	public OwnerServiceMap(PetTypeService petTypeService, PetService petType) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petType;
	}

	@Override
	public Owner save(Owner object) {
		//	When we save owner, we also make sure that the id for the 
		//	pet type and pet is also set
		if(object != null){
			if(object.getPets() != null){
				object.getPets().forEach(pet -> {
					if(pet.getPetType() != null){
						if(pet.getPetType().getId() == null){
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					}else{
						throw new RuntimeException("Pet type is mandatory");
					}
					
					//	Setting id for pet
					if(pet.getId() == null){
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
		}
		else
			return null;
		
		
		
		return super.save(object);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		//TODO
		return null;
	}
	
	
}