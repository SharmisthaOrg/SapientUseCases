package com.usecase4.mergeandquicksort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		Integer[] arr= {0,9,10,3,1,5,8,5,0,2,8,4};
		System.out.println("Belore Sort:"+Arrays.deepToString(arr));
		arr=quicksort(arr,0,arr.length-1);
		System.out.println("After Sort:"+Arrays.deepToString(arr));

	}

	private static Integer[] quicksort(Integer[] arr, int start, int end) {
		if(start>=end)return arr;
		int partitionIndex=partition(arr,start,end);
		quicksort(arr, start, partitionIndex-1);
		quicksort(arr, partitionIndex+1, end);
		return arr;
	}

	private static int partition(Integer[] arr, int start, int end) {
		int partitionIndex=start;
		int partitionValue = arr[end];
		for(int i=start;i<end;i++) {
			if(partitionValue > arr[i]) {
				swap(arr,i,partitionIndex);
				partitionIndex++;
			}
		}
		swap(arr,end,partitionIndex);
		return partitionIndex;
	}

	private static void swap(Integer[] arr, int i, int partitionIndex) {
		if(i != partitionIndex) {
			int temp=arr[i];
			arr[i]=arr[partitionIndex];
			arr[partitionIndex]=temp;	
		}
	}

}
