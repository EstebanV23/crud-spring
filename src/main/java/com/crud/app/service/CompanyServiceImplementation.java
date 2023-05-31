package com.crud.app.service;

import com.crud.app.entity.Company;
import com.crud.app.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImplementation implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Company> findAll(){
		return (List<Company>) companyRepository.findAll();
	}

	@Override
	public void save(Company company) {
		companyRepository.save(company);
	}

	@Override
	@Transactional(readOnly = true)
	public Company FindOne(Long id) {
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		companyRepository.deleteById(id);
	}

}
