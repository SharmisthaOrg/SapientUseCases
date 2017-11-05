package com.usecase9.kthelementsmallest;

public class KthSmallestOfBinarySearchTree {

	public static void main(String[] args) {
		BinarySearchTree b=new BinarySearchTree();
		b.add(50);b.add(60);b.add(70);b.add(10);b.add(20);b.add(30);b.add(65);b.add(5);
		b.inOrder();
		b.printKthSmallest(4);
	}
}
class BinarySearchTree{
	static Node root;
	static int value;
	static class Node{
		int data;
		Node left;Node right;
		public Node(int data) {
			this.data = data;			
		}
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
	}

	public void add(int i) {
		root = putRecursively(i,root);		
	}

	public void printKthSmallest(int i) {
		System.out.println();
		value = i-1;
		Node n = printKthSmallest(root,null);
		System.out.println(n);
	}

	private Node printKthSmallest(Node cr,Node kthSmallest) {

		if(cr==null || value <0)return kthSmallest;
		kthSmallest = printKthSmallest( cr.left,kthSmallest);
		
		if(value==0) {
			value --;
			return cr;
		}
		value--;
		kthSmallest = printKthSmallest( cr.right,kthSmallest);
		return kthSmallest;
	}

	public void inOrder() {
		printInOrder(root);
		
	}

	private void printInOrder(Node cr) {
		if(cr == null)return;
		printInOrder(cr.left);
		System.out.print (cr.data+" ");
		printInOrder(cr.right);		
	}

	private Node putRecursively(int i, Node cr) {
		if(cr == null) return new Node(i);
		if(i<= cr.data) 
			cr.left = putRecursively(i, cr.left);
		else
			cr.right = putRecursively(i, cr.right);
		return cr;
	}

}