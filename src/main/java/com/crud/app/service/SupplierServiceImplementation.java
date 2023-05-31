package com.crud.app.service;

import com.crud.app.entity.Supplier;
import com.crud.app.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierServiceImplementation implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Supplier> findAll(){
		return (List<Supplier>) supplierRepository.findAll();
	}

	@Override
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	@Override
	@Transactional(readOnly = true)
	public Supplier FindOne(Long id) {
		return supplierRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		supplierRepository.deleteById(id);
	}

}
