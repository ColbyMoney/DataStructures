package hw;

public class MyArrayForString {
	String[] strs;
	int numElements;
	public MyArrayForString() { // Constructor. automatically called when creating an instance
		numElements = 0;
		strs = new String[5];
	}
	public MyArrayForString(int capacity) { // Constructor. automatically called when creating an instance
		numElements = 0;
		strs = new String[capacity];
	}
	public MyArrayForString(String[] nums1) {
		strs = new String[nums1.length];
		for(int i=0;i<nums1.length;i++)
			strs[i] = nums1[i];
		numElements = nums1.length;
	}
	void printArray(){		// cost, times
		System.out.printf("printArray(%s,%s): ",numElements,strs.length);
		for(int i=0; i<numElements;i++)		
			System.out.print(strs[i]+" ");	
		System.out.println();					
	}	
	int linearSearch(String str) { 
		for(int i=0;i<numElements;i++)		
			if(strs[i].equals(str))				
				return i;					
		return -1;											
	}
//	int binarySearch(String str) {
//		int start = 0;					
//		int end = strs.length - 1;		
//		int mid;						
//		while(start <= end) { 			
//			mid = (start + end)/2;		
//			if(str.equals(strs[mid])) 		
//				return mid;				
//			else if(str < strs[mid]) 	
//				end = mid-1;			
//			else // str > nums[mid] 	
//				start = mid + 1;		
//		}
//		return -1;															
//	}
	
	private void enlarge() {
		// String up the size of nums;
		String[] new_strs = new String[strs.length*2];
		for(int i=0;i<numElements;i++)
			new_strs[i] = strs[i];
		strs = new_strs;
	}
	void add(String str) {
		if(isFull())  	// if(numElements == nums.length)
			enlarge();
		strs[numElements] = str;
		numElements++;
	}
	public void addOrder(int idx, String[] strArray) {
		// add all elements of strArray from the specified position of nums.
		// need to keep order
		// eg) [10,20,30] --> addOrder(1,{1,2}) makes {10,1,2,20,30}
		ensureCapacity(numElements + strArray.length);
		// Here we can safely assume 'nums' has at least 'numElements + strArray.length' spaces
		for(int i=numElements-1; i>=idx  ; i--)
			strs[i+strArray.length] = strs[i];
		
		for(int i=0;i<strArray.length;i++)
			strs[i+idx] = strArray[i];
		numElements += strArray.length;
	}
	
	private void ensureCapacity(int count) {
		if(count <= strs.length)
			return;
		// need more space
		String[] new_strs = new String[count];
		for(int i=0;i<numElements;i++)
			new_strs[i] = strs[i];
		strs = new_strs;
	}
	int remove(String str){
		// search for an element that is equal to str. and remove it from 'nums'
		int idx = linearSearch(str);
		if(idx < 0)
			return 0;
		// fill the location with the last element
		strs[idx] = strs[numElements-1];
		numElements--;
		return 1;
	}
//	void removeAll(int str) { // worst-case: latter half elements are equal to str
//							  // remove(10) in nums = {1, 2, 3, 2, 4, ..., 10, 10, 10, 10}
//							  // O(N) * N = O(N*N)
//		// search for all the elements equal to str and remove them.
//		while(remove(str) > 0);
//	}
	void removeAll(String str) { // O(N)
		int j = 0;
		for(int i=0;i<numElements;i++)
			if(strs[i] != str)
				strs[j++] = strs[i];
		numElements = j;
	}
//	String findMin() {
//		// return the minimum strue among elements in nums;
//		String minV = strs[0];
//		for(int i=1;i<numElements;i++)
//			if( strs[i] < minV )
//				minV = strs[i];
//		return minV;
//	}
//	void sort() { // There is a bug in this code. Find it.
//		// sort 'nums' in ascending order. eg) 10, 20 , 30
//		for(int i=0;i<numElements-1;i++) {
//			int minIdx = i;
//			for(int j=i+1;j<numElements;j++)
//				if( strs[j] < strs[minIdx])
//					minIdx = j;
//			// swap between nums[i] and nums[minIdx]
//			String temp = strs[i];
//			strs[i] = strs[minIdx];
//			strs[minIdx] = temp;
//		}
//	}
	String[] toArray() {
		// return a copy of the array only with strid elements
		//return nums; // this is not a right to return a copy.
		String[] new_strs = new String[numElements];
		for(int i=0;i<numElements;i++)
			new_strs[i] = strs[i];
		return new_strs;
	}
	public MyArrayForString clone(){
		// return a copy of this instance/object
		MyArrayForString string1 = new MyArrayForString(this.toArray());
		return string1;
	}
	public void clear() {
		numElements = 0;
	}
//	In the above class ‘MyArray’, define a new method ‘getElements(int start, int end)’ 
//	that returns a new array. The new array should have elements 
//	of ‘nums’ from index ‘start’ to ‘end’ inclusively. 
//	For example, suppose nums = {10,20,30,40,50}. Then getElements(2,4) 
//	returns a new array {30,40,50}. Assume that index ‘start’ and ‘end’ are strid 
//	(you don’t need to check their stridity).
	public String[] getElements(int start, int end) {
		String[] new_strs = new String[end-start+1];
		for(int i= start; i <= end ; i++)
			new_strs[i-start] = strs[i];
		return new_strs;
	}
	boolean isEmpty() { return numElements == 0; }
	boolean isFull() { return numElements==strs.length; }
}
