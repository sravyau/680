package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ParetoComparatorTest {
	@Test
	public void ParetoCompare() {
		Car[] carArray = { new Car("Toyota", "RAV4", 1000, 2016, 10000), new Car("Toyota", "RAV4", 2000, 2017, 20000),
				new Car("Toyota", "RAV4", 3000, 2018, 30000), new Car("Toyota", "RAV4", 4000, 2019, 100000) };
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		for (Car car : cars) {
			car.setDominationCount(cars);
		}
		Collections.sort(cars, new ParetoComparator());
		assertEquals(10000, cars.get(0).getPrice());
		assertEquals(20000, cars.get(1).getPrice());
		assertEquals(30000, cars.get(2).getPrice());
		assertEquals(100000, cars.get(3).getPrice());
	}
}