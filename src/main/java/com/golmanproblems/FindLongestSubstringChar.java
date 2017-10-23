package com.golmanproblems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindLongestSubstringChar {

	public static void main(String[] args) {

		String input = "ABCDXABDEFGCABDXR";

		findLongestSubstringChar(input);
		findLongestUniqueSubString(input);

	}

	private static void findLongestUniqueSubString(String input) {
		char[] arr=input.toCharArray();
		String substring="";
		int maxlength=0;
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i=0;i<arr.length;i++) {
			char ch=arr[i];
			if(!map.containsKey(ch)) {
				map.put(ch, i);
			}
			else {
				i=map.get(ch);
				map.clear();
			}
			if(map.size()>maxlength) {
				maxlength=map.size();
				substring=map.keySet().toString();
				
			}
		}
		System.out.println(substring.substring(1,substring.length()-1).replaceAll(",", "").replaceAll("\\s", ""));
		
	}

	private static void findLongestSubstringChar(String input) {

		char[] array = input.toCharArray();
		String substring = null;
		int length = 0;

		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < array.length; i++) {
			char ch = array[i];
			if (!map.containsKey(ch)) {
				map.put(ch, i);
			} else {
				i = map.get(ch);

				map.clear();
			}
			if (map.size() > length) {
				length = map.size();

				substring = map.keySet().toString();
			}
		}

		System.out.println("The longest substring with unique chars : " + substring);

		System.out.println("The longest Substring Length with unique chars : " + length);

	}

}
