package com.learning.spring.mypetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.learning.spring.mypetclinic.model.Speciality;
import com.learning.spring.mypetclinic.model.repositories.SpecialityRepository;
import com.learning.spring.mypetclinic.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

	private final SpecialityRepository specialityRepository;

	public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
		super();
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<>();
		specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		return specialityRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialityRepository.save(object);
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}

}
