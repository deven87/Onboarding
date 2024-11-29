package corejava.chapter6;

public class ClumpArray {

	public static void main(String[] args) {

		int[] arr = {1,2,2,2,1,9,2,1,1};
		ClumpArray.countClumps(arr);	
	}

	/**
	 * countClumps
	 * @param nums
	 * @return no of time adjacent characters are same, more than 2 occurrence are counted as 1 only
	 */
	public static int countClumps(int[] nums) {


		int clumpCount = 0;

		if (nums.length <= 1) {
			return 0;
		} 

		int currentElement = nums[0];

		boolean isClump = false;



		// add array elements in map, if element already exists, update the span
		for(int i = 1; i < nums.length; i++) {

			if (nums[i] == currentElement) {

				if (!isClump) {
					isClump = true;
					clumpCount++;
				}
			} else {
				isClump = false;
			}

			currentElement = nums[i];
		}	

		return clumpCount;

	}


}
