package corejava.chapter6;

public class ArrayInnerOuter {

	public static void main(String[] args) {

		int[] arrInner = {2,4};
		int[] arrOuter = {1,2,4,6};
		System.out.println(ArrayInnerOuter.linearIn(arrOuter, arrInner));	
	}

	/**
	 * linearIn
	 * @param arrInner
	 * @param arrOuter
	 * @return true if outer array is found inside inner array
	 */
	public static boolean linearIn(int[] arrOuter, int[] arrInner) {

			int i = 0;
			int j = 0;

			if (arrOuter.length < arrInner.length) {
				return false;
			}

			while (i < arrOuter.length && j < arrInner.length) {

				if (arrOuter[i] == arrInner[j]) {
					j++;
				}

				i++;
			}

			return j == arrInner.length;
		}

	}
