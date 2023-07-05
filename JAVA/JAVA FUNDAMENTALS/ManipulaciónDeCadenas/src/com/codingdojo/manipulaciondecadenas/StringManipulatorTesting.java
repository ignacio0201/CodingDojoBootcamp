package com.codingdojo.manipulaciondecadenas;

public class StringManipulatorTesting {

	public static void main(String[] args) {
		
		StringManipulator manipulator = new StringManipulator();
		//Ej 1
		String str = manipulator.trimAndConcat("    Hola     ","     Mundo    ");
		System.out.println(str); // HolaMundo 
		
		//Ej 2
		char letter = 'n';
		int a = manipulator.getIndexOrNull("Coding", letter);
		int b = manipulator.getIndexOrNull("Hola Mundo", letter);
		int c = manipulator.getIndexOrNull("Saludar", letter);
		System.out.println(a); // 4
		System.out.println(b); // 7
		System.out.println(c); // -1
		
		//Ej 3
		String word = "Hola";
		String subString = "la";
		String notSubString = "mundo";
		int d = manipulator.getIndexOrNull(word, subString);
		int f = manipulator.getIndexOrNull(word, notSubString);
		System.out.println(d); // 2
		System.out.println(f); // -1
		
		//Ej 4
		StringManipulator manipulator2 = new StringManipulator();
		String word2 = manipulator2.concatSubstring("Hola", 1, 3, "mundo");
		System.out.println(word2); // olmundo
	}
}
