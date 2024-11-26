package oops_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BouquetShop {

	public static final int MAXONETYPEFLOWERCOUNT = 50;
	public static final int MAXFLOWERTYPECOUNT = FlowersEnum.values().length;
	private final Map<String, Integer> flowerMap;

	/**
	 * BouquetShop constructor.
	 * @param flowerMap
	 */
	private BouquetShop(Map<String, Integer> flowerMap) {

		this.flowerMap = flowerMap;

	}


	/**
	 * calculateBouquetCost
	 * @return cost of bouquet
	 */
	public double calculateBouquetCost() {

		double amount = 0.0;

		for(Map.Entry<String, Integer> flowerEntry : flowerMap.entrySet()) {

			FlowersEnum flowerEnum = FlowersEnum.valueOf(flowerEntry.getKey().toUpperCase());

			amount += flowerEnum.getFlowerPrice() * flowerEntry.getValue();

		}

		return amount;

	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Welcome to Bouquet shop");
			System.out.println("To create your bouquet, please enter how many type of flowers you want from 1 to " + MAXFLOWERTYPECOUNT);
			int flowerTypeCount = scanner.nextInt();

			// consume new line
			scanner.nextLine();

			if (flowerTypeCount < 1 || flowerTypeCount > MAXFLOWERTYPECOUNT) {

				throw new Exception("Invalid flower type count " + flowerTypeCount);
			}

			Map<String, Integer> flowerMap =  getFlowerTypeAndCountFromUser(scanner, flowerTypeCount);
			BouquetShop bouquetShop = new BouquetShop(flowerMap);
			System.out.printf("Your Bouquet Cost is %.2f rupees ", bouquetShop.calculateBouquetCost());

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	/**
	 * calculateBouquetCost.
	 * @param scanner
	 * @param flowerTypeCount
	 * @return Map of flower type and count
	 * @throws Exception
	 */
	public static Map<String, Integer> getFlowerTypeAndCountFromUser(Scanner scanner, int flowerTypeCount) throws Exception {

		Map<String, Integer> validFlowerMap = new HashMap<>();

		for (int i = 1; i<= flowerTypeCount; i++) {

			System.out.println("Enter which flower you want in your bouquet");
			for(FlowersEnum flower : FlowersEnum.values()) {
				System.out.println(flower);
			}

			String flowerType = scanner.nextLine();

			if (isValidFlower(flowerType)) {

				System.out.println("Enter the number of flowers you want for " + flowerType);

				int flowerCount = scanner.nextInt();

				// consume new line
				scanner.nextLine();

				if (flowerCount < 0 || flowerCount > BouquetShop.MAXONETYPEFLOWERCOUNT) {
					throw new Exception("Invalid flower count " + flowerCount + 
							" Please enter between 1 to " + BouquetShop.MAXONETYPEFLOWERCOUNT);

				}

				validFlowerMap.put(flowerType, flowerCount);

			} else {
				throw new Exception("Invalid flower type entered " + flowerType + " please enter only as given flower types");
			}

		}

		return validFlowerMap;

	}


	/**
	 * isValidFlower
	 * @param flower
	 * @return true if flower is valid
	 */
	public static boolean isValidFlower(String flower) {

		for (FlowersEnum flowerEnum : FlowersEnum.values()) {
			if (flower.equalsIgnoreCase(flowerEnum.toString())) {
				return true;
			}
		}

		return false;
	}

}

enum FlowersEnum {
	ROSES(10.00),
	JASMINES(20.00),
	LILI(30.00);

	private final double flowerPrice;

	FlowersEnum(double flowerPrice) {

		this.flowerPrice = flowerPrice;
	}

	public double getFlowerPrice() {
		return this.flowerPrice;
	}
}
