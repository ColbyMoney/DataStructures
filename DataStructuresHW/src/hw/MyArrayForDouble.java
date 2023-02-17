package hw;

public class MyArrayForDouble {
	double[] nums;
	int numElements;
	public MyArrayForDouble() { // Constructor. automatically called when creating an instance
		numElements = 0;
		nums = new double[5];
	}
	public MyArrayForDouble(int capacity) { // Constructor. automatically called when creating an instance
		numElements = 0;
		nums = new double[capacity];
	}
	public MyArrayForDouble(double[] nums1) {
		nums = new double[nums1.length];
		for(int i=0;i<nums1.length;i++)
			nums[i] = nums1[i];
		numElements = nums1.length;
	}
	void printArray(){		// cost, times
		System.out.printf("printArray(%d,%d): ",numElements,nums.length);
		for(int i=0; i<numElements;i++)		
			System.out.print(nums[i]+" ");	
		System.out.println();					
	}	
	int linearSearch(double val) { 
		for(int i=0;i<numElements;i++)		
			if(nums[i] == val)				
				return i;					
		return -1;											
	}
	int binarySearch(double val) {
		int start = 0;					
		int end = nums.length - 1;		
		int mid;						
		while(start <= end) { 			
			mid = (start + end)/2;		
			if(val == nums[mid]) 		
				return mid;				
			else if(val < nums[mid]) 	
				end = mid-1;			
			else // val > nums[mid] 	
				start = mid + 1;		
		}
		return -1;															
	}
	
	private void enlarge() {
		// double up the size of nums;
		double[] new_nums = new double[nums.length*2];
		for(int i=0;i<numElements;i++)
			new_nums[i] = nums[i];
		nums = new_nums;
	}
	void add(double val) {
		if(isFull())  	// if(numElements == nums.length)
			enlarge();
		nums[numElements] = val;
		numElements++;
	}
	public void addOrder(int idx, double[] valArray) {
		// add all elements of valArray from the specified position of nums.
		// need to keep order
		// eg) [10,20,30] --> addOrder(1,{1,2}) makes {10,1,2,20,30}
		ensureCapacity(numElements + valArray.length);
		// Here we can safely assume 'nums' has at least 'numElements + valArray.length' spaces
		for(int i=numElements-1; i>=idx  ; i--)
			nums[i+valArray.length] = nums[i];
		
		for(int i=0;i<valArray.length;i++)
			nums[i+idx] = valArray[i];
		numElements += valArray.length;
	}
	
	private void ensureCapacity(int count) {
		if(count <= nums.length)
			return;
		// need more space
		double[] new_nums = new double[count];
		for(int i=0;i<numElements;i++)
			new_nums[i] = nums[i];
		nums = new_nums;
	}
	int remove(double val){
		// search for an element that is equal to val. and remove it from 'nums'
		int idx = linearSearch(val);
		if(idx < 0)
			return 0;
		// fill the location with the last element
		nums[idx] = nums[numElements-1];
		numElements--;
		return 1;
	}
//	void removeAll(int val) { // worst-case: latter half elements are equal to val
//							  // remove(10) in nums = {1, 2, 3, 2, 4, ..., 10, 10, 10, 10}
//							  // O(N) * N = O(N*N)
//		// search for all the elements equal to val and remove them.
//		while(remove(val) > 0);
//	}
	void removeAll(double val) { // O(N)
		int j = 0;
		for(int i=0;i<numElements;i++)
			if(nums[i] != val)
				nums[j++] = nums[i];
		numElements = j;
	}
	double findMin() {
		// return the minimum value among elements in nums;
		double minV = nums[0];
		for(int i=1;i<numElements;i++)
			if( nums[i] < minV )
				minV = nums[i];
		return minV;
	}
	void sort() { // There is a bug in this code. Find it.
		// sort 'nums' in ascending order. eg) 10, 20 , 30
		for(int i=0;i<numElements-1;i++) {
			int minIdx = i;
			for(int j=i+1;j<numElements;j++)
				if( nums[j] < nums[minIdx])
					minIdx = j;
			// swap between nums[i] and nums[minIdx]
			double temp = nums[i];
			nums[i] = nums[minIdx];
			nums[minIdx] = temp;
		}
	}
	double[] toArray() {
		// return a copy of the array only with valid elements
		//return nums; // this is not a right to return a copy.
		double[] new_nums = new double[numElements];
		for(int i=0;i<numElements;i++)
			new_nums[i] = nums[i];
		return new_nums;
	}
	public MyArrayForDouble clone(){
		// return a copy of this instance/object
		MyArrayForDouble nums1 = new MyArrayForDouble(this.toArray());
		return nums1;
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
	public double[] getElements(int start, int end) {
		double[] new_nums = new double[end-start+1];
		for(int i= start; i <= end ; i++)
			new_nums[i-start] = nums[i];
		return new_nums;
	}
	boolean isEmpty() { return numElements == 0; }
	boolean isFull() { return numElements==nums.length; }
}