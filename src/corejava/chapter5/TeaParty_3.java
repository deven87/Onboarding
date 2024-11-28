package corejava.chapter5;

import java.util.Scanner;

public class TeaParty_3 {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter tea count");
			int tea = scanner.nextInt();

			// consume next line
			scanner.nextLine();

			System.out.println("Enter candy count");
			int candy = scanner.nextInt();

			switch(TeaParty_3.teaParty(tea, candy)) {

			case 0:
				System.out.println("0 - bad party");
				break;
			case 1:
				System.out.println(" 1 - good party");
				break;

			case 2:
				System.out.println(" 2 - great party");
				break;

			default:
				System.out.println("NA");
				break;

			}

		} catch (Exception e) {
			System.out.println("Please provide correct input ");
		}

	}

	/**
	 * teaParty
	 * @param tea tea count
	 * @param candy candy count
	 * @return 0 if tea or candy < 5, 2 if team or candy is twice of other one, 1 if tea or candy is more than 5
	 */
	public static int teaParty(int tea, int candy) {

		if (tea < 5 || candy < 5) {
			return 0;
		}  else if (tea >= candy *2 || candy >= tea *2 ) {
			return 2;
		} else  {
			return 1;

		} 
	}

}
