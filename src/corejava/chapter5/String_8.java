package corejava.chapter5;

public class String_8 {

	public static void main(String[] args) {

		String base = "helllolo thereee";
		String remove = "llo";
		System.out.println(String_8.withoutString(base, remove));

	}

	/**
	 * withoutString
	 * @param base base String
	 * @param remove substring to be removed from base
	 * @return remaining base string
	 */
	public static String withoutString(String base, String remove) {

		return base.replaceAll("(?i)" + remove, "");
	}

}
