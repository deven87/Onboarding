package collection.list.checker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Checker_Task2 implements comparator
 */
public class Checker_Task2 implements Comparator<Person> {

	static List<Person> personList;

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			if (Checker_Task2.createPlayers(scanner)) {

				// get sorted player based on passed comparator
				Collections.sort(personList, new Checker_Task2());
				System.out.println("Sorted List is " + personList);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * compare with score in decreasing order, if same compare with name
	 */
	@Override
	public int compare(Person o1, Person o2) {
		if (o1.score == o2.score) {

			return o1.name.compareTo(o2.name);
		} else {

			return Integer.compare(o2.score, o1.score);

		}

	}

	/**
	 * createPlayers
	 * @param scanner
	 * @return return true if player created
	 * @throws Exception
	 */
	public static boolean createPlayers(Scanner scanner) throws Exception {
		System.out.println("enter no of players to create");
		try {
			int noOfPlayers = scanner.nextInt();

			if (noOfPlayers < 1 || noOfPlayers > 100) {

				throw new Exception("please enter valid no of players between 1 to 100");

			}

			personList = new ArrayList<>(noOfPlayers);

			//consume next line
			scanner.nextLine();


			for (int i = 0; i < noOfPlayers; i++) {
				System.out.println("Enter player name and score for player with space" + (i + 1));
				String playerName = scanner.next();
				int playerScore = scanner.nextInt();

				if (playerScore < 0 || playerScore > 1000) {
					throw new Exception("please enter valid score between 0 to 1000");
				}

				personList.add(new Person(playerName, playerScore));
			}
			return true;
		} catch (InputMismatchException | NumberFormatException e) {	
			System.out.println("Please enter correct input");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
