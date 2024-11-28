package corejava.chapter5;

import java.util.Scanner;

public class SpeedChallan_1 {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter your car speed");
			int speed = scanner.nextInt();

			// consume next line
			scanner.nextLine();
			System.out.println("Is this your birthday, Enter true or false");

			boolean isBirthday = scanner.nextBoolean();

			System.out.println(SpeedChallan_1.caughtSpeeding(speed, isBirthday));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * caughtSpeeding
	 * @param speed speed of your vehicle
	 * @param isBirthday true if its your birthday
	 * @return 0 - no challan, 1- small ticket, 2 - big ticket
	 */
	public static int caughtSpeeding(int speed, boolean isBirthday) {

		if (!isBirthday) {

			if (speed <= 60) {
				return 0;
			} else if (speed >= 61 && speed <=80) {
				return 1;
			} else {
				return 2;
			}

		} else {

			if (speed  <= 65) {
				return 0;
			} else if (speed >= 66 && speed <=85) {
				return 1;
			} else {
				return 2;
			}

		}

	}


}
