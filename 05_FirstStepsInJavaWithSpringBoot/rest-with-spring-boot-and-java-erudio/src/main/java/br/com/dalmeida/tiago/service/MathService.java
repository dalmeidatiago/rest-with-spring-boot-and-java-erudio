package br.com.dalmeida.tiago.service;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.dalmeida.tiago.model.dto.MathDTO;

@Service
public class MathService {
	
	public Double sum (@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) {
			
		return 1D;
	}
}
