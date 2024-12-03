package java8.task1;

public class Runnable_4 {

	public static void main(String[] args) {
		Runnable runnable = () -> {

			int[] arr = { 1, 2, 3, 4, 5 };

			for (int num : arr) {
				System.out.println(num);
			}

		};
		Thread thread = new Thread(runnable);
		thread.start();

	}

}
