package edu.umb.cs680.hw14;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MileageComparatorTest {

	@Test
	public void MileageCompare() {
		Car[] carArray = { new Car("Honda", "Civic", 3000, 2018, 25000), new Car("Honda", "Civic", 2000, 2015, 20000),
				new Car("Honda", "Civic", 4000, 2019, 150000) };
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, (Car car1, Car car2) -> {
			return car1.getMileage() - car2.getMileage();
		});
		assertEquals(1000, cars.get(0).getMileage());
		assertEquals(2000, cars.get(1).getMileage());
		assertEquals(4000, cars.get(2).getMileage());
	}
}