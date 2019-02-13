package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Map;	

class Node{
	Node left;
	Node right;
	int data;
	
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

public class Main {
	
	public static void topView(Node root) {
		// Write your code here.
		
		/*
		// Prev Answer
		ArrayList<Integer> roofs = new ArrayList<Integer>();
		roofs.add(root.data);
		
		Node curLeft = null;
		Node curRight = null;
		if(root.left != null) {
			curLeft = root.left;
			roofs.add(0, curLeft.data);
			while(curLeft.left != null) {
				curLeft = curLeft.left;
				roofs.add(0, curLeft.data);
			}
		}
		if(root.right != null) {
			curRight = root.right;
			roofs.add(curRight.data);
			while(curRight.right != null) {
				curRight = curRight.right;
				roofs.add(curRight.data);
			}
		}
		
		for(int i=0; i<roofs.size(); i++) {
			System.out.print(roofs.get(i) + " ");
		}
		*/
		
		// BFS
		class newNode{
			Node node;
			int hd; // horizontal distance
			
			newNode(Node node, int hd){
				this.node = node;
				this.hd = hd;
			}
		}
		
		Queue<newNode> mQueue = new LinkedList<newNode>();
		Map<Integer, Node> mMap = new TreeMap<Integer, Node>();
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		mQueue.add(new newNode(root, 0));
		
		while(!mQueue.isEmpty()) {
			newNode tempNewNode = mQueue.poll();
			if(!mMap.containsKey(tempNewNode.hd)) {
				mMap.put(tempNewNode.hd, tempNewNode.node);
				al.add(tempNewNode.hd);
			}
			
			if(tempNewNode.node.left != null) {
				mQueue.add(new newNode(tempNewNode.node.left, tempNewNode.hd-1));
			}
			
			if(tempNewNode.node.right != null) {
				mQueue.add(new newNode(tempNewNode.node.right, tempNewNode.hd+1));
			}
		}
		
		// "Entry" does not work in HackerRanks
		/*
		for(Entry<Integer, Node> entry : mMap.entrySet()) {
			System.out.print(entry.getValue().data + " ");
		}
		*/
		
		Collections.sort(al);
		for(int i=0; i<mMap.size(); i++) {
			System.out.print(mMap.get(al.get(i)).data + " ");
		}
		
	}
	
	public static Node insert(Node root, int data) {
		if(root == null) {
			return new Node(data);
		} else {
			Node cur;
			if(data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			int t = Integer.parseInt(br.readLine());
			
			String[] arrayInt = br.readLine().replaceAll("\\s+$",  "").split(" ");
			
			Node root = null;
			
			for(int i=0; i<t; i++) {
				int data = Integer.parseInt(arrayInt[i]);
				root = insert(root, data);
			}
			
			topView(root);
			
		} finally {
			br.close();
		}
	}

}
