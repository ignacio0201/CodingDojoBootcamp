package com.codingdojo.cuentadebanco;

import java.util.ArrayList;

public class BankAccount {
	
	//Atributos objeto
	private String numeroCta;
	private double saldoCtaCorriente = 0.0;
	private double saldoCtaAhorros = 0.0;
	
	//Atributos clase
	private String nombre;
	private static Integer numCtasCreadas = 0;
	@SuppressWarnings("unused")
	private static double cantidadDineroCta;
	
	//Constructor
	public BankAccount(String nombre) {
		numCtasCreadas++;
		this.nombre = nombre;
		numeroCta = generarNumCta();
		cantidadDineroCta = getCantidadDineroCta();
	}
	
	//Generador Num. Cta. 10 Digitos
	private String generarNumCta() {
		
		ArrayList<Integer> ctaGenerada;
		ctaGenerada = new ArrayList<Integer>();
		
		for(int i = 0; i <= 9; i++) {
			int numRandom;
			numRandom = (int) (Math.random() * 10);
			ctaGenerada.add(numRandom);
		}
		
		String numCta = ctaGenerada.toString().replace("[", "").replace("]", "")
				.replace(",", "").replaceAll("\\s", "");
		return numeroCta = numCta;
	}
	
	//Depositar Dinero
	public void depositarDinero(String tipoCta, double cantidad) {
		
		//Si la cuenta es Corriente
		if(tipoCta.equalsIgnoreCase("Corriente")) { 
			this.saldoCtaCorriente += cantidad;
			String nuevoSaldoCtaCorriente = String.format("%.2f", this.saldoCtaCorriente);
			System.out.println(this.nombre + ", su depósito fue exitoso "
					+ "\nSu nuevo saldo de Cuenta Corriente es $"
					+ nuevoSaldoCtaCorriente);
		}
		//Si la cuenta es de Ahorros
		else if(tipoCta.trim().equalsIgnoreCase("Ahorros") 
				|| tipoCta.trim().equalsIgnoreCase("Ahorro")) { 
			this.saldoCtaAhorros += cantidad;
			String nuevoSaldoCtaAhorros = String.format("%.2f", this.saldoCtaAhorros);
			System.out.println(this.nombre + ", su depósito fue exitoso "
					+ "\nSu nuevo saldo de Cuenta de Ahorros es $"
					+ nuevoSaldoCtaAhorros);
		}
	}
	
	//Retirar dinero
	public void retirarDinero(String tipoCta, double cantidad) {
		
		//Si la cuenta es Corriente
		if(tipoCta.trim().equalsIgnoreCase("Corriente")) {
			//Si no tiene fondos suficientes
			if(this.saldoCtaCorriente < cantidad || this.saldoCtaCorriente == 0) {
				System.out.println("No tiene fondos suficientes");
			}else {
				this.saldoCtaCorriente -= cantidad;
				String nuevoSaldoCtaCorriente = String.format("%.2f", this.saldoCtaCorriente);
				System.out.println(this.nombre + ", su retiro fue exitoso "
						+ "\nSu nuevo saldo de Cuenta Corriente es $"
						+ nuevoSaldoCtaCorriente);
			}
		}
		
		//Si la cuenta es de Ahorros
		else if(tipoCta.trim().equalsIgnoreCase("Ahorros") || tipoCta.trim().equalsIgnoreCase("Ahorro")){
			//Si no tiene fondos
			if(this.saldoCtaAhorros < cantidad || this.saldoCtaCorriente == 0) {
				System.out.println("No tiene fondos suficientes");
			}else {
				this.saldoCtaAhorros -= cantidad;
				String nuevoSaldoCtaAhorros = String.format("%.2f", this.saldoCtaAhorros);
				System.out.println(this.nombre + ", su retiro fue exitoso "
						+"\nSu nuevo saldo de Cuenta de Ahorros es $"
						+ nuevoSaldoCtaAhorros);
			}
		}
	}
	
	//Getters
	//Mostrar nombre
	public String getNombre() {
			return this.nombre;
	}
	//Obtener número de cuenta
	public void getNumDeCuenta() {
		System.out.println(this.nombre + ", su número de cuenta es " + this.numeroCta);
	}
	//Obtener Saldo Cta. Corriente
	public void getSaldoCtaCorriente() {
		System.out.println(this.nombre + ", su saldo de Cuenta de Corriente es $" + this.saldoCtaCorriente);
	}
	//Obtener Saldo Cta. Ahorros
	public void getSaldoCtaAhorros() {
		System.out.println(this.nombre + ", su saldo de Cuenta de Ahorros es $" + this.saldoCtaAhorros);
	}
	//Mostrar saldo total (Cta Corriente + Cta Ahorros)
	public void mostrarSaldoTotal() {
		String saldoTotal = String.format("%.2f", this.saldoCtaCorriente + this.saldoCtaAhorros);
		System.out.println(this.nombre + ", el saldo total de ambas cuentas es $" + saldoTotal);
	}
	//Obtener el número de cuentas creadas
	public static Integer getNumCtasCreadas() {
		return numCtasCreadas;
	}
	//Obtener dinero total de cada cuenta
	public double getCantidadDineroCta(){
		return this.saldoCtaCorriente + this.saldoCtaAhorros;
	}
}