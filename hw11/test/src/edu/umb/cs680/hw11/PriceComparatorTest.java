package edu.umb.cs680.hw11;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PriceComparatorTest {

	@Test
	public void compareTest() {
		Car[] carArray = { new Car("Toyota", "RAV4", 2000, 2016, 10000), new Car("Toyota", "RAV4", 1000, 2018, 30000),
				new Car("Toyota", "RAV4", 4000, 2019, 100000) };
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, new PriceComparator());
		assertEquals(10000, cars.get(0).getPrice());
		assertEquals(30000, cars.get(1).getPrice());
		assertEquals(100000, cars.get(2).getPrice());
	}
}