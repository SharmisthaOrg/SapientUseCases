package com.golmanproblems;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Problem12BiggestNumberFromListofInteger {

	public static void main(String[] args) {
		int[] i={1, 34, 3, 98, 9, 76, 45, 4} ;
		printBiggestNUmber(i);

	}

	private static void printBiggestNUmber(int[] v) {
		
		List<String> l=new LinkedList();
		for(int ii:v) {
			l.add(String.valueOf(ii));
		}
		Collections.sort(l,new Comparator<String>(){
			public int compare(String o,String o1) {
				String s=o.concat(o1);
				String s1=o1.concat(o);
				return s1.compareTo(s);
			}
		});
		for(String s:l ) {
			System.out.print(s);
		}
	}

}
