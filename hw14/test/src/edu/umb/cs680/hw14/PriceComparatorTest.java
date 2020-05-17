package edu.umb.cs680.hw14;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PriceComparatorTest {

	@Test
	public void compareTest() {
		Car[] carArray = { new Car("Honda", "Civic", 3000, 2018, 25000), new Car("Honda", "Civic", 2000, 2015, 20000),
				new Car("Honda", "Civic", 4000, 2019, 150000) };
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, (Car car1, Car car2) -> {
			return car1.getPrice() - car2.getPrice();
		});
		assertEquals(10000, cars.get(0).getPrice());
		assertEquals(30000, cars.get(1).getPrice());
		assertEquals(100000, cars.get(2).getPrice());
	}
}