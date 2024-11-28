package corejava.chapter4;

public class MissingNumber {

	public static void main(String[] args) {

		int numberofItems = 100;

		// initialize with 1 less length as 1 number is missing
		
		int[] array = new int[99];

		// consider the missing number
		int missingNumber = 12;

		int index = 0;

		// fill the array from 1 to 100 except for missing number
		for (int i = 1; i<= numberofItems; i++) {
			if (i != missingNumber) {
				array[index++] = i;
			}
		}

		int actualSum = 0;
		int expectedSum = numberofItems * (numberofItems + 1) / 2;

		// get the actual sum of array for 1 to numberofItems
		for (int num : array) {
			actualSum += num;
		}

		// get the missing number;
		System.out.println("Missing number is " + (expectedSum - actualSum));

	}

}
