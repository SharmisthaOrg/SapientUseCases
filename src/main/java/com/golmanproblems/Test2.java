package com.golmanproblems;

public class Test2 {

	public static void main(String[] args) {
		int i=-153;
		String s="-abc";
		//System.out.println(isArmstrong(i));
		System.out.println(isArmstrong(s));
	}

	private static boolean isArmstrong(String num) {
		try {
			int n=Math.abs(Integer.valueOf(num));
			int digits=getDigits(n);
			int sum=0;
			while(n>0) {
				int temp=n%10;
				sum=sum+(int)Math.pow(temp, digits);
				n=n/10;			
			}
			return sum == Math.abs(Integer.valueOf(num));
		}
		catch(NumberFormatException n) {
			throw new NumberFormatException(num+" is not a valid input");
		}
	}

	private static int getDigits(int n) {
		int d=0;
		while(n>0) {
			n=n/10;
			d++;
		}
		return d;
	}

}
