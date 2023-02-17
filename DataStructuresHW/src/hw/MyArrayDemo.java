package hw;

public class MyArrayDemo {
	static void printArray(int[] nums){		
		for(int i=0; i<nums.length;i++)		
			System.out.print(nums[i]+" ");	
		System.out.println();					
	}
	public static void main(String[] args) {
//		MyArrayForDouble mynums1 = new MyArrayForDouble();
//		mynums1.add(10.5); mynums1.add(1.9); mynums1.add(-0.2); mynums1.add(10.5); mynums1.printArray();
//		System.out.println(mynums1.linearSearch(1.9));
//		mynums1.remove(1.9); mynums1.printArray();
//		mynums1.removeAll(10.5); mynums1.printArray();
		
		// Add your code to test MyArrayForString and MyArrayForChar 
		// --> Required.
		
//		MyArrayForString mystrs1 = new MyArrayForString();
//		mystrs1.add("refrigerator"); mystrs1.add("bowling"); mystrs1.add("ball"); mystrs1.add("refrigerator"); mystrs1.printArray();
//		System.out.println(mystrs1.linearSearch("refrigerator"));
//		mystrs1.remove("bowling"); mystrs1.printArray();
//		mystrs1.removeAll("refrigerator"); mystrs1.printArray();
		
		MyArrayForChar mychars1 = new MyArrayForChar();
		mychars1.add('A'); mychars1.add('B'); mychars1.add('C'); mychars1.add('B'); mychars1.printArray();
		System.out.println(mychars1.linearSearch('C'));
		mychars1.remove('A'); mychars1.printArray();
		mychars1.removeAll('B'); mychars1.printArray();
		
	}
}