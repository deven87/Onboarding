package java8.task8;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public String toString() {

		return "Product: " + this.name;
	}

}

public class Test_task8 {
	public static void main(String[] args) {

		List<Product> productList = new ArrayList<>();
		Product product1 = new Product("Electronics", "A", "AC", 100);
		Product product2 = new Product("Electronics", "B", "Refrigerator", 200);
		Product product3 = new Product("Electronics", "C", "Tv", 3000);
		Product product4 = new Product("Electrical", "C", "Wire", 10);
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);

		// print all products with price > 1000
		productList.stream().filter(product -> product.price > 1000)
		.forEach(product -> System.out.println(product.name));


		// print all electronics products
		productList.stream().filter(product -> product.category.equalsIgnoreCase("Electronics"))
		.forEach(product -> System.out.println(product.name));

		// print name in upper case of products having price > 1000 and are electronics
		productList.stream().filter(product -> product.category.equalsIgnoreCase("Electronics"))
		.filter(product -> product.price > 1000).map(product -> {
			product.name = product.name.toUpperCase();
			return product;
		}).forEach(product -> System.out.println(product.name));


		// print count of products in electronics
		System.out
		.println(productList.stream().filter(product -> product.category.equalsIgnoreCase("Electronics"))
				.count());

	}
}