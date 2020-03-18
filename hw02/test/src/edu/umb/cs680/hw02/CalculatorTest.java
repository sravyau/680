package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	public void multiply6By2() {
		Calculator cut = new Calculator();
		float expected = 12;
		float actual = cut.multiply(6, 2);
		assertTrue(cut instanceof Calculator);
		assertEquals(expected, actual);
	}

	@Test
	public void divide2_5By5_5() {
		Calculator cut = new Calculator();
		float expected = (float) 2;
		float actual = cut.divide(10, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void divide3By2() {
		Calculator cut = new Calculator();
		float expected = (float) 1.5;
		float actual = cut.divide(3, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void divide5By0withTryCatch() {
		Calculator cut = new Calculator();
		try {
			cut.divide(10, 0);
			fail("Division by zero");
		} catch (IllegalArgumentException ex) {
			assertEquals("division by zero", ex.getMessage());
		}
	}

	@Test
	public void multiple2_5By5_5() {
		Calculator cut = new Calculator();
		float expected = (float) 25;
		float actual = cut.multiply(5, 5);
		assertEquals(expected, actual);
	}

}