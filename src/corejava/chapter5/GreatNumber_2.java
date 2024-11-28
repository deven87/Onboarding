package corejava.chapter5;

import java.util.Scanner;

public class GreatNumber_2 {


	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter first number");
			int number1 = scanner.nextInt();

			// consume next line
			scanner.nextLine();

			System.out.println("Enter second number");
			int number2 = scanner.nextInt();

			if (GreatNumber_2.isGreatNumber(number1, number2)) {
				System.out.println("Great number");
			} else {
				System.out.println("Not a Great number");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static boolean isGreatNumber(int number1, int number2) {

		if (number1 == 6 || number2 == 6 || number1 + number2 == 6 || Math.abs(number1 - number2) == 6) {

			return true;

		}

		return false;

	}
}
