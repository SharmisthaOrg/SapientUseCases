package com.golmanproblems;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int n=153;
		System.out.println(isArmstrong(n));
	}

	private static boolean isArmstrong(int n) {
		int digits=getDigit(n);
		int temp=0,sum = 0;int bn=n;
		while(n>0) {
			temp=n%10;
			n=n/10;
			sum=(int) (sum+Math.pow(temp, digits));
		}
		if(bn==sum)return true;
		return false;
	}

	private static int getDigit(int n) {
		int count=0;
		while(n>0) {
			n=n/10;
			count++;
		}
		return count;
	}

}
