package br.com.dalmeida.tiago.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dalmeida.tiago.model.dto.GreetingDTO;
import br.com.dalmeida.tiago.service.GreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	private final GreetingService greetingService;
	
	@Autowired
	public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    };
    
    @GetMapping
    public GreetingDTO greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingService.greeting(name);
    }

	
}
