package hw;

public class MyBST<E> {
	BSTNode<E> root;
	public MyBST() {
		root = null;
	}
	public void printBST() {
		System.out.print("printBST(): ");
		PreOrder(root);
//		InOrder(root);
//		PostOrder(root);
		System.out.println();
	}
	void PreOrder(BSTNode<E> node) {
		if(node == null) return;
		System.out.print(node.info + " ");
		PreOrder(node.left);
		PreOrder(node.right);
	}	
	void InOrder(BSTNode<E> node) {
		if(node == null) return;
		InOrder(node.left);
		System.out.print(node.info + " ");
		InOrder(node.right);
	}
	void PostOrder(BSTNode<E> node) {
		if(node == null) return;
		PostOrder(node.left);
		PostOrder(node.right);
		System.out.print(node.info + " ");
	}
	public E min() {
		// return the minimum value in the tree.
		if(root == null) return null;		
		BSTNode<E> node = root;
		while(node.left != null)
			node = node.left;
		return node.info;
	}
	public E maxHelper(BSTNode<E> node) {
		if(node == null)
			return null;	
		if(node.right == null)
			return node.info;
		else
			return maxHelper(node.right);
	}
	public void add(E e) {
		root = addHelper(root, e);
	}
	private BSTNode<E> addHelper(BSTNode<E> node, E e) {
		if(node == null) {
			BSTNode<E> newNode = new BSTNode<E>(e);
			return newNode;
		}
		if (((Comparable) e).compareTo(node.info) <= 0)  //( e <= node.info)
			node.left = addHelper(node.left, e);
		else 
			node.right = addHelper(node.right, e);
		return node;
	}
	public BSTNode<E> search(E e) {
		return searchHelper(root, e);
	}
	private BSTNode<E> searchHelper(BSTNode<E> node, E e){
		if(node==null)
			return null;
		if (e.equals(node.info))
			return node;
		else if(((Comparable) e).compareTo(node.info) < 0) //if(e < node.info)
			return searchHelper(node.left, e);
		else 
			return searchHelper(node.right, e);
	}
	public void remove(E e) {
		root = removeHelper(root, e);
	}
	private BSTNode<E> removeHelper(BSTNode<E> node, E e){
		if(node == null)
			return null;
		if(((Comparable) e).compareTo(node.info) < 0)
			node.left = removeHelper(node.left, e);
		else if (((Comparable) e).compareTo(node.info) > 0)
			node.right = removeHelper(node.right, e);
		else { // e = node.info
			// check if the node is a leaf node, node with one child or node with two children
			if( node.left== null & node.right==null) // leaf node
				return null;
			else if(node.left == null) // node with one child
				return node.right;
			else if(node.right == null) // node with one child
				return node.left;
			else {	// node with two children
				// copy predecessor value to your value (node.info)
				// remove the predecessor, which has max one child
				E predecessor = maxHelper(node.left);
				node.info = predecessor;
				node.left = removeHelper(node.left, predecessor);
			}
		}
		return node;
	}
	
	public int size() {
		// returns the number of nodes in the binary search tree. This is complete
		return sizeHelper(root);
	}
	int sizeHelper(BSTNode<E> node) {
		// Use recursion.
		// Need work here
		if (node == null)
			return 0;
		return 1 + sizeHelper(node.left) + sizeHelper(node.right); // change this as needed
	}
	
	public int sum() {
		// returns the sum of nodes' info in the binary search tree. This is complete
		return sumHelper(root);
	}
	int sumHelper(BSTNode<E> node) {
		// Use recursion.
		// Need work here
		if (node == null)
			return 0;
		return (int)node.info + sumHelper(node.left)+ sumHelper(node.right);
	}
	public int height(){
		// returns the height of the tree. This is complete
		return heightHelper(root);
	}

	int heightHelper(BSTNode<E> node) {
		// Use recursion.
		// Need work here
		if (node == null)
			return 0;
		else
		{
			int leftHeight = 0;
			int rightHeight = 0;
			
			if (node.left != null)
				leftHeight = heightHelper(node.left);
			if (node.right != null)
				rightHeight = heightHelper(node.right);
			
			int max;
			if (leftHeight >= rightHeight)
				max = leftHeight;
			else
				max = rightHeight;
			
			return max + 1; // change this as needed
		}
	}
}