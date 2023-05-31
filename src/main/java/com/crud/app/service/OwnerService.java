package com.crud.app.service;

import com.crud.app.entity.Owner;

import java.util.List;

public interface OwnerService {
	
	public List<Owner> findAll();
	
	public void save (Owner owner);
	
	public Owner FindOne(Long id);
	
	public void delete(Long id);

}
