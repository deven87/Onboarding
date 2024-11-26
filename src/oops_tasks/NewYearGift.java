package oops_tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * NewYearGift class.
 */
public class NewYearGift {

	private final List<GiftItem> giftItems = new ArrayList<>();

	/**
	 * addItem to add item to the GiftItem
	 * @param giftItem GiftItem instance
	 */
	public void addItem(GiftItem giftItem) {
		giftItems.add(giftItem);

	}

	/**
	 * calculateTotalGiftWeight.
	 * @return total gift weight
	 */
	public double calculateTotalGiftWeight() {
		double weight = 0.0;
		for(GiftItem giftItem : giftItems) {
			weight += giftItem.getWeight();
		}

		return weight;
	}

	/**
	 * printCandiesInWeightRange.
	 * @param minWeight minimum weight for filter inclusive
	 * @param maxWeight maximum weight for filter inclusive
	 */
	public void printCandiesInWeightRange(double minWeight, double maxWeight) {

		System.out.println("Candies which are in given weight range are:"); 
		for(GiftItem giftItem : giftItems) {

			if (giftItem.getWeight() >= minWeight && giftItem.getWeight() <= maxWeight) {
				System.out.println(giftItem);
			}
		}

	}

	/**
	 * printCandiesInPriceRange.
	 * @param minPrice minimum price for filter inclusive
	 * @param maxPrice maximum price for filter inclusive
	 */
	public void printCandiesInPriceRange(double minPrice, double maxPrice) {
		for(GiftItem giftItem : giftItems) {

			if (giftItem.getPrice() >= minPrice && giftItem.getPrice() <= maxPrice) {
				System.out.println("Candi which is in given price range is: " + giftItem);
			}
		}

	}

	/**
	 * sortChocolates
	 * @param sortOption user provided sorting option
	 * @throws Exception thor exception if invalid sort option is provided
	 */
	public void sortChocolates(int sortOption) throws Exception {

		List<Chocolate> chocolate = new ArrayList<>();

		for(GiftItem giftItem : giftItems) {

			if (giftItem instanceof Chocolate) {

				chocolate.add((Chocolate)giftItem);
			}
		}

		Comparator<Chocolate> compare;

		if (SortOptionEnum.PRICE.getSortOption() == sortOption) {
			compare = (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice());
		} else if (SortOptionEnum.WEIGHT.getSortOption() == sortOption) {
			compare = (o1, o2) -> Double.compare(o1.getWeight(), o2.getWeight());
		} else {

			throw new Exception("Sort option provided is not valid " + sortOption);
		}

		chocolate.sort(compare);
		System.out.println(chocolate);

	}

	/**
	 * isSortOptionValid check that sort option provided is valid or not
	 * @param sortOption
	 * @return true if sort option provided is valid
	 */
	public static boolean isSortOptionValid(int sortOption) {
		for(SortOptionEnum sortOptionEnum : SortOptionEnum.values()) {

			if (sortOption == sortOptionEnum.getSortOption()) {
				return true;
			} 
		}

		return false;
	}

	public static void main(String[] args) throws Exception {

		NewYearGift newYearGift = new NewYearGift();

		newYearGift.addItem(new Chocolate("dairy milk", 100, 200));
		newYearGift.addItem(new Chocolate("cadbury", 101, 199));
		newYearGift.addItem(new Chocolate("five star", 100, 201));
		newYearGift.addItem(new Chocolate("nastle", 101, 200));
		newYearGift.addItem(new Sweet("Rasgulla", 200, 200));

		System.out.printf("total weight of the gift is %.2f grams%n", newYearGift.calculateTotalGiftWeight());

		newYearGift.printCandiesInWeightRange(100, 199);
		newYearGift.printCandiesInPriceRange(10, 200);

		System.out.println("Enter sorting option for chocolates as:");

		for(SortOptionEnum sortOption : SortOptionEnum.values()) {
			System.out.printf("Enter %d for %s sorting %n", sortOption.getSortOption(),sortOption.toString());
		}

		try (Scanner scanner = new Scanner(System.in)) {

			int sortOption = scanner.nextInt();

			if (isSortOptionValid(sortOption)) {

				newYearGift.sortChocolates(sortOption);

			} else {
				throw new Exception("Sort option provided is not valid " + sortOption);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


/**
 * Chocolate class
 */
class Chocolate extends GiftItem{

	/**
	 * Chocolate constructor
	 * @param name name of the gift
	 * @param weight weight of the gift in gram
	 * @param price price of the gift in rupees
	 */
	Chocolate(String name, double weight, double price) {
		super(name, weight, price);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}

/**
 * Sweet class
 */
class Sweet extends GiftItem{

	/**
	 * Sweet constructor
	 * @param name name of the gift
	 * @param weight weight of the gift in gram
	 * @param price price of the gift in rupees
	 */
	Sweet(String name, double weight, double price) {
		super(name, weight, price);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}

/**
 * GiftItem class
 */
class GiftItem {
	String name;
	double weight;
	double price;


	/**
	 * GiftItem constructor
	 * @param name name of the gift
	 * @param weight weight of the gift in gram
	 * @param price price of the gift in rupees
	 */
	GiftItem(String name, double weight, double price) {

		this.name = name;
		this.weight = weight;
		this.price = price;

	}

	@Override
	public String toString() {
		return name + " weight: " + weight + " gram " + " price: " + this.price + " rupees";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}

/**
 * SortOptionEnum
 * provides the sorting option constants and their mapping
 */
enum SortOptionEnum {
	PRICE(1),
	WEIGHT(2);

	private final int sortOption;

	SortOptionEnum(int sortOption) {

		this.sortOption = sortOption;
	}

	public int getSortOption() {
		return this.sortOption;
	}

}