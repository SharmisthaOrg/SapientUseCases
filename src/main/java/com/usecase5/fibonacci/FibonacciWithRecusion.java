package com.usecase5.fibonacci;

import java.util.Scanner;

public class FibonacciWithRecusion {

	public static void main(String[] args) {
		System.out.println("Enter you range to print:");
		Scanner s=new Scanner(System.in);
		try{
			if(!s.hasNextInt()) {
				System.err.println("Invalid Input");System.exit(0);
			}
			int r=s.nextInt();

			for(int i=1;i<=r;i++) {
				System.out.println(printFibonacci(i));
			}
		}
		finally {
			s.close();
		}
	}

	private static int printFibonacci(int i) {
		if(i==2) {
			return 1;
		}
		else if(i<=1) {
			return 0;
		}
		return printFibonacci(i-1) + printFibonacci(i-2);
	}

}
