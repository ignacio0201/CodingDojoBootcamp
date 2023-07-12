package com.codingdojo.guardiadelzoologico1;

public class Gorilla extends Mammal {
	
	//Constructor
	public Gorilla() {
	}
	
	// METODOS
	// Lanzar cosas (-5 energia)
	void throwSomething() {
		//Cuando la energia sea > 10
		if(getLevelEnergy() > 10) {
			setLevelEnergy(-5);
			System.out.println("Donkey Kong ha lanzado una roca! " + "Su nivel de energia ahora es: " + getLevelEnergy());
		}
		//Cuando la energia quede en 5
		else if(getLevelEnergy() == 10) {
			setLevelEnergy(-5);
			System.out.println("¡Oh no! Donkey Kong tiene poca energia :( ¡Debe "
					+ "alimentarse para recuperarse y no morir! " + "Su nivel de energia ahora es: " + getLevelEnergy());
		}
		//Cuando la energia quede en 0
		else if(getLevelEnergy() == 5){
			System.out.println("Donkey Kong ha muerto :(");
		}
	}

	// Comer Bananas (+10)
	void eatBananas() {
		//Cuando la energia sea >= 95 o la energia sea 100
		if(getLevelEnergy() >= 95 || getLevelEnergy() == 100) {
			System.out.println("¡Oh vaya! ¡Al parecer Donkey Kong ha comido suficiente!");
		}
		//Cuando la energia sea >= 5
		else if (getLevelEnergy() >= 5) {
			setLevelEnergy(+10);
			System.out.println("Ajam! Yummy yummy! " + "Su nivel de energia ahora es: " + getLevelEnergy());
		}
	}

	// Escalar arboles (-10)
	void climb() {
		//Cuando la energia quede en 20
		if (getLevelEnergy() == 20) {
			setLevelEnergy(-10);
			System.out.println("Donkey Kong ha trepado a la cima del arbol " + "¡Cuidado, le queda poca energia! " + "Su nivel de energia ahora es: " + getLevelEnergy());
		}
		//Cuando la energia sea > 20
		else if(getLevelEnergy() > 20) {
			setLevelEnergy(-10);
			System.out.println("Donkey Kong ha trepado a la cima del arbol! " + "Su nivel de energia ahora es: " + getLevelEnergy());
		}
		//Cuando la energia sea <= 10
		else if(getLevelEnergy() <= 10) {
			setLevelEnergy(-10);
			System.out.println("Donkey Kong ha muerto :(");
		}
	}
}