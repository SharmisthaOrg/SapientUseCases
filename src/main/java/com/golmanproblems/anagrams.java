package com.golmanproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class anagrams {
	static String input = "cat dog tac sat tas god dog";
	public static void main(String[] args) {
		 setOfAnagrams();
	}
	private static void setOfAnagrams() {
		String[] s=input.split("\\W");
		LinkedHashMap<String,List<String>> map=new LinkedHashMap<>();
		for(String in:s) {
			char[] c=in.toCharArray();
			Arrays.sort(c);
			String key=String.valueOf(c);
			 List<String> lvalue=null;
			if(!map.containsKey(key)) {
				 lvalue=new ArrayList<>();
			}
			else {
				lvalue=map.get(key);
			}
			lvalue.add(in);
			 map.put(key,lvalue);
		}
		StringBuilder os=new StringBuilder();

		map.forEach((k,v)->{
			os.append(v.toString().substring(1, v.toString().length()-1)).append(", ");
		});
		System.out.println(os.toString());
	}

}
