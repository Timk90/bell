package ru.bellintegrator.api;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.bellintegrator.api.model.User;
import ru.bellintegrator.api.service.UserService;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
