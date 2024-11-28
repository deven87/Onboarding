package corejava.chapter5;

import java.util.Scanner;

public class LotteryCheck_4 {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter first number");
			int number1 = scanner.nextInt();

			// consume next line
			scanner.nextLine();

			System.out.println("Enter second number");
			int number2 = scanner.nextInt();

			// consume next line
			scanner.nextLine();

			System.out.println("Enter third number");
			int number3 = scanner.nextInt();

			System.out.println(LotteryCheck_4.blueTicket(number1, number2, number3));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	/**
	 * blueTicket. 
	 * @param a lottry number 1
	 * @param b lottry number 1
	 * @param c lottry number 1
	 * @return 10 if any 2 numbers sum is 10, 5 if number1 + number2 is 10 highter than any other 2 numbers sum or return 0
	 */
	public static int blueTicket(int a, int b, int c) {

		if (a + b == 10 || b + c == 10 || c + a == 10) {
			return 10;
		} else if ((a + b) == (b + c + 10) || (a + b) == (c + a + 10)) {
			return 5;
		} else {
			return 0;
		}

	}

}
