package com.crud.app.repository;

import com.crud.app.entity.Employee;
import com.crud.app.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long>{

}
