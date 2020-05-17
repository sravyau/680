package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;


public class DirectoryTest {

	static private LocalDateTime date1 = LocalDateTime.now();
	static private LocalDateTime date2 = LocalDateTime.now();
	static Directory root = new Directory(null, "Root", 0, date1);
	static Directory home = new Directory(null, "Home", 0, date1);
	static Directory applications = new Directory(null, "Applications", 0, date1);
	static Directory code = new Directory(null, "Code", 0, date2);
	static File a = new File(null, "a", 10, date1);
	static File b = new File(null, "b", 9, date2);
	static File c = new File(null, "c", 8, date1);
	static File d = new File(null, "d", 7, date2);
	static File e = new File(null, "e", 5, date2);
	static File f = new File(null, "f", 6, date2);
	static Link x = new Link(null, "x", 0, date1, null);
	static Link y = new Link(null, "y", 0, date2, null);

	private String[] dirToStringArray(Directory d) {
		String parentName = null;
		Directory parent = d.getParent();
		if (parent != null) {
			parentName = parent.getName();
		}
		String[] dirInfo = { String.valueOf(d.isFile()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(), parentName, String.valueOf(d.isDirectory()),
				Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()) };
		return dirInfo;
	}

	@BeforeAll
	static void init() {
		root.appendChild(home);
		root.appendChild(applications);
		home.appendChild(code);
		applications.appendChild(a);
		applications.appendChild(b);
		home.appendChild(c);
		home.appendChild(d);
		code.appendChild(e);
		code.appendChild(f);
		home.appendChild(x);
		code.appendChild(y);
		x.setTarget(applications);
		y.setTarget(b);
	}

	@Test
	public void verifyDirectoryEqualityRoot() {
		String[] expected = { "false", "Root", "0", date1.toString(), null, "true", "10", "1" };
		Directory dir = root;
		String[] actual = dirToStringArray(dir);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyDirectoryEqualityHome() {
		String[] expected = { "false", "Home", "0", date1.toString(), "Root", "true", "12", "3" };
		Directory dir = home;
		String[] actual = dirToStringArray(dir);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyDirectoryEqualityCode() {
		String[] expected = { "false", "Code", "0", date2.toString(), "Home", "true", "10", "4" };
		Directory dir = code;
		String[] actual = dirToStringArray(dir);
		assertArrayEquals(actual, expected);
	}
}