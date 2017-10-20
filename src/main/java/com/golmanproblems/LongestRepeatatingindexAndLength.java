package com.golmanproblems;

public class LongestRepeatatingindexAndLength {

	public static void main(String[] args) {
		String s="abcd";
		System.out.println(printLongestRepeatating(s));

	}

	private static String printLongestRepeatating(String s) {
		int index=0;
		int difference=0;
		int currentindex=0;
		while(s!=null && currentindex<s.length()){
			if(s.lastIndexOf(s.charAt(currentindex)) != currentindex) {
				int range = s.lastIndexOf(s.charAt(currentindex)) - currentindex+1;
				if(range > difference) {
					index=currentindex;
					difference = range;
				}
			}
			currentindex = s.lastIndexOf(s.charAt(currentindex))+1;
		}		
		return "["+index+","+difference+"]";
	}

}
