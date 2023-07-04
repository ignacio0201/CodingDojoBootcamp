package com.codingdojo.teoremadepitagoras;

public class Pitagoras {
    public static double calcularHipotenusa(int catetoA, int catetoB) {
    	return Math.sqrt(Math.pow(catetoA, 2)+Math.pow(catetoB, 2));
    }
}