package com.golmanproblems;

public class Test3 {

	public static void main(String[] args) {
		String s="aabbabbbdbdccaaaaa";
		System.out.println(longestfirstrepeatingIndex(s));
	}

	private static String longestfirstrepeatingIndex(String s) {
		if(s==null || s.length()==0) {
			return "invalid input";
		}
		char[] ca=s.toCharArray();
		int cIndex=0;
		int cLength=0;

		int index=-1;
		int maxlength=-1;
		if(s.length()>1) {
			for(int i=cIndex;i<s.length();i++) {
				if(ca[cIndex] == ca[i]) {
					cLength++;
				}
				else {
					cIndex=i;
					cLength=1;
				}
				if(cLength>maxlength) {
					maxlength = cLength;
					index = cIndex;
				}				
			}
		}
		else {
			return "["+index+","+1+"]";
		}
		return "["+index+","+maxlength+"]";
	}

}
