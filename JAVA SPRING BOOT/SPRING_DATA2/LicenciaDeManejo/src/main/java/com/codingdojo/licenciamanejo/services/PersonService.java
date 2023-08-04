package com.codingdojo.licenciamanejo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.licenciamanejo.models.Person;
import com.codingdojo.licenciamanejo.repositories.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	
	// Create a person
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	//Find all persons
	public List<Person> findAllPersons() {
		return personRepository.findByLicenseIsNull();
	}
	
	//Find person by id
	public Optional<Person> findPersonById(Long id) {
		return personRepository.findById(id);
	}
}
