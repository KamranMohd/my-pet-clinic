package com.learning.spring.mypetclinic.services;

import java.util.Set;

import com.learning.spring.mypetclinic.model.Vet;

public interface VetService {
	Vet findById(Long id);

	Vet save(Vet vet);

	Set<Vet> findAll();
}
