package corejava.chapter1;

public class Task2_1 {
	
	public static void main(String[] args) {

		// passed the argument from IDE
		
		if (args.length !=1) {
			System.out.println("command line argument incorrect, please enter your first name");
			return;
		}

		System.out.println("Hello, " + args[0]);
	}

}
