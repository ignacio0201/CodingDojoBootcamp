package com.codingdojo.guardiadelzoologico2;

public class BatTest {

	public static void main(String[] args) {
		
		Bat diadema = new Bat();
		
		//Atacar la ciudad
		diadema.attackTown();
		diadema.attackTown();
		diadema.attackTown();
		
		//Comer humanos
		diadema.eatHumans();
		diadema.eatHumans();
		
		//Volar
		diadema.fly();
		diadema.fly();
		
		//Mostrar nivel de energia
		diadema.displayEnergy();
	}
}
