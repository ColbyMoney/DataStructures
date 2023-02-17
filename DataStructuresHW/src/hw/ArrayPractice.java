package hw;


public class ArrayPractice {

	static void printArray(int[] nums) {	
		// This function is complete. Here to help your test
		System.out.print("printArray(): ");
		for(int i=0; i<nums.length;i++)			
			System.out.print(nums[i] + " ");	
		System.out.println();					
	}
	
	static void shiftRightArray(int[] nums) {
		// make change to nums. 
		// Shift the elements to the right by 1 position. left most elements goes to the right most pos.
		// nums = [10,2,3,-5]. shiftRightArray(nums) will change it to [-5, 10, 2,3]
		int temp = nums[nums.length - 1];
		for (int i = nums.length - 1; i > 0; i--)
		{
			nums[i] = nums[i-1];
		}
		nums[0] = temp;
	}
	
	static int[] generateEvenNumbers(int count) {
		// Return a new int array filled with n even numbers starting from 2. 
		// eg) generateEvenNumbers(3) returns [2,4,6]
		// eg) generateEvenNumbers(5) returns [2,4,6,8,10]
		int[] nums = new int[count];
		for (int i = 0; i < count; i++)
		{
			nums[i] = (i+1)*2;
		}
		return nums;
	}
	
	static int[] insertKeepOrder(int[] nums, int idx, int val) {
		// Return a new int array.
		// insert the given 'val' at index 'idx' pushing numbers to the right.
		//		insertKeepOrder([10,20,30],0,5) will return [5, 10, 20, 30]
		//		insertKeepOrder([10,20,30],1,5) will return [10, 5, 20, 30]
		int[] nums2 = new int[nums.length + 1];
		for (int i = 0; i < idx; i++)
		{
			nums2[i] = nums[i];
		}
		nums2[idx] = val;
		for (int i = idx; i < nums.length; i++)
		{
			nums2[i+1] = nums[i];
		}
		return nums2;
	}
	
	static int[] reverseNew(int[] nums) {
		// Return a new int array that is reversed version of nums
		// eg) reverseNew([1,2,3]) returns [3,2,1]
		// eg) reverseNew([5,1,2,3]) returns [3,2,1,5]
		int[] nums2 = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			nums2[i] = nums[nums.length - i - 1];
		}
		return nums2;
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {10,2,3,-5,20,10,4};
		
//		shiftRightArray(nums1);
//		printArray(nums1);
		
		// add you test codes below. You have freedom how to test. 
//		shiftRightArray(nums1);
//		printArray(nums1);
		
		printArray(generateEvenNumbers(5));
		
		printArray(insertKeepOrder(nums1, 5, 64));
		
		printArray(reverseNew(nums1));
	}

}