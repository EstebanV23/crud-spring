package com.crud.app.service;

import com.crud.app.entity.Owner;
import com.crud.app.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerServiceImplementation implements OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Owner> findAll(){
		return (List<Owner>) ownerRepository.findAll();
	}

	@Override
	public void save(Owner owner) {
		ownerRepository.save(owner);
	}

	@Override
	@Transactional(readOnly = true)
	public Owner FindOne(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		ownerRepository.deleteById(id);
	}

}
