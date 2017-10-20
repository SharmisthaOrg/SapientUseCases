package com.golmanproblems;

public class MinmumDistanceBetweenTwoWords {

	public static void main(String[] args) {
		String s="hello how are you1 you,how you came here how";
		String w="how";
		String w1="you";
		System.out.println(findMinDistanceBetween(s,w,w1));

	}

	private static int findMinDistanceBetween(String s, String w, String w1) {
		String[] ss=s.split("\\W");
		System.out.println(ss[0]+""+ss[3]+""+ss[4]);
		int wIndex=-1;
		int w1Index=-1;
		int difference=Integer.MAX_VALUE;
		for(int i=0;i<ss.length;i++) {
			if(ss[i].equals(w)) {
				wIndex = i;
			}
			if(ss[i].equals(w1)) {
				w1Index = i;
			}
			if(wIndex !=-1 && w1Index!=-1) {
				difference = difference> Math.abs((w1Index - wIndex))?w1Index - wIndex:difference;
			}
		}
		return (wIndex == -1 || w1Index==-1)?-1:difference;
	}

}
