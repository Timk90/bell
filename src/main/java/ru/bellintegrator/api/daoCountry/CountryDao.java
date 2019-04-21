package ru.bellintegrator.api.daoCountry;

import java.util.List;

import ru.bellintegrator.api.model.Country;

public interface CountryDao {
    
    public List<Country> all();

    public Country loadById(Long id);
    
    public void save(Country office);
}
