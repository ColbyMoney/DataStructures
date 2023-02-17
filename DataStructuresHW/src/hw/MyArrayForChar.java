package hw;

public class MyArrayForChar {
	char[] chars;
	int numElements;
	public MyArrayForChar() { // Constructor. automatically called when creating an instance
		numElements = 0;
		chars = new char[5];
	}
	public MyArrayForChar(int capacity) { // Constructor. automatically called when creating an instance
		numElements = 0;
		chars = new char[capacity];
	}
	public MyArrayForChar(char[] chars1) {
		chars = new char[chars1.length];
		for(int i=0;i<chars1.length;i++)
			chars[i] = chars1[i];
		numElements = chars1.length;
	}
	void printArray(){		// cost, times
		System.out.printf("printArray(%c,%c): ",numElements,chars.length);
		for(int i=0; i<numElements;i++)		
			System.out.print(chars[i]+" ");	
		System.out.println();					
	}	
	int linearSearch(char char2) { 
		for(int i=0;i<numElements;i++)		
			if(chars[i] == char2)				
				return i;					
		return -1;											
	}
	int binarySearch(char char2) {
		int start = 0;					
		int end = chars.length - 1;		
		int mid;						
		while(start <= end) { 			
			mid = (start + end)/2;		
			if(char2 == chars[mid]) 		
				return mid;				
			else if(char2 < chars[mid]) 	
				end = mid-1;			
			else // char2 > nums[mid] 	
				start = mid + 1;		
		}
		return -1;															
	}
	
	private void enlarge() {
		// double up the size of nums;
		char[] new_chars = new char[chars.length*2];
		for(int i=0;i<numElements;i++)
			new_chars[i] = chars[i];
		chars = new_chars;
	}
	void add(char char2) {
		if(isFull())  	// if(numElements == nums.length)
			enlarge();
		chars[numElements] = char2;
		numElements++;
	}
	public void addOrder(int idx, char[] valArray) {
		// add all elements of valArray from the specified position of nums.
		// need to keep order
		// eg) [10,20,30] --> addOrder(1,{1,2}) makes {10,1,2,20,30}
		ensureCapacity(numElements + valArray.length);
		// Here we can safely assume 'nums' has at least 'numElements + valArray.length' spaces
		for(int i=numElements-1; i>=idx  ; i--)
			chars[i+valArray.length] = chars[i];
		
		for(int i=0;i<valArray.length;i++)
			chars[i+idx] = valArray[i];
		numElements += valArray.length;
	}
	
	private void ensureCapacity(int count) {
		if(count <= chars.length)
			return;
		// need more space
		char[] new_chars = new char[count];
		for(int i=0;i<numElements;i++)
			new_chars[i] = chars[i];
		chars = new_chars;
	}
	int remove(char char2){
		// search for an element that is equal to val. and remove it from 'nums'
		int idx = linearSearch(char2);
		if(idx < 0)
			return 0;
		// fill the location with the last element
		chars[idx] = chars[numElements-1];
		numElements--;
		return 1;
	}
//	void removeAll(int val) { // worst-case: latter half elements are equal to val
//							  // remove(10) in nums = {1, 2, 3, 2, 4, ..., 10, 10, 10, 10}
//							  // O(N) * N = O(N*N)
//		// search for all the elements equal to val and remove them.
//		while(remove(val) > 0);
//	}
	void removeAll(char char2) { // O(N)
		int j = 0;
		for(int i=0;i<numElements;i++)
			if(chars[i] != char2)
				chars[j++] = chars[i];
		numElements = j;
	}
	double findMin() {
		// return the minimum value among elements in nums;
		char minV = chars[0];
		for(int i=1;i<numElements;i++)
			if( chars[i] < minV )
				minV = chars[i];
		return minV;
	}
	void sort() { // There is a bug in this code. Find it.
		// sort 'nums' in ascending order. eg) 10, 20 , 30
		for(int i=0;i<numElements-1;i++) {
			int minIdx = i;
			for(int j=i+1;j<numElements;j++)
				if( chars[j] < chars[minIdx])
					minIdx = j;
			// swap between nums[i] and nums[minIdx]
			char temp = chars[i];
			chars[i] = chars[minIdx];
			chars[minIdx] = temp;
		}
	}
	char[] toArray() {
		// return a copy of the array only with valid elements
		//return nums; // this is not a right to return a copy.
		char[] new_chars = new char[numElements];
		for(int i=0;i<numElements;i++)
			new_chars[i] = chars[i];
		return new_chars;
	}
	public MyArrayForChar clone(){
		// return a copy of this instance/object
		MyArrayForChar chars2 = new MyArrayForChar(this.toArray());
		return chars2;
	}
	public void clear() {
		numElements = 0;
	}
//	In the above class ‘MyArray’, define a new method ‘getElements(int start, int end)’ 
//	that returns a new array. The new array should have elements 
//	of ‘nums’ from index ‘start’ to ‘end’ inclusively. 
//	For example, suppose nums = {10,20,30,40,50}. Then getElements(2,4) 
//	returns a new array {30,40,50}. Assume that index ‘start’ and ‘end’ are valid 
//	(you don’t need to check their validity).
	public char[] getElements(int start, int end) {
		char[] new_chars = new char[end-start+1];
		for(int i= start; i <= end ; i++)
			new_chars[i-start] = chars[i];
		return new_chars;
	}
	boolean isEmpty() { return numElements == 0; }
	boolean isFull() { return numElements==chars.length; }
}
