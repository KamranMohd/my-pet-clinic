package com.learning.spring.mypetclinic.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.spring.mypetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
}
