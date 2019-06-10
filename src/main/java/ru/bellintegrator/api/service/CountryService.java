package ru.bellintegrator.api.service;

import java.util.List;

import ru.bellintegrator.api.views.CountryView;

/**
 * сервис гражданства
 */
public interface CountryService {

	/**
	 * получить список всех стран
	 * 
	 * @return
	 */
	List<CountryView> getAllCountries();

}
