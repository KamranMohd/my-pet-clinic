package com.learning.spring.mypetclinic.services;

import java.util.Set;

import com.learning.spring.mypetclinic.model.Pet;

public interface PetService {
	Pet findById(Long id);

	Pet save(Pet pet);

	Set<Pet> findAll();
}
