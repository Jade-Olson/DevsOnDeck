package com.dojo.devsondeck.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.devsondeck.models.Position;
import com.dojo.devsondeck.repositories.PositionRepo;

@Service
public class PositionService {
	
	@Autowired
	private PositionRepo positionRepo;
	
	public Position AddPosition(Position position) {
		return positionRepo.save(position);
	}

}
