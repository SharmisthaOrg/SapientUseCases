package com.golmanproblems;

public class LongestRepeatating {

	public static void main(String[] args) {
		String s="aabbbbdddddcc";
		System.out.println(find(s));

	}

	private static String find(String s) {
		char[] ca=s.toCharArray();
		int start=0;
		
		int pIndex=-1;
		int pdistance=-1;
		
		int index=-1;
		int d=-1;
		
		if(ca==null || ca.length<2) {
			return "invalid";
		}
		for(int i=0;i<ca.length-1;i++) {
			if(ca[start]==ca[i]) {
				pIndex=start;
				pdistance=i-start+1;
			}
			else {
				start=i;				
			}
			if(pdistance>d) {
				d=pdistance;
				index=pIndex;
			}
			
			
		}
		return index+","+d;
	}

}
