package com.usecase4.mergeandquicksort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		Integer[] arr= {3,1,5,8,5,0,2,8,4};
		System.out.println("Belore Sort:"+Arrays.deepToString(arr));
		arr=mergesort(arr);
		System.out.println("After Sort:"+Arrays.deepToString(arr));


	}

	private static Integer[] mergesort(Integer[] arr) {
		if(arr.length<2)return arr;
		int mid=arr.length/2;
		Integer[] left=Arrays.copyOfRange(arr, 0, mid);
		Integer[] right=Arrays.copyOfRange(arr, mid, arr.length);
		mergesort(left);
		mergesort(right);
		merge(left,right,arr);
		return arr;
	}

	private static void merge(Integer[] left, Integer[] right, Integer[] arr) {
		int leftindex=0;
		int rightindex=0;
		int k=0;
		while(leftindex<left.length && rightindex<right.length) {
			//689 //249
			if(left[leftindex] >= right[rightindex]) {
				arr[k++]= right[rightindex++];
			}
			else {
				arr[k++] = left[leftindex++];
			}			
		}
		while(leftindex<left.length) {
			arr[k++]=left[leftindex++];
		}
		while(rightindex<right.length) {
			arr[k++]=right[rightindex++];
		}
	}

}
