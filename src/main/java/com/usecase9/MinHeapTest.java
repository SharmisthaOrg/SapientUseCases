package com.usecase9;

import java.util.Arrays;

public class MinHeapTest {

	public static void main(String[] args) {
		int[] arr= {3,2,1,7,8,4,10,16,12};
		int k=5;
		MinHeap mh=new MinHeap(arr.length);
		mh.createHeap(arr);
		System.out.println(Arrays.toString(Arrays.copyOfRange(mh.minH, 1, mh.minH.length)));
		for(int i=0;i<k ;i++) {
		System.out.println(mh.extractmin());
		}
	}

}
class MinHeap{
	int[] minH;
	int position;
	public MinHeap(int size) {
		this.position =0;
		this.minH = new int[size+1];
	}

	/*
	 * Replace the root of the heap with the last element on the last level.
	 * Compare the new root with its children; if they are in the correct order, stop.
	 * If not, swap the element with one of its children and return to the previous step. 
	 * (Swap with its smaller child in a min-heap and its larger child in a max-heap.)
	 */
	public int extractmin() {
		int min =minH[1];
		minH[1]=minH[position-1];
		minH = Arrays.copyOfRange(minH, 0, minH.length-1);
		position--;
		sinkDownFrom(1);
		return min;
	}
	private void sinkDownFrom(int minPos) {
		int smallest = minPos;
		if(2*minPos < position && minH[smallest]>minH[2*minPos]) {
			smallest=2*minPos;
		}
		if(2*minPos+1 <position && minH[smallest]>minH[2*minPos+1]) {
			smallest=2*minPos+1;
		}
		if(smallest!=minPos) {
			swap(smallest, minPos);
			sinkDownFrom(smallest);
		}
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