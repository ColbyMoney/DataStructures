package hw;
import java.util.LinkedList;

public class ListDemoHw {

	public static void printLinkedList(SLLNode<Integer> node) {
		// display all elements in the linked list
		while(node != null) {
			System.out.print(node.info + " ");
			node = node.next; // move to the next node
		}	
		System.out.println();
	}
	static SLLNode<Integer> generateLL1() {
		// Create/return a linked list that has {3, 4, 1, 2}
		// Note that this is not quite a useful function. Just for practice purpose
		SLLNode<Integer> node1 = new SLLNode<Integer>(3);
		SLLNode<Integer> node2 = new SLLNode<Integer>(4);
		SLLNode<Integer> node3 = new SLLNode<Integer>(1);
		SLLNode<Integer> node4 = new SLLNode<Integer>(2);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		return node1;
	}
	static SLLNode<Integer> generateLL2(int a, int b) {
		// Create/return a linked list that has {a, b, a, b}
		// eg) generateLL2(10,20) returns a list {10,20,10,20}
		SLLNode<Integer> node1 = new SLLNode<Integer>(a);
		SLLNode<Integer> node2 = new SLLNode<Integer>(b);
		SLLNode<Integer> node3 = new SLLNode<Integer>(a);
		SLLNode<Integer> node4 = new SLLNode<Integer>(b);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		return node1;
	}
	static SLLNode<Integer> generateLL_with_array(int[] nums) {
		// Creat/return a linked list using the given int array
		// Return null if the array is empty (size is zero).
		// eg) generateLL3(new int[]{2,3,4}) returns a list {2,3,4}
		if (nums.length <= 0)
			return null;
		SLLNode<Integer> node1 = null;
		for (int i = 0; i < nums.length; i++) 
		{
			SLLNode<Integer> newNode = new SLLNode<Integer>(nums[i]);
			if (node1 == null)
			{
				node1 = newNode;
			}
			else
			{
				SLLNode<Integer> temp = node1;
				while (temp.next != null)
				{
					temp = temp.next;
				}
				temp.next = newNode;
			}
		}
		return node1;
	}
	static void attach(SLLNode<Integer> ls1, SLLNode<Integer> ls2) {
		// Given two linked lists, attach the second list at the end of the first list
		// eg) Suppose ls1={1,2,3}, ls2={50,60} as lists, attach(ls1, ls2) makes ls1 = {1,2,3,50,60}
		// Assume ls1 is not empty.
		// Hint: You need to go to the last node of ls1 and make a connection from it to the ls2
		while (ls1.next != null)
		{
			ls1 = ls1.next;
		}
		ls1.next = ls2;
	}
	
	public static SLLNode<Integer> insert(SLLNode<Integer> node, int val)
	{
		SLLNode<Integer> newNode = new SLLNode<Integer>(val);
		if (node == null)
		{
			return newNode;
		}
		else
			node.next = insert(node.next, val);
		return node;
	}
	
	public static void main(String[] args) {
		printLinkedList(generateLL1()); // 3 4 1 2
		printLinkedList(generateLL2(20,30)); // 20 30 20 30
		printLinkedList(generateLL_with_array(new int[] {2})); // 2
		printLinkedList(generateLL_with_array(new int[] {})); // null
		printLinkedList(generateLL_with_array(new int[] {2,3,4,5})); // 2 3 4 5
		SLLNode<Integer> ls1 = generateLL1();
		attach(ls1,generateLL2(20,30));
		printLinkedList(ls1); // 3 4 1 2 20 30 20 30
		
		SLLNode<Integer> ls2 = new SLLNode<Integer>(5);
		printLinkedList(insert(ls2));
	}
}