package collection.list.checker;

class Person {
	String name;
	int score;

	Person (String name, int score) {
		this.name = name;
		this.score = score;
	}

	/**
	 * override object to string to print class object in pretty format
	 */
	@Override
	public String toString() {
		return "Person Name: " + name + " and Score: " + score + "";
	}

}