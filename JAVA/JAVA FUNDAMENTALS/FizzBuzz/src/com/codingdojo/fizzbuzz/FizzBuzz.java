package com.codingdojo.fizzbuzz;

/*Escribir un programa que tomará un entero y mostrará en pantalla Fizz 
 *si el número es divisible por 3, Buzz si el número es divisible por 5,
 *FizzBuzz si el número es divisible por 3 y 5 y para el resto de los casos
 *mostrará el número que se ingresó.

 Objetivos
 Practicar condicionales.
 Implementar un algoritmo clásico de entrevista.*/

public class FizzBuzz {

	public static void imprimirFizzBuzz(int number) {
		
		if (number % 15 == 0) {
		System.out.println("FizzBuzz");

		}else if (number % 3 == 0) {
			System.out.println("Fizz");
			
		}else if (number % 5 == 0) {
			System.out.println("Buzz");
			
		}else {
			System.out.println(number);
		}
	}
}
