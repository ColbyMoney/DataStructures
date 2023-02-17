package hw;

public class MyLinkedListDemo<E> {
	static void printArray(Object[] objs){		
		for(int i=0; i<objs.length;i++)		
			System.out.print(objs[i]+" ");	
		System.out.println();					
	}
	public static void main(String[] args) {
		
		MyLinkedList<Integer> mynums1 = new MyLinkedList<Integer>(new Integer[] {1, 2, 3, 4, 5});
		mynums1.printLinkedList();
		
//		// testing get()
//		System.out.println(mynums1.get(0));
//		System.out.println(mynums1.get(1));
//		System.out.println(mynums1.get(4));
//		
//		// testing set(idx,val)
//		mynums1.set(1,10); mynums1.printLinkedList();
//		mynums1.set(4,20); mynums1.printLinkedList();
//		mynums1.set(0,50); mynums1.printLinkedList();

//		// testing addAt(idx,val)
//		mynums1.addAt(5,300); mynums1.printLinkedList();
//		mynums1.addAt(5,100); mynums1.printLinkedList();
//		mynums1.addAt(0,200); mynums1.printLinkedList();

//		// testing toArray()
//		printArray(mynums1.toArray());
		
		// testing clone()
//		MyLinkedList<Integer> mynums2 = mynums1.clone();
//		mynums2.printLinkedList();
		
		
//		// testing removeAll()
//		MyLinkedList<Integer> mynums2 = new MyLinkedList<Integer>(new Integer[] {1, 1, 2, 2, 2, 3, 1, 2, 3, 2, 2});
//		mynums2.printLinkedList();
//		mynums2.removeAll(2); mynums2.printLinkedList();
//		mynums2.removeAll(1); mynums2.printLinkedList();
//		mynums2.removeAll(3); mynums2.printLinkedList();
	}
}
