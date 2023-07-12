package com.codingdojo.guardiadelzoologico1;

public class Mammal {
	
	private int levelEnergy = 100;
	
	public void displayEnergy() {
		System.out.println("El nivel de energia actual es: " + getLevelEnergy());
	}

	public int getLevelEnergy() {
		return levelEnergy;
	}

	public void setLevelEnergy(int levelEnergy) {
		this.levelEnergy += levelEnergy;
	}
}