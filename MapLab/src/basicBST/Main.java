package basicBST;

public class Main {

	
	public static void main(String[] args){
		
	}
	
	public class BST<Integer>{
		
		private Node<Integer> root;
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
				this.root = new Node<>(e, null, null, null);
			}
			else{
				insert(root, e);
			}
		}
		
		private void insert(Node<Integer> node, Integer e){
			if(true){
				
			}
		}
		
		
		
		
		private class Node<Integer>{
			
			private Integer element;
			private Node<Integer> parent, left, right;
			
			public Node(Integer element, Node<Integer> parent, Node<Integer> right, Node<Integer> left){
				this.element = element;
				this.parent = parent;
				this.right = right;
				this.left = left;
				
			}

			public Integer getElement() {
				return element;
			}

			public Node<Integer> getParent() {
				return parent;
			}

			public Node<Integer> getLeft() {
				return left;
			}
			
			public boolean hasLeft(){
				return left == null;
			}
			
			public Node<Integer> getRight() {
				return right;
			}
			
			public boolean hasRight(){
				return right == null;
			}
			
			
		}
	}
	
}
