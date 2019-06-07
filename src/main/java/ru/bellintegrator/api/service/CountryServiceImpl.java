package ru.bellintegrator.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.bellintegrator.api.daoCountry.CountryDao;
import ru.bellintegrator.api.model.Country;
import ru.bellintegrator.api.views.CountryView;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

	private final CountryDao countryDao;

	@Autowired
	public CountryServiceImpl(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	@Override
	public List<CountryView> getAllCountries() {
		return mapAllCountries(countryDao.all());
	}

	private CountryView mapCountry(Country country) {
		CountryView view = new CountryView();
		view.setCode(country.getCode());
		view.setName(country.getName());
		return view;
	}

	private List<CountryView> mapAllCountries(List<Country> countries) {
		List<CountryView> countryViews = new ArrayList<>();
		for (Country country : countries) {
			CountryView cv = mapCountry(country);
			countryViews.add(cv);
		}
		return countryViews;
	}
}
