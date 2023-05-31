package com.crud.app.service;

import com.crud.app.entity.PersonalComputer;
import com.crud.app.repository.PersonalComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalComputerServiceImplementation implements PersonalComputerService {

	@Autowired
	private PersonalComputerRepository personalComputerRepository;

	@Override
	@Transactional(readOnly = true)
	public List<PersonalComputer> findAll(){
		return (List<PersonalComputer>) personalComputerRepository.findAll();
	}

	@Override
	public void save(PersonalComputer personalComputer) {
		personalComputerRepository.save(personalComputer);
	}

	@Override
	@Transactional(readOnly = true)
	public PersonalComputer FindOne(Long id) {
		return personalComputerRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		personalComputerRepository.deleteById(id);
	}

}
