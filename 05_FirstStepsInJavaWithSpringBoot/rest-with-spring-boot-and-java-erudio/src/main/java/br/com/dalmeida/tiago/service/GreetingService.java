package br.com.dalmeida.tiago.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.dalmeida.tiago.model.dto.GreetingDTO;

@Service
public class GreetingService {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	public GreetingDTO greeting (String name) {
	
		return new GreetingDTO(counter.incrementAndGet(), String.format(template, name));
	}
}
