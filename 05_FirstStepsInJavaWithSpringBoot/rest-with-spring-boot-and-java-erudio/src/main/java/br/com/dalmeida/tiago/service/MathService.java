package br.com.dalmeida.tiago.service;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.dalmeida.tiago.exceptions.UnsupportedMathOperationException;
import br.com.dalmeida.tiago.model.dto.MathDTO;

@Service
public class MathService {
	
	public Double sum (
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
				
			if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
			return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		
		String number = strNumber.replaceAll(",",".");
		
		if (isNumeric(number)) return Double.parseDouble(number);
		
		return null;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		
		String number = strNumber.replaceAll(",",".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
