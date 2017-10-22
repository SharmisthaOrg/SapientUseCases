package com.golmanproblems;

import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class SetOfAngrams {

	public static void main(String[] args) {
		String[] an = "cat dog tac sat tas god dog".split("\\s");
		System.out.println(findanagrams(an));

	}
	private static List<String> findanagrams(String[] an) {
		int position=0;
		while(position<an.length-1) {
			int m=position++;
			for(int i=m+1;i<an.length;i++) {
				if(isAnagram(an[m], an[i])) {
					swap(an,position++,i);
				}
			}
			System.out.println(Arrays.asList(an));
			System.out.println(position);
		}
		return Arrays.asList(an);
	}
	private static void swap(String[] an, int position, int i) {
		if(position!=i) {
			String temp=an[position];
			an[position]=an[i];
			an[i]=temp;
		}
	}
	private static boolean isAnagram(String s,String s1) {
		char[] c=s.toCharArray();
		char[] c1=s1.toCharArray();
		Arrays.sort(c);Arrays.sort(c1);
		return new String(c).equals(new String(c1));
	}

}
