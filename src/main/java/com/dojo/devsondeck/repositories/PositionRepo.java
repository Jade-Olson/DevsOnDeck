package com.dojo.devsondeck.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.dojo.devsondeck.models.Position;

public interface PositionRepo extends CrudRepository<Position,Long>{
	
	List<Position> findAll();
}
