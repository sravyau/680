package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	public void getYearTest() {
		Car car = new Car("Toyota", "RAV4", 20, 2018, 10000);
		int actual = car.getYear();
		int expected = 2018;
		assertEquals(actual, expected);
	}

	@Test
	public void getMileageTest() {
		Car car = new Car("Toyota", "RAV4", 20, 2018, 10000);
		int actual = car.getMileage();
		int expected = 20;
		assertEquals(actual, expected);
	}

	@Test
	public void getPriceTest() {
		Car car = new Car("Toyota", "RAV4", 20, 2018, 10000);
		float actual = car.getPrice();
		float expected = 10000;
		assertEquals(actual, expected);
	}
}
