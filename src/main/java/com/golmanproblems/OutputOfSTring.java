package com.golmanproblems;

public class OutputOfSTring {

	public static void main(String[] args) {
		String s="SSSSSTTPPQ";
		System.out.println(printCountofCharacter(s));

	}

	private static String printCountofCharacter(String s) {
		int i=0;
		String d="";
		while(i<s.length()) {
			int c=count(s.charAt(i),s);
			d=d+c+s.charAt(i);
			i=i+c;
			System.out.println(i);
		}
		return d;
	}

	private static int count(char c,String s) {
		int r=s.lastIndexOf(c)-s.indexOf(c)+1;
		return r;
	}

}
