package com.crud.app.repository;

import com.crud.app.entity.Owner;
import com.crud.app.entity.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Long>{

}
