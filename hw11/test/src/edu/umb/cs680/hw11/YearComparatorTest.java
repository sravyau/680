package edu.umb.cs680.hw11;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class YearComparatorTest {

	@Test
	public void YearCompare() {
		Car[] carArray = { new Car("Toyota", "RAV4", 2000, 2016, 10000), new Car("Toyota", "RAV4", 1000, 2018, 30000),
				new Car("Toyota", "RAV4", 4000, 2019, 100000) };
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, new YearComparator());
		assertEquals(2016, cars.get(0).getYear());
		assertEquals(2018, cars.get(1).getYear());
		assertEquals(2019, cars.get(2).getYear());
	}
}