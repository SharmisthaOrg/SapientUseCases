package com.usecase9;

public class MinHeapTest {

	public static void main(String[] args) {
		Integer[] arr= {2,7,9,3,6,1,9};
		MinHeap mh=new MinHeap(arr.length);
		mh.createHeap(arr);

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
	public void createHeap(Integer[] arr) {
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
			bubbleUp(minH);
		}
		
	}
	private void bubbleUp(int[] minH2) {
		int latestPosInserted=position-1;
		
		while(latestPosInserted>0 ) {
			int rootPos = latestPosInserted/2;
			if(minH[rootPos] < minH[latestPosInserted]) {
				swap(rootPos,latestPosInserted);
				latestPosInserted = rootPos;
			}
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