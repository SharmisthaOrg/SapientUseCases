package com.golmanproblems;

public class CheckIfPowerOfN {

	public static void main(String[] args) {
		int i=16;
		int j=2;
		System.out.println(isPower(i,j));

	}
	public static boolean isPower(int a,int b) {
		int p=1;
		if(a==1)return (b==1);//1 is only power of1
		
		//check power
		while(p<a) {
			p=p*b;	
		}
		return (p == a);
	}
}
