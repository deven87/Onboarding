package oops_tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HomeElectricAppliances {

	/**
	 * map for storing the device name and its usage in hrs
	 */
	static final Map<String, Double> applianceConsumptionMap = new HashMap<>();

	/**
	 * fixed unit rate in rupees per unit
	 */
	public static final int UNIT_RATE = 8;

	/**
	 * getTotalPowerConsumptionAmount get the amount of total power consumed
	 * @return amount for total power consumed
	 */
	public double getTotalPowerConsumptionAmount() {

		double amount = 0.0;

		// traverse through each map entry set
		for (Map.Entry<String, Double> entry : applianceConsumptionMap.entrySet()) {

			amount += entry.getValue() * HomeAppliancesEnum.valueOf(entry.getKey().toUpperCase()).getUnit();
		}

		return amount * HomeElectricAppliances.UNIT_RATE;
	}

	/**
	 * displaySortedDeviceList based on the user entered usage
	 */
	public void displaySortedDeviceList(int sortOption) {
		System.out.println("Device sorted based on your usage hrs:");

		List<Map.Entry<String, Double>> applianceList = new ArrayList<>(applianceConsumptionMap.entrySet());

		if (sortOption == SortApplianceOptionEnum.DESCENDING.getSortOption()) {
			applianceList.sort((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));

		} else if (sortOption == SortApplianceOptionEnum.ASCENDING.getSortOption()) {
			applianceList.sort((entry1, entry2) -> Double.compare(entry1.getValue(), entry2.getValue()));

		}

		System.out.println(applianceList);

	}

	public static void main(String[] args) throws Exception {

		// create HomeElectricAppliances object
		HomeElectricAppliances homeElectricAppliances = new HomeElectricAppliances();

		// get user input for usage hrs
		try (Scanner scanner = new Scanner(System.in)) {

			for (HomeAppliancesEnum homeAppliancesEnum : HomeAppliancesEnum.values()) {

				System.out.printf("enter your consumption hrs for %s: (enter 0.0 if not applicable) %n", homeAppliancesEnum.toString());

				double hrs = scanner.nextDouble();

				applianceConsumptionMap.put(homeAppliancesEnum.toString(), hrs);

			}

			System.out.printf("Total Electricity Consumption is %.2f rupees based on %d rupees per unit %n", homeElectricAppliances.getTotalPowerConsumptionAmount(), HomeElectricAppliances.UNIT_RATE);

			System.out.println("Show all devices in the sorted order of your usage:");

			for (SortApplianceOptionEnum sortApplianceOptionEnum : SortApplianceOptionEnum.values()) {
				System.out.printf("Enter %d for %s Order of your usage hrs %n", sortApplianceOptionEnum.getSortOption(), sortApplianceOptionEnum.toString());
			}

			int sortOrder = scanner.nextInt();

			if (sortOrder != 1 && sortOrder !=2) {
				throw new Exception("Please enter correct sorting order " + sortOrder);
			}

			// sort the device list
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

/**
 * SortApplianceOptionEnum
 * provides the sorting option constants and their mapping
 */
enum SortApplianceOptionEnum {
	DESCENDING(1),
	ASCENDING(2);

	private final int sortOption;

	SortApplianceOptionEnum(int sortOption) {

		this.sortOption = sortOption;
	}

	public int getSortOption() {
		return this.sortOption;
	}

}
