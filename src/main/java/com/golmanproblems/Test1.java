package com.golmanproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test1 {

	private static Integer count=0;

	public static void main(String[] args) {
		int[] arr= {8,2,8,2};
		int sum=20;
		System.out.println(printPairs(arr,sum));
	}

	private static int printPairs(int[] arr, int sum) {
		HashMap<Integer,Integer> uniquenumbers=new HashMap<>();
		for(int i:arr) {
			if(uniquenumbers.containsKey(i)) 
				uniquenumbers.put(i,uniquenumbers.get(i)+1);	
			else
				uniquenumbers.put(i,1);

		}
		Set<Integer> s=uniquenumbers.keySet();
		Iterator<Integer> i=s.iterator();
		String set="";
		while(i.hasNext()) {
			int n=i.next();
			if(uniquenumbers.containsKey(sum-n)) {
				set+="("+n+"+"+(sum-n)+")";
				count+=uniquenumbers.get(n);
				if(sum-n == n) {
					count--;
				}
			}
						
		}
		System.out.println(set);
		return count/2;
	}

}
