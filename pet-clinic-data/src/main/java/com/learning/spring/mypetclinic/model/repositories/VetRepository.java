package com.learning.spring.mypetclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.spring.mypetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long>{

}
