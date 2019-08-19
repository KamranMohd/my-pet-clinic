package com.learning.spring.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.spring.mypetclinic.model.Owner;
import com.learning.spring.mypetclinic.model.Vet;
import com.learning.spring.mypetclinic.services.OwnerService;
import com.learning.spring.mypetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Mohd");
		owner1.setLastName("Kamran");
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Mohd");
		owner2.setLastName("Saquib");
		ownerService.save(owner2);
		System.out.println("Owners are loaded....");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Mohit");
		vet1.setLastName("Singh");
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Pratibha");
		vet2.setLastName("Singh");
		vetService.save(vet2);
		System.out.println("Vets are loaded...");

	}

}
