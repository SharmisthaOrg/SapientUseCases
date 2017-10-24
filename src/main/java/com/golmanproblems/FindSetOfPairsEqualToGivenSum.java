package com.golmanproblems;

import java.util.ArrayList;
import java.util.List;

public class FindSetOfPairsEqualToGivenSum {

	public static void main(String[] args) {
		int[] i= {4,2,1,7,5,5};
		int sum=10;
		System.out.println(findMinPair(i,sum));

	}

	private static String findMinPair(int[] arr, int sum) {
		List<String> l=new ArrayList<>();
		int minlength=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			int psum=arr[i];
			String subarr=String.valueOf(arr[i]);
			if(psum == sum) {
				minlength=1;
				l.add(subarr);
				continue;
			}
			for(int j=i+1;j<arr.length;j++) {
				psum+=arr[j];
				subarr+="+"+arr[j];
				if(psum==sum) {
					if(minlength>j-i+1) {
						minlength = j-i+1;
					}
					l.add(subarr);
				}
				if(psum>sum) {
					
				}
				
			}
		}
		System.out.println(l);
		return String.valueOf(minlength);
	}

}
