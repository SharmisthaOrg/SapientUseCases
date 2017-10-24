package com.golmanproblems;

import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class SetOfAngrams {

	static String input = "cat dog tac sat tas god dog";
	  
	  static void setOfAnagrams(){
	    String[] words=input.split("\\W");
	    int pos=0;
	    while(pos<words.length-1){
	      int m=pos++;
	      for(int i=m+1;i<words.length;i++){
	        if(isAnagram(words[i].toCharArray(),words[m].toCharArray())){
	          swap(words,i,pos++);
	        }        
	      }
	    }
	    System.out.println(Arrays.deepToString(words));
	  }
	 
	  static boolean isAnagram(char[] c,char[] c1){

	   
	   Arrays.sort(c);
	   Arrays.sort(c1);
	   return new String(c).equals(new String(c1));
	 }
	static void swap(String[] words,int i,int j){  
	  String temp=words[i];
	  words[i] = words[j];
	  words[j] = temp;
	}
	  public static void main(String[] args) {
	    
	    setOfAnagrams();
	    
	  }

}
