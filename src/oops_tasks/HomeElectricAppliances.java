package oops_tasks;

import java.util.HashMap;
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

	public static void main(String[] args) {

		HomeElectricAppliances homeElectricAppliances = new HomeElectricAppliances();

		try (Scanner scanner = new Scanner(System.in)) {

			for (HomeAppliancesEnum homeAppliancesEnum : HomeAppliancesEnum.values()) {

				System.out.printf("enter your consumption hrs for %s: (enter 0.0 if not applicable) %n", homeAppliancesEnum.toString());

				double hrs = scanner.nextDouble();

				applianceConsumptionMap.put(homeAppliancesEnum.toString(), hrs);

			}
		}

		System.out.printf("Total Electricity Consumption is %.2f rupees based on %d rupees per unit %n", homeElectricAppliances.getTotalPowerConsumptionAmount(), HomeElectricAppliances.UNIT_RATE);
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