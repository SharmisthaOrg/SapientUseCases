package com.usecase9;

import java.util.Arrays;

public class MinHeapTest {

	public static void main(String[] args) {
		int[] arr= {3,2,1,7,8,4,10,16,12};
		MinHeap mh=new MinHeap(arr.length);
		mh.createHeap(arr);
		System.out.println(Arrays.toString(Arrays.copyOfRange(mh.minH, 1, mh.minH.length)));
	}

}
class MinHeap{
	int[] minH;
	int size;
	int position;
	public MinHeap(int size) {
		this.size = size;
		this.position =0;
		this.minH = new int[size+1];
	}
	public void createHeap(int[] arr) {
		if(arr.length>0) {
			for(int i=0;i<arr.length;i++) {
				insert(arr[i]);
			}
		}

	}
	private void insert(Integer data) {
		if(position==0) {
			minH[position+1] = data;
			position=2;
		}
		else {
			minH[position++]=data;
			bubbleUp();
		}

	}
	private void bubbleUp() {
		int latestPosInserted=position-1;
		int rootPos=latestPosInserted/2;
		while(rootPos>0 ) {

			if(minH[rootPos] <= minH[latestPosInserted])break;
			
			swap(rootPos,latestPosInserted);
			latestPosInserted = rootPos;
			rootPos = latestPosInserted/2;
		}

	}
	private void swap(int rootPos, int latestPosInserted) {
		if(rootPos != latestPosInserted) {
			int temp=minH[rootPos];
			minH[rootPos] = minH[latestPosInserted];
			minH[latestPosInserted] = temp;
		}

	}

}