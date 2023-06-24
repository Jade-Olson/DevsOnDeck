package com.dojo.devsondeck.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.devsondeck.models.User;

@Repository
public interface userRepo extends CrudRepository<User,Long> {
	
	List<User> findAll();

}
