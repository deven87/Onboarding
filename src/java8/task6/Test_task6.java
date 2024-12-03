package java8.task6;

import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;

public class Test_task6 {


	public static void main(String[] args) {

		IntPredicate isPrime = x -> x % 2 == 0;
		System.out.println("isPrime predicate : " + isPrime.test(3));
		System.out.println("isPrime predicate : " + isPrime.test(4));

		IntConsumer square = x -> System.out.println(x * x);

		square.accept(2);
		square.accept(10);

		IntSupplier randomNumber = () -> new Random().nextInt(5000);

		System.out.println("Random number from supplier " + randomNumber.getAsInt());

	}


}