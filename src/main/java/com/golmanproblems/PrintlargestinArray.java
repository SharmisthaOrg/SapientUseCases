package com.golmanproblems;

import java.util.Arrays;
import java.util.Comparator;

public class PrintlargestinArray {

	public static void main(String[] args) {
	    Integer[] i = {1, 34, 3, 98, 9, 76, 45, 4};
	    
	    System.out.println(printlargest(i));
	  }
	  private static String printlargest(Integer[] i) {
	      Arrays.sort(i,0,i.length,
	      new Comparator<Integer>(){
	        public int compare(Integer i,Integer j){
	          String s=""+i+j;
	          String s1=""+j+i;
	          return s1.compareTo(s);
	        }
	      }
	    );
	    String r="";
	    for(Integer s:i)
	      r+=s;
	      
	    return r;
	  }

}
