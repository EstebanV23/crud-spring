package com.crud.app.service;

import com.crud.app.entity.PersonalComputer;

import java.util.List;

public interface PersonalComputerService {
	
	public List<PersonalComputer> findAll();
	
	public void save (PersonalComputer personalComputer);
	
	public PersonalComputer FindOne(Long id);
	
	public void delete(Long id);

}
