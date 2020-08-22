package DataStructures.BinarySearchTree;

public class BST {
	Node root; // root node
	
	// Constructor for BST
	public BST() {
		root = null;
	}
	
    /* insertNode() O(lgn) is a recursive function to insert a new node in the correct position of BST. */
	private Node insertNode(Node parent, int priority, String name) {
		// Base Case: if the tree is empty, return a new node
		if(parent == null) {
			parent = new Node(priority, name);
			return parent;
		}
		// Go down the tree recursively
		if(priority < parent.getPriority()) {
			parent.left = insertNode(parent.left, priority, name);
		}else {
			parent.right = insertNode(parent.right, priority, name);
		}
		return parent;
	}
	// inOrderTraversal method O(n) traverses the tree and prints out in the command line
	public void inOrderTraversal(Node root) {
		if(root != null) {
			inOrderTraversal(root.left);
			System.out.println(root);
			inOrderTraversal(root.right);
		}
	}
	// Utility method O(lgn) to insert a new node in the tree
	public void insert(Node newNode) {
		// find patient with the same priority
		if(search(root, newNode.getPriority())) {
    		System.out.println("\n Priority: " + newNode.getPriority() + " exists.\n");
			return;
		}
		root = insertNode(root, newNode.getPriority(), newNode.getPatientName());
        System.out.print("Patient was successfully added in the line. Name: " + newNode.getPatientName() + " Patient's priority: " + newNode.getPriority() + "\n\n");

	}
	/* Utility method to sort a tree in the Increasing using In Order traversal O(n) */
    public void sort()  {
        inOrderTraversal(root);
    }
    private void updateParent(Node parent, Node current, Node currentNodeChild) {
    	if(current == this.root) {
    		this.root = currentNodeChild;
    	}else {
    		if(parent.getPriority() > current.getPriority()) {
        		parent.left = currentNodeChild;
        	}else {
        		parent.right = currentNodeChild;
        	}	
    	}
    }
    /* findSuccessor method O(lgn) is a subroutine called by delete method that finds and returns a successor node. */
    public Node findSuccessor(Node deleteNode) {
    	Node successor = null, successorParent = null, current = deleteNode.right;
    	while(current != null) {
    		successorParent = successor;
    		successor = current;
    		current = current.left;
    	}
    	if(successor != deleteNode.right) {
    		successorParent.left = successor.right;
    		successor.right = deleteNode.right;
    		successor.left = deleteNode.left;
    	}
    	return successor;
    }
    /* Delete O(lgn) method implements delete functionality for 3 cases of BST node deletion. */
    public boolean delete(Node parent, Node current, int priority) {
    	if(current == null) {
    		return false;
    	}
    	if(current.getPriority() == priority) {
    		// Case 1: leaf Node
    		if(current.left == null && current.right == null) {
				updateParent(parent, current, current.left);		
    		}else {
    			if(current.left == null || current.right == null) {
    				Node child = current.left != null ? current.left : current.right;
        			updateParent(parent, current, child);
    			}else {
    				// left != null and right != null
    				Node successor = findSuccessor(current);
    				updateParent(parent, current, successor);
    			}
    		}
    		return true;	
    	}
    	if(current.getPriority() > priority) {
    		return delete(current, current.left, priority);
    	}
		return delete(current, current.right, priority);	
    }
    public boolean delete(Node current) {
    	return delete(root, root, current.getPriority());
    }
    private boolean search(Node current, int priority) {
    	if(current == null) {
    		return false;
    	}
    	if(current.getPriority() > priority) {
    		return search(current.left, priority);
    	}
    	if(current.getPriority() < priority) {
    		return search(current.right, priority);
    	}
    	return true;
    }
}
