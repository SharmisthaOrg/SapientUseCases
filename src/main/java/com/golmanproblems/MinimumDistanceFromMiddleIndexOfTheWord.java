package com.golmanproblems;

public class MinimumDistanceFromMiddleIndexOfTheWord {

	public static void main(String[] args) {
		String s="hello how are you1 you,how you came here how";
		String w="how";
		String w1="you";
		System.out.println(findMinDistanceBetween(s,w,w1));

	}

	private static String findMinDistanceBetween(String s, String w, String w1) {
		String[] words=s.split("\\W");
		int cursor=0;
		int distance=Integer.MAX_VALUE;
		int wIndex=-1;
		int w1Index=-1;
		int wc=-1;
		int w1c=-1;
		int minDistance = Integer.MAX_VALUE;
		
		int cursorrange=0;
		for(int i=0;i<words.length;i++) {
			if(words[i].equals(w)) {
				wIndex = i;
				wc=cursor+ words[i].length()/2+1;
			}
			else if(words[i].equals(w1)) {
				w1Index = i;
				w1c=cursor+ words[i].length()/2+1;
			}
			if(wIndex!=-1 && w1Index!=-1) {
				int range = Math.abs(w1Index-wIndex);
				if(distance>range) {
					distance = range;
					cursorrange = Math.abs(w1c-wc);
				}
			}
			cursor+= words[i].length()+1;
		}
		/*for(String word:words){
		    // for(int i=0;i<strArray.length;i++){
		      
		      if(word.equals(w)){
		        wc = cursor + word.length()/2;        
		      }
		      
		      if(word.equals(w1)){
		        w1c = cursor + word.length()/2;
		      }
		      
		      distance = w1c - wc;
		      System.out.println(distance);
		      if(distance<0) distance=distance*-1;      
		      
		      if(distance<minDistance){
		        minDistance = distance;
		      }
		      
		      cursor = cursor+word.length()+1;
		         
		    }*/
		return "cursorrange="+cursorrange+" distance="+distance;
	}

}
