package hw;

public class MyBSTDemo {

	public static void main(String[] args) {
		MyBST<Integer> tr1 = new MyBST<Integer>();

		// Add your code below to test your functions required.
		tr1.root = new BSTNode(6);
		tr1.add(3);
		tr1.add(7);
		tr1.add(9);
		tr1.add(4);
		tr1.add(1);
		tr1.add(2);
		tr1.add(5);
		
//		tr1.root = new BSTNode(5);
//		tr1.add(10);
//		tr1.add(7);
//		tr1.add(6);
//		tr1.add(15);
//		tr1.add(3);
//		tr1.add(4);
		
		tr1.printBST();
		
		System.out.println("Size: " + tr1.size());
		System.out.println("Sum: " + tr1.sum());
		System.out.println("Height: " + tr1.height());
	}
}