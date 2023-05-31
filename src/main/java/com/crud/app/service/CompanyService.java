package com.crud.app.service;

import com.crud.app.entity.Company;

import java.util.List;

public interface CompanyService {
	
	public List<Company> findAll();
	
	public void save (Company company);
	
	public Company FindOne(Long id);
	
	public void delete(Long id);

}
