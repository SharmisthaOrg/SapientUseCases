package com.usecases13.forkjoinmergersort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MergerSortUsingForkJoin {

	public static void main(String[] args) {
		Integer[] i= {};
		System.out.println("Before sort="+Arrays.toString(i));
		parallelMergeSort(i);
		System.out.println("After sort="+Arrays.toString(i));

	}

	private static void parallelMergeSort(Integer[] i) {
		ForkJoinPool k=ForkJoinPool.commonPool();
		
	}

}
class ParalleMergerSort extends RecursiveAction{

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		
	}
	
}