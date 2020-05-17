package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class FileTest {
	private LocalDateTime testDate1 = LocalDateTime.now();
	private LocalDateTime testDate2 = LocalDateTime.now();
	Directory root = new Directory(null, "Root", 0, testDate1);
	Directory home = new Directory(root, "Home", 0, testDate1);
	Directory applications = new Directory(root, "Applications", 0, testDate1);
	Directory code = new Directory(home, "Code", 0, testDate2);
	File a = new File(applications, "a", 1, testDate1);
	File b = new File(applications, "b", 2, testDate2);
	File c = new File(home, "c", 8, testDate1);
	File d = new File(home, "d", 7, testDate2);
	File e = new File(code, "e", 5, testDate2);
	File f = new File(code, "f", 6, testDate2);
	Link x = new Link(home, "x", 0, testDate1, this.applications);
	Link y = new Link(code, "y", 0, testDate2, this.b);

	private String[] fileToStringArray(File f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), f.getParent().getName(), String.valueOf(f.isDirectory()) };
		return fileInfo;
	}

	@Test
	public void verifyFileEqualityA() {
		String[] expected = { "true", "a", "10", testDate1.toString(), "Applications", "false" };
		File file = this.a;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyFileEqualityB() {
		String[] expected = { "true", "b", "9", testDate2.toString(), "Applications", "false" };
		File file = this.b;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyFileEqualityC() {
		String[] expected = { "true", "c", "8", testDate1.toString(), "Home", "false" };
		File file = this.c;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyFileEqualityD() {
		String[] expected = { "true", "d", "7", testDate2.toString(), "Home", "false" };
		File file = this.d;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyFileEqualityE() {
		String[] expected = { "true", "e", "5", testDate2.toString(), "Code", "false" };
		File file = this.e;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyFileEqualityF() {
		String[] expected = { "true", "f", "6", testDate2.toString(), "Code", "false" };
		File file = this.f;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}
}
