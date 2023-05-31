package com.crud.app.service;

import com.crud.app.entity.Supplier;

import java.util.List;

public interface SupplierService {
	
	public List<Supplier> findAll();
	
	public void save (Supplier supplier);
	
	public Supplier FindOne(Long id);
	
	public void delete(Long id);

}
