package corejava.chapter4;

import java.util.Arrays;

public class ArrayElements {

	public static void main(String[] args) {

		int[]arr = {1,6,10,199, 10};

		System.out.println("Given array is " + Arrays.toString(arr));

		System.out.println("Largest number in given array is " + largestNumberInArray(arr));
		System.out.println("Smallest number in given array is " + smallestNumberInArray(arr));

	}

	/**
	 * largestNumberInArray get the largest number in passed array
	 * @param arr array
	 * @return largest number
	 */
	public static int largestNumberInArray(int[] arr) {

		int largestNumber = arr[0];

		for (int number : arr) {

			if (number > largestNumber) {
				largestNumber = number;
			}
		}

		return largestNumber;	
	}

	/**
	 * smallestNumberInArray get the smallest number in passed array
	 * @param arr array
	 * @return smallest number
	 */
	public static int smallestNumberInArray(int[] arr) {

		int smallestNumber = arr[0];

		for (int number : arr) {

			if (number < smallestNumber) {
				smallestNumber = number;
			}
		}

		return smallestNumber;	
	}

}
