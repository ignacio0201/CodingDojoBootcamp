package com.codingdojo.maestrodeobjetos1;

public class Human {
	//Atributos
	private String name;
	private int strength;
	private int stealth;
	private int intelligence;
	private int health;
	 
	//Constructor
	public Human(String name) {
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 3;
		this.health = 100;
		this.setName(name);
	}
	 
	//Atacar
	void attack(Human enemy) {
		this.health -= this.strength;
		System.out.println(getName() + ", Atacaste a " + enemy.getName() + 
				", "+ "\nSalud del contrincante: " + this.health);
	}
	 
	//Getters y setters
	
	//Strength
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	//Stealth
	public int getStealth() {
		return stealth;
	}
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	
	//Intelligence
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	//Health
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	//Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
