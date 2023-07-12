package com.codingdojo.guardiadelzoologico2;

public class RareSpecimen {
	
	private int levelEnergy = 300;
	
	//Mostrar nivel de energia
	public void displayEnergy() {
		System.out.println("El nivel de energia es: " + getLevelEnergy());
	}

	public int getLevelEnergy() {
		return levelEnergy;
	}

	public void setLevelEnergy(int levelEnergy) {
		this.levelEnergy += levelEnergy;
	}
}
