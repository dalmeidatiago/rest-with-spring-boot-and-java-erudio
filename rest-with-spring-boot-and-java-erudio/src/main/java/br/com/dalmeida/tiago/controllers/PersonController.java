package br.com.dalmeida.tiago.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import br.com.dalmeida.tiago.model.Person;
import br.com.dalmeida.tiago.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private final PersonService personService;

    PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) {
        return personService.findById(id);
    }
    
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findByAll() {
        return personService.findByAll();
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
    
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable(value = "id") String id) {
        personService.deletePerson(id);
    }
}