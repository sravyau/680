package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;

public class LinkTest {

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
	static Link x = new Link(null, "x", 6, date1, null);
	static Link y = new Link(null, "y", 6, date2, null);

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
	public void verifyLinkEqualityX() {
		Directory expected = applications;
		FSElement actual = x.getTarget();
		assertSame(actual, expected);
	}

	@Test
	public void verifyLinkEqualityY() {
		File expected = b;
		FSElement actual = y.getTarget();
		assertSame(actual, expected);
	}
}