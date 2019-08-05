package com.learning.spring.mypetclinic.services;

import java.util.Set;

import com.learning.spring.mypetclinic.model.Owner;

public interface OwnerService {
	Owner findByLastName(String lastName);

	Owner findById(Long id);

	Owner save(Owner owner);

	Set<Owner> findAll();
}
