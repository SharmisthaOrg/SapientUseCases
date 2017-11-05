package com.usecases13.forkjoinmergersort;

import java.util.Arrays;

public class MergeSortWithClass {

	public static void main(String[] args) {
		Integer[] arr={3,1,5,8,5,0,2,8,4,7};
		MyMergeSort m=new MyMergeSort(arr);		
		System.out.println("before mergesort sort"+Arrays.deepToString(arr));
		m.mergesort(arr);
		System.out.println("afer mergesort sort"+Arrays.deepToString(arr));
		
	

	}

}
class MyMergeSort{
	Integer[] arr;
	MyMergeSort(Integer[] arr){
		this.arr = arr;
	}
	public void mergesort(Integer[] arr) {		
		if(arr.length<2){
			return;
		}
		int mid = arr.length/2;
		Integer[] left= Arrays.copyOfRange(arr, 0, mid);
		Integer[] right= Arrays.copyOfRange(arr, mid, arr.length);
		System.out.println("left->"+Arrays.deepToString(left));
		System.out.println("right->"+Arrays.deepToString(right));
		mergesort(left);
		mergesort(right);
		merge(left,right,arr);
	}
	private void merge(Integer[] left, Integer[] right, Integer[] arr) {
		int lefti=0,righti=0,k=0;
		while(lefti<left.length && righti<right.length) {
			if(left[lefti] <= right[righti]) {
				arr[k++]=left[lefti++];
			}
			else {
				arr[k++]=right[righti++];
			}
		}
		while(lefti<left.length) {
			arr[k++] = left[lefti++];
		}
		while(righti<right.length) {
			arr[k++] = right[righti++];
		}
	}
	
}