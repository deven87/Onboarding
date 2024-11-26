package oops_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * PizzaShop to order pizza.
 */
public class PizzaShop {

    private static final int MAXTOPPING = 3;

    private final String base;

    private final List<String> toppings;

    /**
     * PizzaShop constructor.
     * @param base
     * @param toppings
     */
    private PizzaShop(String base, List<String> toppings) {

        this.base = base;
        this.toppings = toppings;

    }

    /**
     * getToppingsList gets the list of all toppings entered by customer
     * @param scanner
     * @param noOfTopings
     * @return user entered valid toppings
     * @throws Exception if incorrect toppings are provided
     */
    public static List<String> getToppingsListFromUser(Scanner scanner, int noOfTopings) throws Exception {

        List<String> validToppingsList = new ArrayList<>();

        for (int i = 1; i <= noOfTopings; i++) {
            System.out.println("Ennter topping as one of the given:");
            for (PizzaToppings toppingEnum : PizzaToppings.values()) {
                System.out.println(toppingEnum.toString());
            }

            String userTopping = scanner.nextLine();
            if (isValidTopping(userTopping)) {
            	validToppingsList.add(userTopping);
            } else {
                throw new Exception("Incorrect Topping provided " + userTopping);
            }
        }
        return validToppingsList;
    }

    /**
     * getNoOfToppings get the total no of topings entered by customer
     * @param scanner
     * @return
     * @throws Exception if incorrect number of toppings are provided
     */
    public static int getNoOfToppingsFromUser(Scanner scanner) throws Exception {
        System.out.println("Enter no of toppings from 1 to " + PizzaShop.MAXTOPPING);
        int noOfToppings = scanner.nextInt();
       
        // consume new line
        scanner.nextLine();

        if (noOfToppings < 1 || noOfToppings > PizzaShop.MAXTOPPING) {
            throw new Exception("Incorrect no of topings");
        }

        return noOfToppings;
    }

    /**
     * isValidTopping
     * @param topping user provided topping
     * @return true if topping provided is a valid topping
     */
    public static boolean isValidTopping(String topping) {
        for (PizzaToppings toppingEnum : PizzaToppings.values()) {
            if (topping.equalsIgnoreCase(toppingEnum.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * getBaseChoiceFromUser.
     * @param scanner 
     * @return base choice
     * @throws Exception if base choice provided is incorrect
     */
    public static String getBaseChoiceFromUser(Scanner scanner) throws Exception {
        System.out.println("Enter Base Choice as:");
        for (PizzaBase baseEnum : PizzaBase.values()) {
            System.out.println(baseEnum.toString());
        }

        String baseChoice = scanner.nextLine();
        if (isBaseChoiceValid(baseChoice)) {
            return baseChoice;
        } else {
            throw new Exception("Invalid Base Choice " + baseChoice);
        }
    }

    /**
     * isBaseChoiceValid.
     * @param baseChoice
     * @return true if base choice provided is correct
     */
    public static boolean isBaseChoiceValid(String baseChoice) {

        for (PizzaBase baseEnum : PizzaBase.values()) {
            if (baseChoice.equalsIgnoreCase(baseEnum.toString())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to Pizza Shop");

        try (Scanner scanner = new Scanner(System.in)) {

            String baseChoice = getBaseChoiceFromUser(scanner);
            int noOfToppings = getNoOfToppingsFromUser(scanner);
            List<String> toppings = getToppingsListFromUser(scanner, noOfToppings);

            PizzaShop pizzaShop = new PizzaShop(baseChoice, toppings);

            System.out.println("price of the pizza is " + pizzaShop.calculatePizzaPrice());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * calculatePizzaPrice.
     * @return total price of pizza
     */
    public double calculatePizzaPrice() {

        return calculateBasePrice() + calculateTopingsPrice();

    }

    /**
     * calculateBasePrice
     * @return pizza base price
     */
    public double calculateBasePrice() {

        double basePrice = 0.0;

        for (PizzaBase baseEnum : PizzaBase.values()) {
            if (this.base.equalsIgnoreCase(baseEnum.toString())) {
                basePrice = baseEnum.getBasePrice();
            }
        }

        return basePrice;
    }

    /**
     * calculateTopingsPrice.
     * @return pizza topping price
     */
    public double calculateTopingsPrice() {

        double amount = 0;

        for (String topping : this.toppings) {

            for (PizzaToppings pizzaTopping : PizzaToppings.values()) {

                if (pizzaTopping.toString().equalsIgnoreCase(topping)) {
                    amount += pizzaTopping.getToppingPrice();
                }
            }
        }

        return amount;
    }

}

enum PizzaBase {
    STANDARD(50.00),
    SOFT(100.00);

    private final double basePrice;

    PizzaBase(double basePrice) {

        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

}

enum PizzaToppings {
    TOMATTO(5.00),
    CORN(10.00),
    MASHROOM(15.00);

    private final double toppingPrice;

    PizzaToppings(double toppingPrice) {

        this.toppingPrice = toppingPrice;
    }

    public double getToppingPrice() {
        return this.toppingPrice;
    }

}
