package com.learning.spring.mypetclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.spring.mypetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>{

}
