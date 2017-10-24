package com.golmanproblems;

public class NthofFibonacciSeries {

	public static void main(String[] args) {
		int n=6;
		int j=0;
		//recursion
		System.out.println(printfibonacci(n-1));
		/*for(int i=0;i<n;i++)
		{
			j = printfibonacci(i);
			System.out.println(j);
		}
		System.out.println(j);*/
		
		//iterative
		System.out.println(printfibonaccirecursion(n-1));
		
		
	}

	private static int printfibonaccirecursion(int n) {
		int a=1;
		int sum=1;
		for(int i=0;i<=n;i++) {
			a=sum-a;
			//System.out.println(a);
			sum=sum+a;			
		}
		
		return a;
	}

	private static int printfibonacci(int n) {
		if(n==0 ) return 0;
			
		
		if(n==1)return 1;
			
		return printfibonacci(n-1)+printfibonacci(n-2);
	}

}
