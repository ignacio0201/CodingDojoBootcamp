package com.codingdojo.calculadora1;

public class Calculadora1Test {

	public static void main(String[] args) {
		Calculadora1 miCalculadora = new Calculadora1();
		
		miCalculadora.setOperandOne(10.5);
		miCalculadora.setOperation("+");
		miCalculadora.setOperandTwo(5.2);
		miCalculadora.performOperation();
		miCalculadora.getResult();
	}
}
