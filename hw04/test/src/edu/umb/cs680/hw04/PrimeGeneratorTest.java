package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {

	@Test
	public void testCase1() {
		PrimeGenerator gen = new PrimeGenerator(1, 10);
		gen.generatePrimes();
		Long[] expectedPrimes = { 2L, 3L, 5L, 7L };
		assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
	}

	@Test
	public void testCase2() {
		try {
			PrimeGenerator gen = new PrimeGenerator(0, 0);
			gen.generatePrimes();
			fail("Wrong input values: from=0 to=0");
		} catch (RuntimeException e) {
			assertEquals("Wrong input values: from=0 to=0", e.getMessage());
		}
	}

	@Test
	public void testCase3() {
		try {
			PrimeGenerator gen = new PrimeGenerator(-4, 6);
			gen.generatePrimes();
			fail("Wrong input values: from=-4 to=6");
		} catch (RuntimeException e) {
			assertEquals("Wrong input values: from=-4 to=6", e.getMessage());
		}
	}

	@Test
	public void testCase4() {
		PrimeGenerator gen = new PrimeGenerator(1, 100);
		gen.generatePrimes();
		Long[] expectedPrimes = { 2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L,
				67L, 71L, 73L, 79L, 83L, 89L, 97L };
		assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
	}

	@Test
	public void testCase5() {
		try {
			PrimeGenerator gen = new PrimeGenerator(100, 10);
			gen.generatePrimes();
			fail("Wrong input values: from=100 to=10");
		} catch (RuntimeException e) {
			assertEquals("Wrong input values: from=100 to=10", e.getMessage());
		}
	}
}
