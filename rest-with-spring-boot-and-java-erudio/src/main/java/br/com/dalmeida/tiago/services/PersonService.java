package br.com.dalmeida.tiago.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dalmeida.tiago.exceptions.ResourceNotFoundException;
import br.com.dalmeida.tiago.model.Person;
import br.com.dalmeida.tiago.repositories.PersonRepository;

@Service
public class PersonService {
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		
		logger.info("Finding all persons!");
		
		return repository.findAll() ;
	}

	public Person findById(Long id) {
		
		logger.info("Finding a person!");
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person createPerson(Person person) {
		logger.info("Creating a person!");
		return repository.save(person);
	}
	
	public Person updatePerson(Person person) {
		logger.info("Updating a person!");
		
		Person entity = repository.findById(person.getId()).orElseThrow(
				() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void deletePerson(Long id) {
		
		logger.info("Deleting a person!");
		
		Person entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
}
