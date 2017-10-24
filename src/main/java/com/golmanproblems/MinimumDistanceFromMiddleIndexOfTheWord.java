package com.golmanproblems;

public class MinimumDistanceFromMiddleIndexOfTheWord {

	public static void main(String[] args) {
		String s="hello how are you1 you,how you came here how";
		String w="how";
		String w1="you";
		System.out.println(findMinDistanceBetween(s,w,w1));

	}

	private static char[] findMinDistanceBetween(String s, String w, String w1) {
		String[] words=s.split("\\W");
		int cursor=0;
		int distance=Integer.MAX_VALUE;
		int wIndex=-1;
		int w1Index=-1;
		int cursorrange=0;
		for(int i=0;i<words.length;i++) {
			if(words[i].equals(w)) {
				wIndex = i;
				cursor+= words[i].length()/2+1;
			}
			else if(words[i].equals(w1)) {
				w1Index = i;
				cursor+= words[i].length()/2+1;
			}
			if(wIndex!=-1 && w1Index!=-1) {
				int range = Math.abs(w1Index-wIndex);
				if(distance>range) {
					distance = range;
					cursorrange = 
				}
			}
			cursor+= words[i].length()+1;
		}

		return null;
	}

}
