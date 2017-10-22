package com.golmanproblems;

public class Smallest2ndInUnsortedArray {

	public static void main(String[] args) {
		int arr[]={1,1};
		System.out.println(print2ndsmallest(arr));
	}
	private static String print2ndsmallest(int[] arr) {
		int firstmin=Integer.MAX_VALUE;
		int secondmin=Integer.MAX_VALUE;
		if(arr!=null && arr.length>0){

			for(int i=1;i<arr.length;i++){
				if(arr[i]<firstmin){
					secondmin=firstmin;
					firstmin=arr[i];
				}
				else if(arr[i]>firstmin && arr[i]<secondmin){
					secondmin=arr[i];
				}
			}
		}
		if(secondmin==Integer.MAX_VALUE)return "No second max value";
		return secondmin+"";

	}
}