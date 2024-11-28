package corejava.chapter3;

import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {


		// get numbers of rows and value to print from user
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter number: ");
			int number = scanner.nextInt();

			// consume next line
			scanner.nextLine();

			System.out.println("Enter X: ");
			int x = scanner.nextInt();


			// consume next line
			scanner.nextLine();


			System.out.println("Select which loop you want");
			System.out.println("Enter 1 to use for loop");
			System.out.println("Enter 2 to use while loop");
			System.out.println("Enter 3 to use do while loop");

			int loopOption = scanner.nextInt();

			switch(loopOption) {

			case 1:
				pyramidForLoop(number, x);;
				break;
			case 2:
				pyramidWhileLoop(number, x);
				break;
			case 3:
				pyramidDoWhileLoop(number, x);
				break;
			default:
				throw new Exception("Please select a valid loop option");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * pyramidForLoop print pyramid with for loop
	 * @param number numbner of rows
	 * @param x number to print 
	 */
	public static void pyramidForLoop(int number, int x) {

		System.out.println("printing pyramid using for loop");

		int printNumnber = 0;

		for (int i = 1; i<= number; i++) {

			for (int j = 1; j <= i; j++) {
				System.out.print(printNumnber + "\t");
				printNumnber += x;
			}

			System.out.println("");
		}

	}

	/**
	 * pyramidDoWhileLoop print pyramid with do-while loop
	 * @param number numbner of rows
	 * @param x number to print 
	 */
	public static void pyramidDoWhileLoop(int number, int x) {

		System.out.println("printing pyramid using do while loop");

		int printNumnber = 0;
		int i = 1;
		do {

			int j = 1;

			do {
				System.out.print(printNumnber + "\t");
				printNumnber += x;
				j++;

			} while (j <= i);

			System.out.println();
			i++;

		} while (i <= number);

	}

	/**
	 * pyramidWhileLoop print pyramid with while loop
	 * @param number numbner of rows
	 * @param x number to print 
	 */
	public static void pyramidWhileLoop(int number, int x) {

		System.out.println("printing pyramid using while loop");

		int printNumber = 0;

		int i = 1;
		while (i <= number) {

			int j = 1;

			while (j <= i) {
				System.out.print(printNumber + "\t");
				printNumber += x;
				j++;

			}

			System.out.println();
			i++;
		}

	}
}
