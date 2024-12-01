package collection.list;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ArrayList_Task1 {

	/**
	 * list of list of each line numbers
	 */
	private static final List<List<Integer>> intList = new ArrayList<>();


	/**
	 * takeInput.
	 * @param scanner
	 * @return true if input is taken successfully
	 */
	public static boolean takeInput(Scanner scanner) {
		System.out.println("enter no of lines");

		try {
			int noOfLines = scanner.nextInt();

			if (noOfLines < 1 || noOfLines > 20000) {
				System.out.println("enter no of lines between 1 and 20000");
				return false;
			}

			// consume new line
			scanner.nextLine();

			for (int i = 0; i < noOfLines; i++) {

				System.out.println("enter number of values this line will have and then enter each value separated by space");
				String[] stringList = scanner.nextLine().split(" ");

				int nofOfValuesInLine = Integer.parseInt(stringList[0]);

				if (nofOfValuesInLine < 0 || nofOfValuesInLine > 50000) {
					System.out.println("enter no of lines between 0 and 50000");
					return false;
				}

				List<Integer> intListPerLine = new ArrayList<>(nofOfValuesInLine);

				for (int j = 1; j <= nofOfValuesInLine; j++) {

					intListPerLine.add(Integer.parseInt(stringList[j]));

				}

				intList.add(intListPerLine);

			}

			System.out.println(intList);

			return true;
		}  catch (InputMismatchException | NumberFormatException e) {
			System.out.println("Incorrect value entered");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}


	/**
	 * answerQueries
	 * @param scanner
	 * @throws Exception
	 */
	public static void answerQueries(Scanner scanner) throws Exception {

		System.out.println("Enter no of queries");

		try {

			int noOfQueries = scanner.nextInt();

			if (noOfQueries < 1 || noOfQueries > 1000) {
				throw new Exception("please enter query count as 1 to 1000");
			}

			// consume new line
			scanner.nextLine();

			for (int i = 0; i < noOfQueries; i++) {
				System.out.println("enter the value position and then the line position you want to find the value at, add space in between");
				int valuePosition = scanner.nextInt();
				int linePosition = scanner.nextInt();

				if (linePosition > 0 && linePosition <= intList.size()) {
					if (valuePosition > 0 && valuePosition <= intList.get(linePosition - 1).size()) {
						System.out.println(	intList.get(linePosition - 1).get(valuePosition - 1));
					} else {
						System.out.println("Incorrect value position");
					}
				} else {
					System.out.println("Incorrect line position");
				}

			} 

		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("Please enter valid input");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			if (ArrayList_Task1.takeInput(scanner)) {
				ArrayList_Task1.answerQueries(scanner);
			}

		}  catch (Exception e) {
			e.printStackTrace();		
		}
	}
}
