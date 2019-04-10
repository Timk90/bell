package ru.bellintegrator.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@RequestMapping("/ping")
	public String ping(){
		return "pong";
	}
	
}
