package hw;

public class MyArrayHw {
	int[] nums;
	int numElements;
	public MyArrayHw() {
		nums = new int[5];
		numElements = 0;
	}
	public MyArrayHw(int[] numbers) {
		nums = new int[numbers.length];
		for(int i=0;i<nums.length;i++)
			nums[i] = numbers[i];
		numElements = nums.length;
	}
	
	public void printArray() {
		System.out.printf("printArray(%d,%d):", numElements, nums.length);
		for(int i=0; i<numElements;i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}
	public void enlarge() {
		int[] new_nums = new int[nums.length * 2];
		for(int i=0;i<nums.length;i++)
			new_nums[i] = nums[i];
		nums = new_nums;		
	}
	public void add(int val) {	
		if( isFull() ) 
			enlarge();
		nums[numElements++] = val;
	}
	public void add(int val, int pos) {
		// insert given value 'val' at the given position 'pos'
		// Move the element originally at the position to the last position
		// eg) add(10, 1) for {1,2,3,4} will change it into {1,10,3,4,2} 
		enlarge();
		numElements++;
		nums[numElements-1] = nums[pos]; // move pos value to end
		nums[pos] = val;                   // insert new value
	}
	public void addOrder(int val, int pos) {
		// insert given value 'val' at the given position 'pos'
		// Need to keep the orders of existing elements
		// eg) addOrder(10, 1) for {1,2,3,4} will change it into {1,10,2,3,4} 
		numElements++;
		enlarge();
		for (int i = numElements-1; i >= pos; i--)
		{
			nums[i] = nums[i-1];
		}
		nums[pos] = val;
	}
	public void add(int[] valArray) {
		// add all elements of valArray to the end of the array.
		numElements += valArray.length;
		enlarge();
		for (int i = numElements - valArray.length; i < numElements; i++) //add new values starting at end of original
		{
			nums[i] = valArray[i + valArray.length - numElements];
		}
	}
	public void addOrder(int idx, int[] valArray) {
		// add all elements of valArray from the specified position.
		// need to keep order
		// eg) [10,20,30] --> addOrder(1,{1,2}) makes {10,1,2,20,30}
		ensureCapacity(numElements + valArray.length);
		for (int i = numElements-1; i>=idx; i--)
		{
			nums[i+valArray.length] = nums[i];
		}
		for (int i = 0; i<valArray.length;i++)
		{
			nums[i+idx] = valArray[i];
		}
		numElements += valArray.length;
	}
	
	public void remove(int val) {
		int index = linearSearch(val);
		if(index >= 0) {
			nums[index] = nums[numElements-1];	// move the last one to the removed location
			numElements--;
		}
	}
	public void removeOrder(int val) {
		int index = linearSearch(val);
		if(index >= 0) {
			for(int i=index;i<numElements-1;i++)	// shifting values to left
				nums[i] = nums[i+1];
			numElements--;
		}	
	}
	public void removeAll(int val) {
		// {10, 2, 10, -4, 10} -> removeAll(10) will make it as {2, -4}
		// algorithm need to be efficient. worst case time complexity O(N). 
		int[] keeps = new int[numElements]; //only add numbers to keep
		int added = 0; //track how many numbers are added
		for (int i = 0; i < numElements; i++)
		{
			if (nums[i] != val) //add numbers that don't get removed
			{
				keeps[added] = nums[i];
				added++;
			}
		}
		numElements = added;
		nums = keeps;
	}
	
	public void repeatEach() {
		// repeat each number once again.
		// For example, {10, 2, 3} becomes {10, 10, 2, 2, 3, 3}
		int[] temp = new int[numElements]; //
		enlarge();
		for (int i = 0; i < numElements; i++) //copy nums to temp
		{
			temp[i] = nums[i];
		}
		numElements *= 2; //double numElements to make room for the repeated values
		for (int i = 0; i < temp.length; i++)
		{
			nums[i*2] = temp[i];
			nums[(i*2)+1] = temp[i];
		}
	}
	
	public int linearSearch(int k) {
		for(int i=0; i<numElements;i++)
			if (nums[i] == k)
				return i;
		return -1;
	}
	boolean isFull() {
		return numElements == nums.length;
	}
	boolean isEmpty() {
		return numElements == 0;
	}
	public void clear() {
		// remove all the elements in the array.
		// Hint: It is very simple.
		numElements = 0;
	}
	public int[] toArray() {
		// return a copy of the array 'nums'.
		// The array size is supposed to be equal to numElements.
		int[] numsCopy = new int[numElements];
		for (int i = 0; i < numElements; i++)
		{
			numsCopy[i] = nums[i];
		}
		return numsCopy;
	}
	public MyArrayHw clone() {
		// return a copy of the this object which is of MyArray class.
		MyArrayHw nums1 = new MyArrayHw();
		nums1.numElements = this.numElements;
		for (int i = 0; i < this.numElements; i++)
		{
			nums1.nums[i] = this.nums[i];
		}
		return nums1;
	}
	public void ensureCapacity(int minCapacity) {
		// increase the capacity if it is less than minCapacity
		// Do nothing if it is already greater than that.
		if (minCapacity <= nums.length) {
			return;
		}
		//need more space
		int[] new_nums = new int[minCapacity];
		for (int i = 0; i < numElements; i++)
		{
			new_nums[i] = nums[i];
		}
		nums = new_nums;
	}
	int[] getLastElements(int n)
	{
		int[] newNums = new int[numElements - n];
		for (int i = n; i < numElements; i++)
		{
			newNums[i-n] = nums[i];
		}
		numElements = newNums.length;
		nums = newNums;
		return newNums;
	}
}
