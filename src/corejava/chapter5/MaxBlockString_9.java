package corejava.chapter5;

public class MaxBlockString_9 {

	public static void main(String[] args) {

		String str = "hhhhhheelloooo";

		MaxBlockString_9.maxBlock(str);

	}

	/**
	 * maxBlock
	 * @param str
	 * @return no of occurance of character repeated the most adjecently 
	 */
	public static int maxBlock(String str) {
		
		if (str.isEmpty()) {
			return 0;
		}

		char currentChar = str.charAt(0);
		int currentCount = 1;	
		char maxChar = str.charAt(0);
		int maxCount  = 1;

		for (int i = 1; i< str.length(); i++) {

			if (str.charAt(i) == currentChar) {

				currentCount++;
			} else {

				currentChar = str.charAt(i);
				currentCount = 1;
			}

			if ( maxCount < currentCount) {
				maxCount = currentCount;
				maxChar = currentChar;
			}

		}

		System.out.println("Char " + maxChar + " occurance is " + maxCount);

		return maxCount;

	}

}
