package ru.bellintegrator.api.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import ru.bellintegrator.api.views.CountryView;
import ru.bellintegrator.api.views.DocumentView;

public interface CountryService {
	
	List<CountryView> getAllCountries();
	
}
