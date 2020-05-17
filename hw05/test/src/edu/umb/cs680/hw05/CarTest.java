package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	private String[] carToStringArray(Car car) {
		String[] carInformation = {car.getMake(),car.getModel(),Integer.toString(car.getYear())};
		return carInformation;
	}
	
	@Test
	void verifyCarEqualityWithMakeModelYear() throws Exception{
		Car actual = new Car("Honda","Civic",20,2019,80000);
		String[] expected = {"Honda","Civic","2019"};
		assertArrayEquals(expected,carToStringArray(actual));
	}

}

