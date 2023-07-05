package com.codingdojo.manipulaciondecadenas;

public class StringManipulator{
	
	//Ej 1
	public String trimAndConcat(String str1, String str2) {
		return str1.trim() + str2.trim();
	}
	
	//Ej 2
	public int getIndexOrNull(String str, char chr) {
		return str.indexOf(chr); 
	}
	
	//Ej 3
	public int getIndexOrNull(String str1, String str2) {
		return str1.indexOf(str2);
	}
	
	//Ej 4
	public String concatSubstring(String str1, int int1, int int2, String str2) {
		return str1.substring(int1,int2) + str2;
	}
}