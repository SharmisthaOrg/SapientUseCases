package com.golmanproblems;

public class AddFraction {

	public static void main(String[] args) {
		int num1=1, den1=4, num2=5, den2=16;
	    
	    System.out.println(String.format("%d/%d + %d/%d is equal to %s\n", num1, den1,num2, den2, addFraction(num1, den1, num2, den2)));

	}

	private static String addFraction(int num1, int den1, int num2, int den2) {
		int lcm=getLCM(den1,den2);
		int sum=num1*(lcm/den1)+num2*(lcm/den2);
		
		if(sum%lcm == 0) {
			sum=sum/lcm;
			return ""+sum;
		}
		if(gcd(sum,lcm)>1) {
			int numm=sum/(gcd(sum,lcm));
			int denn= lcm/(gcd(sum,lcm));
			return numm+"/"+denn;
		}
		return sum+"/"+lcm;
	}

	private static int getLCM(int den1, int den2) {
		return (den1*den2)/gcd(den1,den2);
	}

	private static int gcd(int a, int b) {
		if(a==0)return b;		
		return gcd(b%a,a);
	}

}
