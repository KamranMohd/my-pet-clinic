package com.learning.spring.mypetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.learning.spring.mypetclinic.model.Owner;
import com.learning.spring.mypetclinic.model.repositories.OwnerRepository;
import com.learning.spring.mypetclinic.model.repositories.PetRepository;
import com.learning.spring.mypetclinic.model.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class OwnerSDJpaServiceTest {

	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerSDJpaService service;
	
	@BeforeEach
	public void setUp() throws Exception {
		
	}

	@Test
	public void testFindAll() {
		Owner owner = service.findById(1L);
	}

	@Test
	public void testFindById() {
	}

	@Test
	public void testSave() {
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testDeleteById() {
	}

}
