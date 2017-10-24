package com.golmanproblems;

public class SecondSmallestinRotatedArray {

	public static void main(String[] args) {
		int arr[] =  {5,6,1,2,3,4};
		System.out.println(secondSmallestinRotatedArray(arr));
		System.out.println(find2ndMin(arr));

	}


	private static String find2ndMin(int[] arr) {
		if(arr==null || arr.length<2) {
			return "invalid";
		}
		int minIndex=findMin(arr,0,arr.length-1);
		return (minIndex+1 == arr.length)?arr[0]+"":arr[minIndex+1]+"";
	}


	private static int findMin(int[] arr, int start, int end) {
		if(start>end)return 0;
		if(start == end) return start;
		
		int mid= start+(end-start)/2;
		if(mid<end && arr[mid] > arr[mid+1]) 
			return mid+1;
		if(mid>start && arr[mid] < arr[mid-1]) 
			return mid;	
		if(arr[end] < arr[mid])
			return findMin(arr, mid+1, end);
		return findMin(arr, start, mid-1);
	}


	public static String secondSmallestinRotatedArray(int[] arr){

		if(arr==null || arr.length<2){
			return "invalid input";
		}
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]>arr[i+1]){
				if(i+2 >= arr.length)
					return arr[0]+"";

				return arr[i+2]+"";
			}    
		}
		return ""+arr[1]; 
	}
}