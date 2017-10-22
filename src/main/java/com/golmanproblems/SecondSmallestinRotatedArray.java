package com.golmanproblems;

public class SecondSmallestinRotatedArray {

	public static void main(String[] args) {
		int arr[] =  {5,6,1,2,3,4};
		System.out.println(secondSmallestinRotatedArray(arr,0,arr.length-1));

	}

	private static String secondSmallestinRotatedArray(int[] arr,int start,int end) {/*
		while(start<end) {
			int mid=start+(end-start)/2;//4
			if(mid-1 >=start && arr[mid]<arr[mid-1]) {
				return (mid+1)==arr.length?arr[0]+"":arr[mid+1]+"";
			}
			else if(mid!= end && arr[mid]>arr[mid+1]) {
				return (mid+2)==arr.length?arr[0]+"":arr[mid+2]+"";
			}
			else if(arr[mid] < arr[end]) {
				return secondSmallestinRotatedArray(arr, start, mid);
			}
			else {
				return secondSmallestinRotatedArray(arr, mid, end);
			}

		}
		return "No second smallest element available";
	 */
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1]>arr[i]) {
				if(i+1==arr.length)return arr[0]+"";
				return arr[i+1]+"";
			}
		}
		return arr[1]+"";
		//return "invalid";
	}

}
