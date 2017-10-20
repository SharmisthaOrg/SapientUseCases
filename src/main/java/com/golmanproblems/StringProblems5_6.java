package com.golmanproblems;

import java.util.LinkedHashSet;

public class StringProblems5_6 {

	public static void main(String[] args) {
		String s="0oaddhahggiiop";
		System.out.println(removeduplicates(s));
		System.out.println(finduniquecharacter(s));
		System.out.println(largestuniquecharacter(s));
	}

	private static String finduniquecharacter(String s) {
		System.out.println("in finduniquecharacter ==>");
		//1
		String d="";
		for(int i=0;i<s.length();i++) {
			if(s.lastIndexOf(s.charAt(i))== i && s.indexOf(s.charAt(i))== i) {
				d+=s.charAt(i);
				break;
			}
		}

		return d;
	}
	private static String largestuniquecharacter(String s) {
		System.out.println("in largestuniquecharacter ==>");
		//1
		String d="";
		for(int i=0;i<s.length();i++) {
			if(s.lastIndexOf(s.charAt(i))== i && s.indexOf(s.charAt(i))== i) {
				d+=s.charAt(i);
			}
		}

		return d;
	}

	private static String removeduplicates(String s) {
		System.out.println("in removeduplicates ==>");
		String d="";
		for(int i=0;i<s.length();i++) {
			if(s.lastIndexOf(s.charAt(i))!= i || s.indexOf(s.charAt(i))== i) {
				d+=s.charAt(i);
			}

		}	
		//2
		LinkedHashSet l=new LinkedHashSet();
		for(char c:s.toCharArray()) {
			l.add(c);
		}
		l.forEach(System.out::print);
		System.out.println();
		return d;		
	}

}
