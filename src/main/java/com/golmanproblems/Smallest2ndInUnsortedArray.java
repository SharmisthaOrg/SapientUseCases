package com.golmanproblems;

public class Smallest2ndInUnsortedArray {

	public static void main(String[] args) {
		int arr[]={1,2,7,9,0,4};
		System.out.println(print2ndsmallest(arr));
	}
	 public static String print2ndsmallest(int arr[]){
		    
		    int fs=Integer.MAX_VALUE;
		    int ss=Integer.MAX_VALUE;
		    
		    if(arr==null || arr.length<=1){
		      return "invalid input";
		    }
		    for(int i:arr){
		      if(i<=fs){
		        ss=fs;
		        fs=i;
		      }
		      else if(i>fs && i<ss){
		        ss=i;
		      }
		    }
		    if(fs==ss)
		      return "second smallest not available";
		    
		    return String.valueOf(ss);
		  }
}