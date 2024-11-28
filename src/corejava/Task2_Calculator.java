package corejava;

public class Task2_Calculator {

	/**
	 * calculate operation
	 * @param number1
	 * @param operation
	 * @param number2
	 * @return result based on operation
	 * @throws Exception ArithmeticException if divide by zero IllegalArgumentException if numbers are not providedprudp
	 */
	public static double calculate(double number1, String operation, double number2) throws Exception {

		double result;

		switch(operation) {

		case "+":
			result =  number1 + number2;
			break;

		case "-":
			result =  number1 - number2;
			break;

		case "*":
			result =  number1 * number2;
			break;

		case "/":
			if (number2 == 0) {
				throw new ArithmeticException("you can not divide by zero");
			}

			result =  number1 / number2;
			break;

		case "%":
			if (number2 == 0) {
				throw new ArithmeticException("you can not divide by zero");
			}

			result =  number1 % number2;
			break;

		case "percent":
			result =  number1 * number2 /100;
			break;

		default:
			throw new IllegalArgumentException("the operation you are doing is not currently supported " + operation);
		}

		return result;

	}


	public static void main(String[] args) throws Exception {

		if (args.length != 3) {
			System.out.println("Allowed operation are +, -, *, /, %, percent only, Please enter your operation in correct format as command line argument, e.g. for multiplications - number1 * number2");
			return;	
		}

		try {
			double number1 = Double.parseDouble(args[0]);
			String operation = args[1];
			double number2 = Double.parseDouble(args[2]);
			double result;

			result = calculate(number1, operation, number2);

			System.out.printf("%f %s %f = %f", number1, operation, number2, result);

		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException - " + e.getMessage());
		} catch (NumberFormatException e2) {
			System.out.println("Please enter valid numbers - " + e2.getMessage());

		} catch(IllegalArgumentException e3) {
			System.out.println("IllegalArgumentException - " + e3.getMessage());
		} 
	}
}
