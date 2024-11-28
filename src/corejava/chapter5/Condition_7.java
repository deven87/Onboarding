package corejava.chapter5;

import java.util.Scanner;

public class Condition_7 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter first number");
			int number1 = scanner.nextInt();

			// consume next line
			scanner.nextLine();

			System.out.println("Enter second number");
			int number2 = scanner.nextInt();

			System.out.println(Condition_7.sumLimit(number1, number2));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * sumLimit
	 * @param a
	 * @param b
	 * @return a+b if sum has same digits as a or return a
	 */
	public static int sumLimit(int a, int b) {

		int sum = a + b;

		if (String.valueOf(sum).length() > String.valueOf(a).length()) {
			return a;
		} 

		return sum;

	}

}
