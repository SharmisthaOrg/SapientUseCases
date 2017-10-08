package com.usecase5.fibonacci;

import java.util.Scanner;

public class FibonacciIterativeWay {

	public static void main(String[] args) {
		System.out.println("Enter you range to print:");
		Scanner s=new Scanner(System.in);
		int i=s.nextInt();
		printFibonacci(i);

	}

	private static void printFibonacci(int r) {
		int pre=1;int currsum=0;
		for(int i=0;i<r ;i++) {
			currsum=currsum+pre;
			pre=currsum-pre;
			System.out.println(pre);
		}
	}
}
