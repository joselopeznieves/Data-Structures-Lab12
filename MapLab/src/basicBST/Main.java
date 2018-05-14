package basicBST;

public class Main {

	
	public static void main(String[] args){
		
	}
	
	public class BST{
		
		private Node root;
		private int size;
		
		public BST(){
			this.root = null;
			this.size = 0;
		}
		
		public int size(){
			return this.size;
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
		}
		
		private void insert(Node node, Integer e){
			if(e < node.getElement()){
				if(!node.hasLeft()){
					Node nta = new Node(e, node, null, null);
					node.setLeft(nta);
				}
				else
					insert(node.left, e);
			}
			else{
				if(!node.hasRight()){
					Node nta = new Node(e, node, null, null);
					node.setRight(nta);
				}
				else
					insert(node.right, e);
			}
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
				return left == null;
			}
			
			public Node getRight() {
				return right;
			}
			
			public boolean hasRight(){
				return right == null;
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
