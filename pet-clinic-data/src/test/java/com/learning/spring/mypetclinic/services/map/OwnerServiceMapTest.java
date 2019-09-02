package com.learning.spring.mypetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.spring.mypetclinic.model.Owner;

public class OwnerServiceMapTest {

	OwnerServiceMap ownerMapService;
	private Long id = 1L;
	
	@BeforeEach
	public void setUp() throws Exception {
		ownerMapService = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		Owner owner = new Owner();
		owner.setId(id);
		ownerMapService.save(owner);
	}

	@Test
	public void testSaveOwner() {
		Owner owner = new Owner();
		owner.setId(id);
		Owner savedOwner = ownerMapService.save(owner);
		assertEquals(id, savedOwner.getId());
	}

	@Test
	public void testFindAll() {
		Set<Owner> owners = ownerMapService.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	public void testFindByIdLong() {
		Owner owner = ownerMapService.findById(id);
		assertEquals(id, owner.getId());
	}

	@Test
	public void testDeleteByIdLong() {
		ownerMapService.deleteById(id);
		assertEquals(0, ownerMapService.findAll().size());
	}
}