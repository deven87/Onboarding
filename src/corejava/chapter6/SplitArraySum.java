package corejava.chapter6;

public class SplitArraySum {

	public static void main(String[] args) {


		int[] arr = {1, 1, 1, 2, 1}; 

		System.out.println(SplitArraySum.arraySplitCheck(arr));

	}

	/**
	 * arraySplitCheck
	 * @param arr
	 * @return true if array can be split with sum on left and right side elements as same
	 */
	public static boolean arraySplitCheck(int[] arr) {
		int totalSum = 0;
		int leftSum = 0;

		for (int num : arr) {
			totalSum += num;
		}

		for (int i = 0; i < arr.length; i++) {

			leftSum = leftSum + arr[i];

			if (leftSum == totalSum - leftSum) {
				return true;
			}

		}
		
		return false;
	}

}
