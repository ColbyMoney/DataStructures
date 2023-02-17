package hw;

public class BSTNode<E> {
	E info;
	BSTNode<E> left, right;
	public BSTNode(E e) {
		info = e;
		left = null;
		right = null;
	}
	public String toString() { return "BSTNode(" + info + ")"; }
}