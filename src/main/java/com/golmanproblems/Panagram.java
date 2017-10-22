package com.golmanproblems;

import java.util.HashSet;

public class Panagram {

	public static void main(String[] args) {
		String s="The quick    brown fox jumps over the lazy dog";
		System.out.println(isPanagram(s));

	}

	private static boolean isPanagram(String s) {
		s=s.toLowerCase();
		HashSet<Character> h = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!= ' ')
			h.add(s.charAt(i));
		}
		System.out.println(h);
		if(h.size() == 26)return true;
		return false;
	}

}
