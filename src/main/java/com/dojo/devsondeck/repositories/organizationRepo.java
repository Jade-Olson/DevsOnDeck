package com.dojo.devsondeck.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.devsondeck.models.Organization;

@Repository
public interface organizationRepo extends CrudRepository<Organization,Long>{
	
	List<Organization> findAll();
	Optional<Organization> findByEmail(String email);

}
