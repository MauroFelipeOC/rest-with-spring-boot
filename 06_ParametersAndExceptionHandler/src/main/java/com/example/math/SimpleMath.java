package com.example.math;

import com.example.exceptions.UnsuportedMathOperationException;
import com.example.request.converters.NumberConverter;

public class SimpleMath {	
	
	public Double sum(String numberOne, String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		
		return NumberConverter.converToDouble(numberOne) + NumberConverter.converToDouble(numberTwo);
	}
	
	public Double subtraction(String numberOne, String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		
		return NumberConverter.converToDouble(numberOne) - NumberConverter.converToDouble(numberTwo);
	}
	
	public Double multiplication(String numberOne, String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		
		return NumberConverter.converToDouble(numberOne) * NumberConverter.converToDouble(numberTwo);
	}
	
	public Double division(String numberOne, String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {			
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		
		return NumberConverter.converToDouble(numberOne) / NumberConverter.converToDouble(numberTwo);
	}
	
	public Double average(String numberOne, String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {			
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		
		return (NumberConverter.converToDouble(numberOne) + NumberConverter.converToDouble(numberTwo)) / 2;
	}
	
	public Double sqrt(String numberOne) {
		if(!NumberConverter.isNumeric(numberOne)) {			
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}		
				
		return Math.sqrt(NumberConverter.converToDouble(numberOne));
	}

}
