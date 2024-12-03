package java8.task4;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

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

public class Test_task4 {

	public static final boolean IS_FILE = false;

	static IntSupplier randomOTPSupplier = () -> {
		Random random = new Random();
		return random.nextInt(100000, 999999);
	};

	static Supplier<Product> randomProductSupplier = ()->{
		Random random = new Random();
		return new Product(String.valueOf(random.nextInt()), String.valueOf(random.nextInt()), String.valueOf(random.nextInt()), random.nextDouble());
	};

	public static void main(String[] args) {

		List<Product> productList = new ArrayList<>();
		Product product1 = new Product("Electronics", "A", "AC", 2200.00);
		Product product2 = new Product("Electronics", "B", "Refrigerator", 50.00);
		Product product3 = new Product("Electronics", "C", "TV", 30000.00);


		productList.add(product1);
		productList.add(product2);
		productList.add(product3);


		/*
		 * 1. Given a product write a consumer to print the product to appropriate
		 * medium depending on the print parameter. If the print parameter is set to
		 * file, consumer shall log the product to file, if not print on the console.
		 */
		Consumer<Product> printToFileOrConsole = product -> {

			if (IS_FILE) {
				Path path = Paths.get(System.getProperty("user.dir"), "src", "java8", "task3", "itemFile.txt");
				try (FileWriter fileWriter = new FileWriter(path.toString(), true);) {
					fileWriter.write(product.name + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println(product.name);
			}
		};

		System.out.println("Print product name to file or console");
		// productList.stream().forEach(printToFileOrConsole);

		/*
		 * 2. Write a Consumer to update the grade of the product as 'Premium' if the
		 * price is > 1000/-. Given the product list, update the grade for each product
		 * and print all of the products.
		 */
		Function<Product, Product> updateGrade = (prod) -> {
			if (prod.price > 1000) {
				prod.grade += "+";
			}
			return prod;
		};

		// update grade if price is > 1000 and return all the product grades
		productList.stream().map(updateGrade).forEach(prod -> System.out.println(prod.grade));

		/*
		 * 3. Write a Consumer to update the name of the product to be suffixed with '*'
		 * if the price of product is > 3000/-. Given the product list, update the name
		 * for each product and print all of the products.
		 */
		// update grade if price is > 3000 and return all the product name with suffix as *
		productList.stream().map(prod -> {
			if (prod.price > 3000) {
				prod.name += "*";
			}
			return prod;
		}).forEach(prod -> System.out.println(prod.name));

		// 4. Print all the Premium grade products with name suffixed with '*'.
		productList.stream().filter(prod -> prod.name.endsWith("*")).forEach(printToFileOrConsole);

		// supply random product
		productList.add(randomProductSupplier.get());

		System.out.println(randomOTPSupplier.getAsInt());
	}



}