package br.com.dalmeida.tiago.service;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.dalmeida.tiago.exceptions.UnsupportedMathOperationException;
import br.com.dalmeida.tiago.model.dto.MathDTO;

@Service
public class MathService {
	
	public Double sum (@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{
				
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	public Double subtraction (@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	public Double multiplication (@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	public Double division (@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	public Double mean (@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
	}
	
	public Double squareRoot (@PathVariable(value = "numberOne") String number)
			throws Exception{
		if(!isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	
		return Math.sqrt(convertToDouble(number));
	}
	
	
	// Conversão de String para Double
	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		
		String number = strNumber.replaceAll(",",".");
		
		if (isNumeric(number)) return Double.parseDouble(number);
		
		return null;
	}

	
	// Verificação de Numerico
	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		
		String number = strNumber.replaceAll(",",".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
