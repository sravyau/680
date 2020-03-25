package edu.umb.cs.cs680.HW3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

public class StudentTest {

	@Test
	public void OutStateStudentStatusisOUTSTATE() {
		Student intl = Student.createOutStateStudent("John", "Boston", 5);
		assertEquals(StudentStatus.OUTSTATE, intl.getStatus());
	}
	
	@Test
	public void InStateStudentStatusisINSTATE() {
		Student intl = Student.createinStateStudent("John", "Boston");
		assertEquals(StudentStatus.INSTATE, intl.getStatus());
	}


	@Test
	public void IntlStudentSTATUSisINTL() {
		Student intl = Student.createIntlStudent("John", "Boston", 100, "England");
		assertEquals(StudentStatus.INTL, intl.getStatus());
	}

	@Test
	public void IntlStudentTUITIONis15000() {
		Student intl = Student.createIntlStudent("John", "Boston", 100, "England");
		assertEquals(15000, intl.getTuition());
	}

	@Test
	public void OutStateStudentTUITIONis10000() {
		Student intl = Student.createOutStateStudent("John", "Boston", 5);
		assertEquals(10000, intl.getTuition());
	}

	@Test
	public void InStateStudentTUITIONis7000() {
		Student intl = Student.createinStateStudent("Marc", "Boston");
		assertEquals(7000, intl.getTuition());
	}

	@Test
	public void InStateStudentTUITIONisNot10000() {
		Student intl = Student.createinStateStudent("Marc", "Boston");
		assertNotEquals(10000, intl.getTuition());
	}

	@Test
	public void InStateStudentTUITIONisNot15000() {
		Student intl = Student.createinStateStudent("Marc", "Boston");
		assertNotEquals(15000, intl.getTuition());
	}

	@Test
	public void OutStateStudentTUITIONisNot15000() {
		Student intl = Student.createOutStateStudent("Marc", "Boston", 5);
		assertNotEquals(15000, intl.getTuition());
	}

	@Test
	public void OutStateStudentTUITIONisNot7000() {
		Student intl = Student.createOutStateStudent("Marc", "Boston", 5);
		assertNotEquals(7000, intl.getTuition());
	}

	@Test
	public void IntlStudentTUITIONisNot7000() {
		Student intl = Student.createIntlStudent("Marc", "Boston", 120, "Europe");
		assertNotEquals(7000, intl.getTuition());
	}

	@Test
	public void IntlStudentTUITIONisNot10000() {
		Student intl = Student.createIntlStudent("Marc", "Boston", 120, "Europe");
		assertNotEquals(10000, intl.getTuition());
	}

}
