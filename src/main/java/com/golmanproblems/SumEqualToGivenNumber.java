package com.golmanproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SumEqualToGivenNumber {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 6;
        getPairsCount(arr, sum);
        getPairsCountWithN_TC(arr, sum);
        getPairsCountWithN_TC_WIthoutDuplictaes(arr, sum);
	}

	private static void getPairsCountWithN_TC_WIthoutDuplictaes(int[] arr, int sum) {
		HashSet h=new HashSet();
		for(int i=0;i<arr.length;i++) {
			h.add(arr[i]);
		}
		System.out.println(h);
		Iterator i=h.iterator();
		int count=0;
		while(i.hasNext()) {
			int m=(int) i.next();
			if(h.contains(sum-m)) {
				count++;				
			}
		}
		System.out.println(count/2);
	}

	private static void getPairsCountWithN_TC(int[] arr, int sum) {
		HashMap<Integer, Integer> h=new HashMap<>();
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(h.containsKey(arr[i])) {
				h.put(arr[i], h.get(arr[i])+1);
			}
			else {
				h.put(arr[i],1);				
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(h.get(sum-arr[i])>0) {
				count+=h.get(sum-arr[i]);
			}
			if(arr[i] == h.get(sum-arr[i])) {
				count--;
			}
		}
		System.out.println(count/2);
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
