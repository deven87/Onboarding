package java8.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Product {
	String category;
	String grade;
	String name;
	double price;

	Product(String category, String grade, String name, double price) {

		this.category = category;
		this.grade = grade;
		this.name = name;
		this.price = price;
	}

}

public class Test_task2 {

	public static void main(String[] args) {

		List<Product> productList = new ArrayList<>();
		Product product1 = new Product("Electronics", "A", "AC", 2200.00);
		Product product2 = new Product("Electronics", "B", "Refrigerator", 50.00);

		productList.add(product1);
		productList.add(product2);

		/*
		 * 1. Define a predicate to check if the price of given product is greaterthan
		 * 1000/-. Print all the products from the given list of the products if the
		 * price is greaterthan 1000/-.
		 */
		// predicate for product having price > 1000
		Predicate<Product> itemPriceGreaterThan1000 = product -> product.price > 1000;
		System.out.println("Products with price > 1000 :");
		productList.stream().filter(itemPriceGreaterThan1000).forEach(pr -> System.out.println(pr.name));

		/*
		 * 2. Define a predicate to check if the product is of electronics category.
		 * Print all the products from the given list of the products if the product is
		 * of electronics category.
		 */
		// predicate for product having category = Electronics
		Predicate<Product> isElectronicsCategory = product -> product.category.equalsIgnoreCase("Electronics");
		System.out.println("Products with Electronics category :");
		productList.stream().filter(isElectronicsCategory).forEach(pr -> System.out.println(pr.name));

		// predicate for product having price > 100
		Predicate<Product> itemPriceGreaterThan100 = product -> product.price > 100;

		// predicate for product having price < 100
		Predicate<Product> itemPriceLessThan100 = product -> product.price < 100;

		// predicate for product having category = Electronics
		Predicate<Product> priceGreaterThan100AndElectronics = itemPriceGreaterThan100.and(isElectronicsCategory);

		/*
		 * Print all the products from the given list of product if the product price is
		 * greaterthan 100/- which are in electronics category.
		 */
		System.out.println("Products with Price greater than 100 and Electronics category :");
		productList.stream().filter(priceGreaterThan100AndElectronics).forEach(pr -> System.out.println(pr.name));

		/*
		 * Print all the products from the given list of product if the product price is
		 * greaterthan 100/- or product is in electronics category.
		 */
		// predicate for product having category = Electronics
		Predicate<Product> priceGreaterThan100OrElectronics = itemPriceGreaterThan100.or(isElectronicsCategory);

		/*
		 * Print all the products from the given list of product if the product price is
		 * lessthan 100/- and product is in electronics category.
		 */
		System.out.println("Products with Price greater than 100 or Electronics category :");
		productList.stream().filter(priceGreaterThan100OrElectronics).forEach(pr -> System.out.println(pr.name));

		// predicate for product having category = Electronics
		Predicate<Product> priceLessThan100AndElectronics = itemPriceLessThan100.and(isElectronicsCategory);

		System.out.println("Products with Price less than 100 and Electronics category :");
		productList.stream().filter(priceLessThan100AndElectronics).forEach(pr -> System.out.println(pr.name));

	}

}