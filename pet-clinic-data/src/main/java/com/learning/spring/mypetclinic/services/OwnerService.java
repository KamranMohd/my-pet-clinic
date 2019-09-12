package com.learning.spring.mypetclinic.services;

import java.util.List;

import com.learning.spring.mypetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
}
