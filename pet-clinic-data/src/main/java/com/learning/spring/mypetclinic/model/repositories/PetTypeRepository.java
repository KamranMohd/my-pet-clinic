package com.learning.spring.mypetclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.spring.mypetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
