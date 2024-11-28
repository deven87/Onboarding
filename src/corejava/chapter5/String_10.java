package corejava.chapter5;

public class String_10 {

	public static void main(String[] args) {

		String str = "hhhhhheelloooo123";

		System.out.println(String_10.sumNumbers(str));

	}

	/**
	 * sumNumbers.
	 * @param str
	 * @return sum of digits in stringwhat if 
	 */
	public static int sumNumbers(String str) {

		int sum = 0;

		for (int i = 0; i<str.length(); i++) {

			char c = str.charAt(i);

			if (Character.isDigit(c)) {

				System.out.println(c);
				sum += Character.getNumericValue(c);
			}		
		}

		return sum;

	}

}
