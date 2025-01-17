package br.com.dalmeida.tiago.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dalmeida.tiago.model.dto.MathDTO;
import br.com.dalmeida.tiago.service.MathService;

@RestController
public class MathController {
	
	private final MathService mathService;
	
	@Autowired
	public MathController(MathService mathService) {
        this.mathService = mathService;
    };
    
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
    		@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
    	
        return mathService.sum(numberOne, numberTwo);
    }
    
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
    		@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
    	
        return mathService.subtraction(numberOne, numberTwo);
    }
    
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
    		@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
    	
        return mathService.multiplication(numberOne, numberTwo);
    }
    
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable(value = "numberOne") String numberOne,
    		@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
    	
        return mathService.division(numberOne, numberTwo);
    }
    
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable(value = "numberOne") String numberOne,
    		@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
    	
        return mathService.mean(numberOne, numberTwo);
    }
    
    @RequestMapping("/squareRoot/{number}")
    public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {
    	
        return mathService.squareRoot(number);
    }
}