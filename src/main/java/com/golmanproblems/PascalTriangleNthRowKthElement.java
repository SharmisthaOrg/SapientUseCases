package com.golmanproblems;

public class PascalTriangleNthRowKthElement {

	public static void main(String[] args) {
		int n=5;
		int k=5;
		System.out.println(printelement(n,k));
	}

	private static Object printelement(int row, int pos) {
		if(row < pos) {
			return "N/A";
		}
		if(pos ==1 || pos == row)return 1;
		
		int num=fact(row);
		int den = fact(pos)*fact(row-pos);
		return num/den;
	}

	private static int fact(int row) {
		int result=1;
		 for (int i = 1; i <= row; i++) {
	           result = result * i;
	       }
		
		return result;
	}

}
