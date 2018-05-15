package bstWithRemove;

import java.util.Scanner;


public class Main {

public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		int queries = input.nextInt();
		
		BSTWRemove tree = new BSTWRemove();
		
		for(int i = 0; i < queries; i++){
			int quesType = input.nextInt();
			if(quesType == 1){
				tree.addElement(input.nextInt());
			}
			else if(quesType == 2){
				int value = input.nextInt();
				if(tree.findNode(tree.getRoot(), value) == null){
					System.out.println("no");
				}
				else{
					System.out.println("yes");
				}
			}
			else {
				int value = input.nextInt();
				if(tree.removeElement(value) == null)
					System.out.println("not found");
				else
					System.out.println("erased");
			}
			
		}
		
		input.close();
		
	}
	
	public static class BSTWRemove{
		
		private Node root;
		private int size;
		
		public BSTWRemove(){
			this.root = null;
			this.size = 0;
		}
		
		public int size(){
			return this.size;
		}
		
		public Node getRoot(){
			return this.root;
		}
		
		public boolean isEmpty(){
			return this.size == 0;
		}
		public void addElement(Integer e){
			if(this.isEmpty()) {
				this.root = new Node(e, null, null, null);
			}
			else{
				insert(root, e);
			}
			size++;
		}
		
		private void insert(Node node, Integer e){
			if(e < node.getElement()){
				if(!node.hasLeft()){
					Node nta = new Node(e, node, null, null);
					node.setLeft(nta);
				}
				else
					insert(node.getLeft(), e);
			}
			else{
				if(!node.hasRight()){
					Node nta = new Node(e, node, null, null);
					node.setRight(nta);
				}
				else
					insert(node.getRight(), e);
			}
		}
		
		public Node findNode(Node r, Integer e){
			if(r == null) return null;
			if(r.getElement() == e) return r;
			if(e < r.getElement()) return findNode(r.getLeft(), e);
			return findNode(r.getRight(), e);
		}
		
		public Integer removeElement(Integer e) {
			Node ntr = findNode(root, e);
			if(ntr == null) return null;
			
			Integer etr = ntr.getElement();
			deleteNode(ntr);
			return etr;
			
		}
		
		public void deleteNode(Node node) {
			
			if(!node.hasLeft() || !node.hasRight()) {
				//node has max 1 child 
				removeSingleChild(node);
			}
			else {
				//find smallest
				Node smallest = node.getRight();
				while(smallest.hasLeft())
					smallest = smallest.getLeft();
				
				node.setElement(smallest.getElement());
				
				removeSingleChild(smallest);
			}
		}
		
		private void removeSingleChild(Node node) {
			
			Node child;
			if(node.hasLeft())
				child = node.getLeft();
			else
				child = node.getRight();
			
			if(child != null)
				child.setParent(node.getParent());
			if(node == root) 
				root = child;
			else {
				Node parent = node.getParent();
				if(node == parent.getLeft()) 
					parent.setLeft(child);
				else
					parent.setRight(child);
			}
			
			size--;
			node.setElement(null);
			node.setLeft(null);
			node.setParent(null);
			node.setRight(null);
		}
		
		private class Node{
			
			private Integer element;
			private Node parent, left, right;
			
			public Node(Integer element, Node parent, Node right, Node left){
				this.element = element;
				this.parent = parent;
				this.right = right;
				this.left = left;
				
			}

			public Integer getElement() {
				return element;
			}

			public Node getParent() {
				return parent;
			}

			public Node getLeft() {
				return left;
			}
			
			public boolean hasLeft(){
				return left != null;
			}
			
			public Node getRight() {
				return right;
			}
			
			public boolean hasRight(){
				return right != null;
			}

			public void setElement(Integer element) {
				this.element = element;
			}

			public void setParent(Node parent) {
				this.parent = parent;
			}

			public void setLeft(Node left) {
				this.left = left;
			}

			public void setRight(Node right) {
				this.right = right;
			}
			
			
		}
		
	}

}
