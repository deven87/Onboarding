package collection.map;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBook_Task3 {

	private static HashMap<String, Integer> map;


	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			if (PhoneBook_Task3.createPhonebook(scanner)) {

				PhoneBook_Task3.printPhoneNumber(scanner);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * createPhonebook
	 * @param scanner
	 * @return true if phonebook created successfully
	 * @throws Exception
	 */
	public static boolean createPhonebook(Scanner scanner) throws Exception {

		System.out.println("Enter no of entries you want to add in phonebook between 1 to 100000");

		try {
			int noOfEntries = scanner.nextInt();

			// consume next line
			scanner.nextLine();

			if (noOfEntries < 1 || noOfEntries > 100000) {
				throw new Exception("Incorrect value for no of entries");
			}

			map = new HashMap<String, Integer>(noOfEntries);

			for (int i = 0; i < noOfEntries; i++) {
				System.out.println("Enter your name, first name or full name");
				String name =	scanner.nextLine();

				System.out.println("Enter your mobile number, only 8 digits and should not start with 0");

				int phone = scanner .nextInt();

				// consume next line
				scanner.nextLine();

				if (phone < 10000000 || phone > 99999999) {
					throw new Exception("Incorrect phone number provided");
				}

				map.put(name.toLowerCase(), phone);

			}

			return true;
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("Incorrect value provided");
			return false;
		}  catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}


	/**
	 * getPhoneNumber
	 * @param scanner
	 * @throws Exception
	 */
	public static void printPhoneNumber(Scanner scanner) throws Exception {

		try {
			System.out.println("Enter no of queries you have between 1 to 100000");
			int noOfQueries = scanner.nextInt();

			// consume next line
			scanner.nextLine();

			if (noOfQueries < 1 || noOfQueries > 100000) {
				throw new Exception("Incorrect value for no of Queries");
			}


			for (int i = 0; i < noOfQueries; i++) {
				System.out.println("Enter your name, first name or full name");
				String name =	scanner.nextLine();

				try {
					int phoneNumber = map.get(name.toLowerCase());
					System.out.printf("Phone number for name %s is %d%n", name, phoneNumber);

				} catch (Exception e) {

					System.out.printf("No record found for name %s %n", name);
				}

			}
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("Incorrect value provided");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
