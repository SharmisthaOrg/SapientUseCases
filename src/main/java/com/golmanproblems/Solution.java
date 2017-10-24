package com.golmanproblems;

public class Solution {
	  
	  static final int  NUM_OF_CHARS = 256;
	  
	  
	  static void firstUniqueCharacter(String str){
	  
	    int len = str.length();
	    System.out.println("This is the length of the string : " + len);
	    
	    char[] charCountArray = new char[NUM_OF_CHARS];
	    int charIndex = -1;
	    
	    //boundary conditions
	    for(int i=0;i<len;i++){    
	      charCountArray[str.charAt(i)]++;
	    }
	    
	    for(int i=0;i<len;i++){
	      if(charCountArray[str.charAt(i)]==1){
	        charIndex = i;
	        break;
	      }        
	    }
	    
	   System.out.println("This is the first unique character : " + str.charAt(charIndex)); 
	     
	  }
	  
	  public static void main(String[] args) {
	    String s = "abeecdb";
	    firstUniqueCharacter(s);
	  }
	}