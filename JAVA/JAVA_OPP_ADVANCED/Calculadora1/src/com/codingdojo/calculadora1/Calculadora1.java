package com.codingdojo.calculadora1;

public class Calculadora1 {
	//Atributos
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double result;
	
	//Constructor
	public Calculadora1() {
	}
	
	//Setters
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	//Realizar operacion
	void performOperation() {
		if(this.operation == "+".trim()) {
			result = this.operandOne + this.operandTwo;
		}else if(this.operation == "-".trim()) {
			result = this.operandOne - this.operandTwo;
		}else {
			System.out.println("Asegurese de ingresar valores válidos");
		}
	}
	
    //Getters
	//Obtener resultado
	public void getResult() {
		System.out.println(result);
	}
}
