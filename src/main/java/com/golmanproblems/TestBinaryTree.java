package com.golmanproblems;

public class TestBinaryTree {

	public static void main(String[] args) {
		MyBTree m=new MyBTree();
		m.put(10);m.put(20);m.put(5);
		System.out.println(m.search(5));
		m.printInOrder();

	}

}
class MyBTree{
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
		}
	}
	Node root;
	public void put(int i) {
		root = putR(i,root);		
	}
	public void printInOrder() {		
		printInOrderR(root);
	}
	private void printInOrderR(Node cr) {
		if(cr==null)return;
		printInOrderR(cr.left);
		System.out.print(cr.data+",");
		printInOrderR(cr.right);
	}
	public boolean search(int i) {
		return searchR(i,root);		
	}
	private boolean searchR(int i, Node cr) {
		if(cr==null)return false;
		if(cr.data == i) return true;
		if(i<cr.data) return searchR(i,cr.left);
		return searchR(i,cr.right);
	}
	private Node putR(int i, Node cr) {
		if(cr==null)return new Node(i);
		if(i<=cr.data)
			cr.left = putR(i,cr.left);
		else
			cr.right = putR(i,cr.right);

		return cr;
	}

}