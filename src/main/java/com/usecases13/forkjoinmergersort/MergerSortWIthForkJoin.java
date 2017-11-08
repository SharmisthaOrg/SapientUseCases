package com.usecases13.forkjoinmergersort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MergerSortWIthForkJoin {

	public static void main(String[] args) {
		Integer[] arr={3,1,5,8,5,0,2,8,4,7};
		MyMergeSortWithForkJoin m=new MyMergeSortWithForkJoin(arr);		
		System.out.println("before mergesort sort"+Arrays.deepToString(arr));
		ForkJoinPool f=new ForkJoinPool();
		f.invoke(m);
		System.out.println("afer mergesort sort"+Arrays.deepToString(arr));
	}

}
class MyMergeSortWithForkJoin  extends RecursiveTask<Integer[]>{
	
	private static final long serialVersionUID = 1L;
	Integer[] arr;
	public MyMergeSortWithForkJoin(Integer[] arr) {
		this.arr = arr;
		System.out.println(Arrays.deepToString(arr));
	}

	
	@Override
	protected Integer[] compute() {
		if(this.arr.length <2) {
			return this.arr;
		}
		int mid = arr.length/2;
		MyMergeSortWithForkJoin left = new MyMergeSortWithForkJoin(
				Arrays.copyOfRange(arr, 0, mid));		
		MyMergeSortWithForkJoin right = new MyMergeSortWithForkJoin(
				Arrays.copyOfRange(arr, mid, arr.length));
		//doing fork on a task you have to join task
		/*left.fork();
		right.fork();
		left.join();
		right.join();*/
		
		MyMergeSortWithForkJoin.invokeAll(left, right);
		
		merge(left.arr,right.arr,arr);
		return arr;
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