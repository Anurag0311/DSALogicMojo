package com.anurag.BinaryTree;


import java.util.concurrent.atomic.AtomicInteger;

class Node
{
	int data;
	Node left = null, right = null;

	Node(int data) {
		this.data = data;
	}
}

public class DiameterOfBT
{
	//Function to find diameter of the binary tree. Note that the function returns the height of the subtree rooted at given node and diameter
	public static int findDiameter(Node root, AtomicInteger diameter)
	{
		//base case: tree is empty
		if (root == null) {
			return 0;
		}
		//get heights of left and right subtrees
		int left_height = findDiameter(root.left, diameter);
		int right_height = findDiameter(root.right, diameter);
    //calculate diameter "through" the current node
		int max_diameter = left_height + right_height + 1;
		//Update Maximum Diameter (Note that diameter "excluding" the current node in subtree rooted at current node is already updated as we're doing postorder traversal)
		diameter.set(Math.max(diameter.get(), max_diameter));
    //return height of subtree rooted at current node
		return Math.max(left_height, right_height) + 1;
	}

	public static int findDiameter(Node root)
	{
		AtomicInteger diameter = new AtomicInteger(0);
		findDiameter(root, diameter);

		return diameter.get();
	}

	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		System.out.print("The diameter of the tree is " + findDiameter(root));
	}
	
}



