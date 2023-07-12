package com.codingdojo.guardiadelzoologico2;

public class Bat extends RareSpecimen{

	// Constructor
	public Bat() {
	}
	
	// METODOS
	// Volar (-50 de energia)
	void fly() {
		//Si la energia es > 50
		if(getLevelEnergy() > 50) {
			setLevelEnergy(-50);
			System.out.println("¡Zzzziiippp! El murciélago está volando " + 
					"El nivel de energia es: " + getLevelEnergy());
		}
		//Si la energia alcanza los 50
		else if (getLevelEnergy() == 50) {
			System.out.println("El murciélago no puede volar porque tiene poca energía. ¡Debe comer sino morirá! " + 
					"El nivel de energia es: " + getLevelEnergy());
		}
	}

	// Comer humanos (+25 de energia)
	void eatHumans() {
		//Si la energia es <= 275
		if (getLevelEnergy() <= 275) {
			setLevelEnergy(+25);
			System.out.println("Bueno, no importa. " + "El nivel de energia es: " + getLevelEnergy());
		}
		//Si la energia alcanza los 300 (el máximo)
		else if(getLevelEnergy() == 300) {
			System.out.println("¡Yum! Creo que he comido suficiente. " + "El nivel de energia es: " + getLevelEnergy());
		}
	}

	// Atacar a la ciudad (-100 de energia)
	void attackTown() {
		//Si la energia es > 100
		if (getLevelEnergy() > 100) {
			setLevelEnergy(-100);
			System.out.println("¡Crackle! ¡La ciudad está en llamas! " + "El nivel de energia es: " + getLevelEnergy());
		}
		//Si la energia es <= 100
		else if (getLevelEnergy() <= 100) {
			System.out.println("¡Oh vaya! No puedo atacar, necesito comer para recuperarme sino moriré. "
					+ "El nivel de energia es: " + getLevelEnergy());
		}
	}
}
