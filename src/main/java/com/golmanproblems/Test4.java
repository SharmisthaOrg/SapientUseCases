package com.golmanproblems;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Test4 {

	public static void main(String[] args) {
		String s="SSSSSTTSPPQ";
		System.out.println(printoccurance(s));
		System.out.println(printoccurancee(s));
		System.out.println(printoccuranceee(s));

	}
	static String os="";
	private static String printoccuranceee(String s) {
		HashMap<Character,Integer> m=new LinkedHashMap<>();
		
		for(int i=0;i<s.length();i++) {
			if(m.containsKey(s.charAt(i))) {
				m.put(s.charAt(i), m.get(s.charAt(i))+1);
			}
			else {
				m.put(s.charAt(i), 1);
			}		
		}
		m.forEach((k,v)->os=os+v+k);
		return os;
	}

	/*private static String printoccurancee(String str) {
		char [] ch = str.toCharArray();
	    StringBuilder sb = new StringBuilder();
	    for(int i =0;i<ch.length;){
	      char  c = ch[i];
	      int count =0;
	      while(i<ch.length && ch[i]==c){
	       count++;
	       i++;
	      }
	      
	      sb.append(count+""+c);
	    }
	    return sb.toString();
	}
*/
	private static String printoccurancee(String str) {
		String s="SSSSSTTSPPQQ";
		int cIndex=0;
		int cLength=0;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(cIndex) == s.charAt(i)) {
				cLength++;
			}
			else {
				sb.append(cLength+""+s.charAt(cIndex));
				cIndex=i;
				cLength=1;
			}
			
		}
		sb.append(cLength+""+s.charAt(cIndex));
	    return sb.toString();
	}

	private static String printoccurance(String s) {
		//this will print wrong if occurance is not sequential
		int pos=0;
		String outputString="";
		while(pos<s.length()) {
			int count=s.lastIndexOf(s.charAt(pos))-s.indexOf(s.charAt(pos))+1;
			outputString = outputString+count+s.charAt(pos);
			pos+=count;
		}
		return outputString;
		
	}

}
