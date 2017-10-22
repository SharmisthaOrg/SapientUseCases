package com.golmanproblems;

public class SumEqualToGivenNumber {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 6;
        getPairsCount(arr, sum);
	}

	private static void getPairsCount(int[] arr, int sum) {
		int count=0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j] == sum)
					count++;
			}
		}
		System.out.println(count);
	}

}
