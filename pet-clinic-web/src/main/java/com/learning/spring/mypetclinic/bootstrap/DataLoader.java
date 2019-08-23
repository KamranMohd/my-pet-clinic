package com.learning.spring.mypetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.spring.mypetclinic.model.Owner;
import com.learning.spring.mypetclinic.model.Pet;
import com.learning.spring.mypetclinic.model.PetType;
import com.learning.spring.mypetclinic.model.Speciality;
import com.learning.spring.mypetclinic.model.Vet;
import com.learning.spring.mypetclinic.model.Visit;
import com.learning.spring.mypetclinic.services.OwnerService;
import com.learning.spring.mypetclinic.services.PetTypeService;
import com.learning.spring.mypetclinic.services.SpecialityService;
import com.learning.spring.mypetclinic.services.VetService;
import com.learning.spring.mypetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
		
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService, VisitService visitService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}



	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		if(count == 0)
			loadData();
	}



	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Mohd");
		owner1.setLastName("Kamran");
		owner1.setAddress("SuperTech Capetown");
		owner1.setCity("Noida");
		owner1.setTelephone("9654747357");
		
		Pet kamransPet = new Pet();
		kamransPet.setPetType(savedDogPetType);
		kamransPet.setOwner(owner1);
		kamransPet.setBirthDate(LocalDate.now());
		kamransPet.setName("Rosco");
		owner1.getPets().add(kamransPet);
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Mohit");
		owner2.setLastName("Singh");
		owner2.setAddress("Gomti Nagar");
		owner2.setCity("Lucknow");
		owner2.setTelephone("9458886332");
		
		Pet mohitsPet = new Pet();
		mohitsPet.setPetType(savedCatPetType);
		mohitsPet.setOwner(owner2);
		mohitsPet.setBirthDate(LocalDate.now());
		mohitsPet.setName("Ruhi");
		owner2.getPets().add(mohitsPet);
		ownerService.save(owner2);
		
		Visit catVisit = new Visit();
		catVisit.setPet(mohitsPet);
		catVisit.setDescription("Mohit's Cat");
		catVisit.setDate(LocalDate.now());
		visitService.save(catVisit);
		
		Owner owner3 = new Owner();
		owner3.setFirstName("Shubhra");
		owner3.setLastName("Pandey");
		ownerService.save(owner3);
		System.out.println("Owners are loaded....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Priyanshu");
		vet1.setLastName("Chauhan");
		vet1.getSpecialities().add(savedRadiology);
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Nalin");
		vet2.setLastName("Gupta");
		vet2.getSpecialities().add(savedSurgery);
		vet2.getSpecialities().add(savedDentistry);

		vetService.save(vet2);
		System.out.println("Vets are loaded...");
	}

}
