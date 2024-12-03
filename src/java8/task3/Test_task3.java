package java8.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

public class Test_task3 {

	/**
	 * getAllProductsCost
	 * @param productList
	 * @return cost of all products
	 */
	public static double getAllProductsCost(List<Product> productList) {

		Function<List<Product>, Double> totalCostFunction = products -> {

			return products.stream().mapToDouble(prod -> prod.price).sum();
		};
		return totalCostFunction.apply(productList);

	}

	/**
	 * getAllProductsCostWithGivenCategory
	 * @param productList
	 * @param category
	 * @return cost for all products within given price and category
	 */
	public static double getAllProductsCostWithGivenCategory(List<Product> productList, String category) {

		Function<List<Product>, Double> totalCostForElectronicsProducts = products -> {

			return products.stream().filter(prod -> prod.category.equalsIgnoreCase(category))
					.mapToDouble(prod -> prod.price).sum();
		};

		return totalCostForElectronicsProducts.apply(productList);

	}


	/**
	 * getAllProductsCostWithinGivenPriceRange
	 *
	 * @param productList
	 * @param priceRangeNonInclusive
	 * @return total cost for given price range
	 */
	public static double getAllProductsCostWithinGivenPriceRange(List<Product> productList,
			double priceRangeNonInclusive) {

		Function<List<Product>, Double> totalCostFunctionWithPriceGreaterThanRange = products -> {

			return products.stream().filter(prod -> prod.price > priceRangeNonInclusive).mapToDouble(prod -> prod.price)
					.sum();
		};

		return totalCostFunctionWithPriceGreaterThanRange.apply(productList);

	}


	/**
	 * getAllProductsCostWithinGivenPriceRangeAndCategory
	 *
	 * @param productList
	 * @param priceRangeNonInclusive
	 * @param category
	 * @return total cost for given price and category
	 */
	public static List<Product> getAllProductsCostWithinGivenPriceRangeAndCategory(List<Product> productList,
			double priceRangeNonInclusive, String category) {

		Function<List<Product>, List<Product>> getElectronicProduct = products -> {

			return products.stream().filter(prod -> prod.category.equalsIgnoreCase(category))
					.filter(prod -> prod.price > priceRangeNonInclusive).collect(Collectors.toList());
		};

		return getElectronicProduct.apply(productList);

	}

	public static void main(String[] args) {

		List<Product> productList = new ArrayList<>();
		Product product1 = new Product("Electronics", "A", "AC", 2200.00);
		Product product2 = new Product("Electronics", "B", "Refrigerator", 50.00);
		Product product3 = new Product("Electronics", "C", "TV", 30000.00);
		Product product4 = new Product("Electrical", "C", "Wire", 10.00);


		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);

		/*
		 * 1.Write a function to calculate the cost of all products in a given list of
		 * products.
		 */
		System.out.println("Cost of all given products :");
		System.out.println(getAllProductsCost(productList));

		System.out.println("Cost of all given products having price > 1000 :");
		System.out.println(getAllProductsCostWithinGivenPriceRange(productList, 1000));

		System.out.println("Cost of all given products having category is Electronics :");
		System.out.println(getAllProductsCostWithGivenCategory(productList, "Electronics"));

		System.out.println("All Products having price > 1000 and category is Electronics :");
		printProducts(getAllProductsCostWithinGivenPriceRangeAndCategory(productList, 1000, "Electronics"));

	}

	/**
	 * printProducts
	 *
	 * @param list
	 */
	public static void printProducts(List<Product> list) {
		list.stream().forEach(prod -> System.out.println(prod.name));
	}
}