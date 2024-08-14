package br.com.dalmeida.tiago.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.dalmeida.tiago.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<Person> findByAll() {
		List<Person> persons = new ArrayList<>();
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons ;
	}

	public Person findById(String id) {
		
		logger.info("Finding a person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Tiago");
		person.setLastName("Goncalves");
		person.setAddress("Rio de Janeiro, Rio de Janeiro - Brazil");
		person.setGender("Male");
		
		return person;
	}
	
	public Person createPerson(Person person) {
		logger.info("Creating a person!");
		return person;
	}
	
	public Person updatePerson(Person person) {
		logger.info("Updating a person!");
		return person;
	}
	
	public void deletePerson(String id) {
		logger.info("Deleting a person!");
	}
	
	private Person mockPerson(int i) {

		logger.info("Finding all persons!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person firstName " + i);
		person.setLastName("Person lastName " + i);
		person.setAddress("Some address in Brazil " + i);
		person.setGender("Male");
		
		return person;
	}
}
