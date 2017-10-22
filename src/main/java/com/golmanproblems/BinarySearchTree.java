package com.golmanproblems;

public class BinarySearchTree {

	public static void main(String[] args) {
		MyBinaryTree m=new MyBinaryTree();
		m.put(50);
		m.put(20);
		m.put(70);
		m.put(70);m.put(10);m.put(80);m.put(25);m.put(75);
		m.printTree();
		System.out.println(m.contains(70));

	}

}
class MyBinaryTree{
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
		}
	}

	Node root;

	public void put(int i) {
		root = putRecursively(i,root);
	}

	public boolean contains(int i) {
		return containsRecursively(i,root);
	}

	private boolean containsRecursively(int i, Node cr) {
		if(cr == null)return false;
		if(cr.data == i)return true;		
		if(i < cr.data) {
			return containsRecursively(i, cr.left);
		}
		else {
			return containsRecursively(i, cr.right);
		}
	}

	public void printTree() {		
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node cr) {
		if(cr==null)return;
		inOrderTraversal(cr.left);
		System.out.println(cr.data);
		inOrderTraversal(cr.right);
	}

	private Node putRecursively(int i,Node cr) {
		if(cr == null)return new Node(i);

		if(i<cr.data) {
			cr.left = putRecursively(i,cr.left);
		}
		else {
			cr.right = putRecursively(i,cr.right);
		}
		return cr;
	}

}