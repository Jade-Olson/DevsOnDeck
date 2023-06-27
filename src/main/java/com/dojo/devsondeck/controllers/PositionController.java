package com.dojo.devsondeck.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dojo.devsondeck.services.PositionService;

@Controller
public class PositionController {
	
	@Autowired
	private PositionService positionServ;
	
	

}
