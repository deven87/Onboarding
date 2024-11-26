package oops_tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HomeElectricAppliances {

	static final Map<String, Double> applianceConsumptionMap = new HashMap<>();
	public static final int UNIT_RATE = 8;

	/**
	 * getTotalPowerConsumptionAmount
	 * @return amount for total power consumed
	 */
	public double getTotalPowerConsumptionAmount() {

		double amount = 0.0;

		for (Map.Entry<String, Double> entry : applianceConsumptionMap.entrySet()) {

			for (HomeAppliancesEnum homeAppliancesEnum : HomeAppliancesEnum.values()) {

				if (entry.getKey().equalsIgnoreCase(homeAppliancesEnum.toString())) {
					amount += entry.getValue() * homeAppliancesEnum.getUnit();
				}
			}
		}

		return amount * HomeElectricAppliances.UNIT_RATE;
	}

	/**
	 * displaySortedDeviceList based on the user entered usage
	 */
	public void displaySortedDeviceList(int sortOption) {
		System.out.println("Device sorted based on your usage hrs:");

		List<Map.Entry<String, Double>> applianceList = new ArrayList<>(applianceConsumptionMap.entrySet());

		if (sortOption == 1) {
			applianceList.sort((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));

		} else if (sortOption == 2) {
			applianceList.sort((entry1, entry2) -> Double.compare(entry1.getValue(), entry2.getValue()));

		}

		System.out.println(applianceList);

	}

	public static void main(String[] args) throws Exception {

		HomeElectricAppliances homeElectricAppliances = new HomeElectricAppliances();

		try (Scanner scanner = new Scanner(System.in)) {

			for (HomeAppliancesEnum homeAppliancesEnum : HomeAppliancesEnum.values()) {

				System.out.printf("enter your consumption hrs for %s: (enter 0.0 if not applicable) %n", homeAppliancesEnum.toString());

				double hrs = scanner.nextDouble();

				applianceConsumptionMap.put(homeAppliancesEnum.toString(), hrs);

			}

			System.out.printf("Total Electricity Consumption is %.2f rupees based on %d rupees per unit %n", homeElectricAppliances.getTotalPowerConsumptionAmount(), HomeElectricAppliances.UNIT_RATE);

			System.out.println("Show all devices in the sorted order of your usage:");

			System.out.println("Enter 1 for showing highest used device first");
			System.out.println("Enter 2 for showing lowest used device first");

			int sortOrder = scanner.nextInt();

			if (sortOrder != 1 && sortOrder !=2) {
				throw new Exception("Please enter correct sorting order " + sortOrder);
			}

			homeElectricAppliances.displaySortedDeviceList(sortOrder);

		}
	}

}

/**
 * HomeAppliancesEnum
 * provide the appliance name and per hr unit consumption
 */
enum HomeAppliancesEnum {

	FAN(1),
	LIGHT(2),
	TV(3),
	LAPTOP(4);

	private final double unit;

	HomeAppliancesEnum(double unit) {

		this.unit = unit;
	}

	public double getUnit() {
		return this.unit;
	}

}
