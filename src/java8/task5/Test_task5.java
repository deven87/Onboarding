package java8.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

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

public class Test_task5 {

	/**
	 * costOfCart
	 *
	 * @param productsMap
	 * @return total cost of cart
	 */
	public static double costOfCart(Map<Product, Integer> productsMap) {

		return productsMap.entrySet().stream()
				.mapToDouble(entry -> costOfProduct(entry.getKey(), entry.getValue())).sum();
	}

	/**
	 * costOfProduct
	 *
	 * @param product
	 * @param quaqntity
	 * @return
	 */
	public static double costOfProduct(Product product, int quaqntity) {

		BiFunction<Product, Integer, Double> productCost = (prod, quantity) -> {

			return prod.price * quantity;
		};

		return productCost.apply(product, quaqntity);
	}

	/**
	 * getAllProductsCost
	 * @param productList
	 * @return cost of all products
	 */
	public static Product createProduct(String productName, double productPrice) {

		BiFunction<String, Double, Product> totalCostFunction = (name, price) ->
		new Product("Dummy", "Dummy", name, price);

		return totalCostFunction.apply(productName, productPrice);

	}

	public static void main(String[] args) {

		List<Product> productList = new ArrayList<>();
		Map<Product, Integer> productsCart = new HashMap<>();
		Product product1 = new Product("Electronics", "A", "AC", 100);
		Product product2 = new Product("Electronics", "B", "Refrigerator", 200);
		Product product3 = new Product("Electronics", "C", "TV", 300);
		Product product4 = new Product("Electrical", "C", "Wire", 10);
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);

		productsCart.put(product1, 2);
		productsCart.put(product2, 3);
		productsCart.put(product3, 4);
		productsCart.put(product4, 10);


		/*
		 *
		 * 1. Given the name and price of the product, write a Bifunction to create a
		 * product.
		 */
		System.out.println("Cost of a single products :");
		System.out.println(costOfProduct(product1, 10));

		/*
		 * 2. Given the Product and quantity of the products, write a BiFunction to
		 * calculate the cost of products. A cart is a map of product and quantity.
		 * Given the cart, calculate the cost of the cart.
		 */
		System.out.println("Cost of cart products :");
		System.out.println(costOfCart(productsCart));

	}
}