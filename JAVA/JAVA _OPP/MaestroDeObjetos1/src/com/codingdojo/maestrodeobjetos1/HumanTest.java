package com.codingdojo.maestrodeobjetos1;

public class HumanTest {

	public static void main(String[] args) {
		
		Wizard gandalf = new Wizard("Gandalf");
		Ninja jackieChan = new Ninja("Jackie Chan");
		Samurai miyamotoMusashi = new Samurai ("Miyamoto Musashi");
		
		gandalf.attack(jackieChan);
		gandalf.attack(jackieChan);
		
		jackieChan.attack(gandalf);
		
		miyamotoMusashi.attack(jackieChan);
	}
}
