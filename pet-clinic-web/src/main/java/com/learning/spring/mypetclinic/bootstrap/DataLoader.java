package com.learning.spring.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.spring.mypetclinic.model.Owner;
import com.learning.spring.mypetclinic.model.PetType;
import com.learning.spring.mypetclinic.model.Vet;
import com.learning.spring.mypetclinic.services.OwnerService;
import com.learning.spring.mypetclinic.services.PetTypeService;
import com.learning.spring.mypetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
		
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}



	@Override
	public void run(String... args) throws Exception {
		PetType dog = new PetType();
		dog.setName("Dog");
		petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		petTypeService.save(cat);
		
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Mohd");
		owner1.setLastName("Kamran");
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Mohit");
		owner2.setLastName("Singh");
		ownerService.save(owner2);
		
		Owner owner3 = new Owner();
		owner3.setFirstName("Shubhra");
		owner3.setLastName("Pandey");
		ownerService.save(owner3);
		System.out.println("Owners are loaded....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Priyanshu");
		vet1.setLastName("Chauhan");
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Nalin");
		vet2.setLastName("Gupta");
		vetService.save(vet2);
		System.out.println("Vets are loaded...");

	}

}
