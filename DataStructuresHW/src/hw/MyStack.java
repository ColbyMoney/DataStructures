package hw;

// Assume N is the number of elements in stack

public class MyStack<E> implements StackInterface<E>{
	E[] elements;
	int top;
	public MyStack() {	// T(N) = O(1)
		elements = (E[]) new Object[5];
		top = 0; // index for future new element.
	}
	public MyStack(int capacity) {	// T(capacity) = O(capacity)
		elements = (E[]) new Object[capacity];
		top = 0; // index for future new element.
	}
	private void enlarge() { // T(N) = O(N)
		E[] new_elements = (E[]) new Object[elements.length*2];
		for(int i=0; i<top; i++)
			new_elements[i] = elements[i];
		elements = new_elements;
	}
	public void push(E e){ // worst: isFull() T(N)=O(N), best-case, avg-cast: T(N)=O(1)
		if(isFull()) 
			enlarge();
		elements[top++] = e;
	}
	public E pop() { // O(1)
		if(isEmpty())
			return null;
		return elements[top-- - 1];
//		E temp = elements[top-1];
//		top--;
//		return temp;
	}
	public E peek() { // O(1)
		if(isEmpty())
			return null;
		return elements[top-1];
	}
	public boolean isFull() { return top == elements.length; } // T(N) = O(1)
	public boolean isEmpty() { return top == 0;} // T(N) = O(1)
}