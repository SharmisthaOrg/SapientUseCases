package com.golmanproblems;

import java.util.HashMap;

public class PairsEqualToSum {

	public static void main(String[] args) {
		int[] i= {1,2,2,4,6,4,4,4,9,5,-1};
		int sum=8;
		System.out.println(printPairs(i,8));

	}

	private static int printPairs(int[] ia,int sum) {
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i:ia) {
			if(!map.containsKey(i)) {
				map.put(i, 1);
			}
			else {
				map.put(i, map.get(i)+1);
			}
		}
		int count=0;

		StringBuilder s=new StringBuilder();
		for(int a:ia) {
			if(map.containsKey(sum-a)) {
				count++;
				s.append("("+a+"-"+(sum-a)+")");
			}
			removeKey(map,a);
			removeKey(map,sum-a);

		}
		System.out.println(s.toString());
		return count;
	}

	private static void removeKey(HashMap<Integer, Integer> map, int a) {
		if(map.containsKey(a)) {
			if(map.get(a)>1) {
				map.put(a, map.get(a)-1);
			}
			else {
				map.remove(a);
			}
		}

	}

}
