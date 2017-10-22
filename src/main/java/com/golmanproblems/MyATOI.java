package com.golmanproblems;

public class MyATOI {

	public static void main(String[] args) {
		Integer i = 97;
		System.out.println(printCharacter(100));

	}

	private static char printCharacter(Integer n) {
		int A='A';
		
		System.out.println(A);
		for(int i='A';i<='z';i++) {
			System.out.println((char)i);
			//if(i==n)return (char)i;
		}
		return ' ';
	}

}
