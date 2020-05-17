package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ParetoComparatorTest {
	@Test
	public void ParetoCompare() {
		Car[] carArray = { new Car("Honda", "Civic", 1000, 2009, 18000), new Car("Honda", "Civic", 2000, 2015, 20000),
				new Car("Honda", "Civic", 3000, 2018, 25000), new Car("Honda", "Civic", 4000, 2019, 150000) };
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		for (Car car : cars) {
			car.setDominationCount(cars);
		}
		Collections.sort(cars, (Car car1, Car car2) -> {
			return car2.getDominationCount() - car1.getDominationCount();
		});
		assertEquals(10000, cars.get(0).getPrice());
		assertEquals(20000, cars.get(1).getPrice());
		assertEquals(30000, cars.get(2).getPrice());
		assertEquals(100000, cars.get(3).getPrice());
	}
}