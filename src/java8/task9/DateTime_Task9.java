package java8.task9;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DateTime_Task9 {

	// function for age
	/*
	 * function to get your age when your dob is given
	 */
	static Function<LocalDate, Integer> calculateAge = dateLocal -> {
		LocalDate currentDate = LocalDate.now();

		return Period.between(dateLocal, currentDate).getYears();

	};

	/*
	 * Supplier to get next thursday date
	 */
	static Supplier<LocalDate> getThursday = () -> {

		LocalDate date = LocalDate.now();
		int currentDay = date.getDayOfWeek().getValue();

		int thrusday = DayOfWeek.THURSDAY.getValue();

		int nextThursday = thrusday - currentDay;

		if (nextThursday < 0) {
			nextThursday += 7;
		}

		return date.plusDays(nextThursday);

	};

	/**
	 * predicate to check if given date is of yesterday
	 */
	static Predicate<LocalDate> isDateYesterday = dateLocal -> LocalDate.now().minusDays(1).isEqual(dateLocal);

	// supplier for time zone
	/*
	 * Supplier to get a est time zone date
	 */
	static Supplier<LocalDateTime> timeZoneInEST = () -> {
		ZonedDateTime dateInEST = ZonedDateTime.now(ZoneId.of("America/New_York"));
		return dateInEST.toLocalDateTime();
	};

	public static void main(String[] args) {

		// is date yesterday
		System.out.println(isDateYesterday.test(LocalDate.now()));
		System.out.println(isDateYesterday.test(LocalDate.now().minusDays(1)));

		// supplier for getting next thursday
		System.out.println(getThursday.get());

		// get time zone date
		System.out.println(timeZoneInEST.get());

		// get age
		LocalDate birthDay = LocalDate.of(1987, 5, 5);
		System.out.println(calculateAge.apply(birthDay));
	}
}
