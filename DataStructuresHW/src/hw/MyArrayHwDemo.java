package hw;

public class MyArrayHwDemo {
	public static void main(String[] args) {
		MyArrayHw test = new MyArrayHw(new int[] {10, -4, 10, 5, 10});
		test.printArray();

		//test.clear();

		//test.enlarge();
		//test.add(20);
		//test.add( new int[]{10, 1, 3} );
		//test.addOrder(64,  2);
		//test.add(new int[]{1, 2, 3});
		//test.addOrder(1, new int[]{1, 2, 3} );
		//test.removeAll(10);
		//test.repeatEach();
		test.getLastElements(2);
		//test.clear();
		//int[] test2 = test.toArray();
		//System.out.println(test2[1]);
		//MyArrayHw cloned = test.clone();
		//cloned.printArray();
		//test.ensureCapacity(10);
		test.printArray();

	}
}
