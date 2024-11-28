package corejava.chapter5;

import java.util.Scanner;

public class Condition_6 {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter first number between 10 to 99");
			int number1 = scanner.nextInt();

			// consume next line
			scanner.nextLine();

			System.out.println("Enter second number between 10 to 99");
			int number2 = scanner.nextInt();

			if (number1 < 10 || number1 > 99 || number2 < 10 || number2 > 99) {
				throw new Exception("Please enter number between 10 and 99 only");
			}

			if (Condition_6.shareDigit(number1, number2)) {
				System.out.println("Both numbers share digit");
			} else {
				System.out.println("Both numbers does not share digit");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static boolean shareDigit(int a, int b) {


		return (a / 10 == b / 10 || a / 10 == b % 10 || a % 10 == b / 10 || a % 10 == b % 10);

	}

}
;