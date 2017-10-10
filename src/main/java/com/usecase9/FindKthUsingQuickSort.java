package com.usecase9;

public class FindKthUsingQuickSort {

	public static void main(String[] args) {
		int[] arr= {3,2,1,7,8,4,10,16,12};
		int k=5;
		System.out.println(findKthSmallestNumber(arr,0,arr.length-1,k));
	}

	private static int findKthSmallestNumber(int[] arr, int start, int end, int k) {
		int partitionindex=partition(arr,start,end);
		if(partitionindex==k)return arr[k];
		
		if(partitionindex>k) {
			return findKthSmallestNumber(arr, start, partitionindex-1, k);
		}
		else {
			return findKthSmallestNumber(arr, partitionindex+1, end, k);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int partitionIndex=start;

		for(int i=start;i<end ;i++) {
			if(pivot>arr[i]) {
				swap(arr,partitionIndex++,i);
			}
		}
		swap(arr,partitionIndex,end);
		return partitionIndex;
	}

	private static void swap(int[] minH,int rootPos, int latestPosInserted) {
		if(rootPos != latestPosInserted) {
			int temp=minH[rootPos];
			minH[rootPos] = minH[latestPosInserted];
			minH[latestPosInserted] = temp;
		}

	}


}
