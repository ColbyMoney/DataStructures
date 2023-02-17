package hw;

public class MyLinkedList<E> {
	SLLNode<E> head = null;
	public MyLinkedList() {} // O(1)
	public MyLinkedList(E[] elements) { // O(elements.length)
		for(int i=elements.length-1;i>=0;i--)
			add(elements[i]);
	}
	public void printLinkedList() { // T(N) = O(N)
		System.out.print("printLinkedList(): ");
		SLLNode<E> node = head;
		while(node != null) {
			System.out.print(node.info + " ");
			node = node.next; // move to the next node
		}	
		System.out.println();
	}
	public void add(E e) { // T(N) = O(1)
		SLLNode<E> newNode = new SLLNode<E>(e);
		newNode.next = head;
		head = newNode;
	}
	public SLLNode<E> search(E e){// best-case: O(1)	worst-case: O(N)
		SLLNode<E> node = head;
		while(node != null) {
			if(node.info.equals(e)) // check if node.info is equal to 'e'
				return node;
			node = node.next;
		}
		return null;	
	}
	public int remove(E e) { // best-case: O(1), worst-case: O(N)
		// if e is found, remove the node and return 1
		// if e is not found, return 0
		SLLNode<E> node = head;
		SLLNode<E> prev = null;
		while(node != null) {
			if(node.info.equals(e)) {
				if(prev == null) 
					head = node.next;
				else	
					prev.next = node.next;
				return 1;
			}
			prev = node;
			node = node.next;
		}
		return 0;
	}
	public int size() { // O(N)
		// return the number of elements in the linked list
		SLLNode<E> node = head;
		int count=0;
		while(node != null) {
			count++;
			node = node.next;
		}
		return count;			
	}
	public void repeatEach() { // O(N)
		// duplicate each element in the list
		// eg) this list has [10, 20, 30] and this method change it to [10, 10, 20, 20, 30, 30];
		SLLNode<E> node = head;
		SLLNode<E> newNode;
		
		while(node != null) {
			newNode = new SLLNode<E>(node.info);
			newNode.next = node.next;
			node.next = newNode;
			node = newNode.next; //node.next.next;
		}
	}
	public void clear() { // O(1)
		head = null;
	}
	public boolean isEmpty() { return head == null;}; // O(1)
	public boolean isFull() { return false; }	// O(1)
	
	public E get(int idx) { // O(idx)
		// return the value at the given index
		// eg) For a list {10,20,30,40}, get(2) will return 30
		// Assume that idx is valid, i.e. 0<= idx < size()
		int i = 0;
		SLLNode<E> node = head;
		while (i < idx)
		{
			node = node.next;
			i++;
		}
		return node.info;
	}
	public void set(int idx, E val) { // O(idx)
		// set the node's value at the given index with given value
		// eg) For a list {10,20,30,40}, set(2,100) will change it into {10,20,100,40}
		// Assume that idx is valid, i.e. 0<= idx < size()
		int i = 0;
		SLLNode<E> node = head;
		while (i < idx)
		{
			node = node.next;
			i++;
		}
		node.info = val;
	}
	public void addAt(int idx, E val) { // O(idx)
		// insert a node of given value at the given index while pushing some nodes to the right
		// eg) For a list {10,20,30,40}, addAt(2,100) will change it into {10,20,100,30,40}
		// Hint: You may want to stop at idx-1 position to make connections.
		// Assume that idx is valid, i.e. 0<= idx <= size()
		SLLNode<E> newNode = new SLLNode<E>(val);
//		newNode.next = head;
//		head = newNode;
		int i = 0;
		SLLNode<E> node = head;
		if (idx == 0)
		{
			newNode.next = head;
			head = newNode;
		}
		else
		{
			//go to a specific index of the SLL
			while (i < idx-1)
			{
				node = node.next;
				i++;
			}
			newNode.next = node.next;
			node.next = newNode;
		}

	}
	public E[] toArray() { // O(numElements)
		// return an array that contains all the elements(numbers) in the list
		SLLNode<E> node = head;
		E[] nums = (E[]) new Object[size()];
		for (int i = 0; i < nums.length; i++)
		{
			nums[i] = node.info;
			node = node.next;
		}
		return nums;
	}
	public MyLinkedList<E> clone() { // O(numElements)
		// return a copy of 'this' object. 
		// Any change made to the copy should be independent of this object.
		MyLinkedList<E> newList = new MyLinkedList<E>(this.toArray());
		
		return newList;
	}
	public void removeAll(E val) { // O(numElements)
		// remove all the nodes with given value
		// This is a bonus problem (+5 points). 
		// It is hard. Don't spend too much time on this. You don't lose points if you don't do this.
	}
}
