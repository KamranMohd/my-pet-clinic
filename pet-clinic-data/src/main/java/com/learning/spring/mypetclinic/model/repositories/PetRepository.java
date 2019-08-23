package com.learning.spring.mypetclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.spring.mypetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
