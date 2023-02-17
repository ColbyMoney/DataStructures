package exam;

public class ListDemo {
	public static SLLNode<Integer> list(int[] nums){
		SLLNode<Integer> ls = null;
		for(int i=nums.length-1; i>=0;i--) {
			SLLNode<Integer> newNode = new SLLNode<Integer>(nums[i]);
			// insert at the beginning
			newNode.next = ls;
			ls = newNode;
		}
		return ls;
	}
	public static void printLinkedList(SLLNode<Integer> node){	
		System.out.print("printLinkedList(): ");
		while(node != null) {
			System.out.print(node.info+" ");
			node = node.next;
		}
		System.out.println();
	}
	public static SLLNode<Integer> insert(SLLNode<Integer> node, int val){
		// Use RECURSION !!!
		// Assume that 'node' is a sorted list (possible to be empty).
		// Insert 'val' in the right place to keep things sorted and return the list
		
		// hint: Create newNode with 'val'.
		//		 if the list is empty (node is null), then return newNode.
		//       if val > node.info, then use recursion to insert 'val' later
		//       else it is time to insert newNode before node.	
		
		SLLNode<Integer> newNode = new SLLNode<Integer>(val);
		if (node == null)
		{
			return newNode;
		}
		else if (val >= node.info)
			node.next = insert(node.next, val);
		else
		{
			newNode.next = node;
			return newNode;
		}
		return node;
	}
	public static void main(String[] args) {
		SLLNode<Integer> ls1 = null;
		ls1 = insert(ls1,10); printLinkedList(ls1); // 10
		ls1 = insert(ls1,2); printLinkedList(ls1); // 2 10
		ls1 = insert(ls1,20); printLinkedList(ls1); // 2 10 20
		ls1 = insert(ls1,15); printLinkedList(ls1); // 2 10 15 20
	}
}
