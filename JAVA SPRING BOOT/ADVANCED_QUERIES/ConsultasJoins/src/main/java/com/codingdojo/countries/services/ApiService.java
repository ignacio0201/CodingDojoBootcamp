package com.codingdojo.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.countries.repositories.CityRepository;
import com.codingdojo.countries.repositories.CountryRepository;
import com.codingdojo.countries.repositories.LanguageRepository;

@Service
public class ApiService {
	
	@Autowired private CityRepository cityRepo; 
	@Autowired private CountryRepository countryRepo;
	@Autowired private LanguageRepository lenguageRepo;
	
	//1
	public List<Object[]> buscarPaisesQueHablanEsloveno(){
		return countryRepo.findCountriesWithSloveneLanguage();
	}
	//2
	public List<Object[]> buscarCiudadesPorPaises(){
		return countryRepo.findCitiesByCountries();
	}
	//3
	public List<Object[]> buscarCiudadesMexicoPorPoblacion(){
		return cityRepo.findCitiesOfMexicoByPopulation();
	}
	//4
	public List<Object[]> buscarLenguajePorPorcentaje(){
		return lenguageRepo.findLanguageByPercentage();
	}
	//5
	public List<Object[]> buscarPaisesPorSuperficie(){
		return countryRepo.findCountriesBySurface();
	}
	//6
	public List<Object[]> buscarPaisesPorGobiernoMonarquico(){
		return countryRepo.findCountriesByGobMonarchy();
	}
	//7
	public List<Object[]> buscarCiudadesArg(){
		return cityRepo.findCitiesArg();
	}
	//8
	public List<Object[]> buscarPaisesPorRegion(){
		return countryRepo.findCountriesByRegion();
	}
	
}
