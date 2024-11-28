package corejava.chapter5;

public class Condition_5 {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;
		int c = 30;
		boolean bOk = true;

		System.out.printf("input values are %d, %d, %d, %b%n", a, b, c, bOk);

		System.out.println("In Order Output is " + Condition_5.inOrder(a, b, c, bOk));
	}

	/**
	 * inOrder
	 * @param a
	 * @param b
	 * @param c
	 * @param bOk
	 * @return boolean value based on condition check
	 */
	public static boolean inOrder(int a, int b, int c, boolean bOk) {

		if (bOk) {
			if (c > b) {
				return true;
			}
		} else {
			if (b > a && c > b) {
				return true;
			}
		}

		return false;

	}

}
