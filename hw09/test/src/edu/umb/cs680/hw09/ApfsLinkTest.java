package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApfsLinkTest {

	static private LocalDateTime date1 = LocalDateTime.now();
	static private LocalDateTime date2 = LocalDateTime.now();
	static ApfsDirectory root = new ApfsDirectory(null, "root", 0, date1, "Admin", date2);
	static ApfsDirectory home = new ApfsDirectory(null, "Home", 0, date1, "Admin", date2);
	static ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, date1, "Admin", date2);
	static ApfsDirectory code = new ApfsDirectory(null, "Code", 0, date2, "Admin", date2);
	static ApfsFile a = new ApfsFile(null, "a", 10, date1, "Admin", date2);
	static ApfsFile b = new ApfsFile(null, "b", 9, date2, "Admin", date2);
	static ApfsFile c = new ApfsFile(null, "c", 8, date1, "Admin", date2);
	static ApfsFile d = new ApfsFile(null, "d", 7, date2, "Admin", date2);
	static ApfsFile e = new ApfsFile(null, "e", 5, date2, "Admin", date2);
	static ApfsFile f = new ApfsFile(null, "f", 6, date2, "Admin", date2);
	static ApfsLink x = new ApfsLink(null, "x", 0, date1, null, "Admin", date2);
	static ApfsLink y = new ApfsLink(null, "y", 0, date2, null, "Admin", date2);

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
	public void verifyLinkTest() {
		Boolean actual = x.isLink();
		Boolean expected = true;
		assertSame(expected, actual);
	}

	
	@Test
	public void verifyTargetSizeTest() {
		int actual = x.getTargetSize();
		int expected = 0;
		assertSame(expected, actual);
	}

	@Test
	public void verifyTargetIsLinkTest() {
		Boolean actual = x.targetisLink();
		Boolean expected = false;
		assertSame(expected, actual);
	}


	@Test
	public void verifyTargetIsFileTest() {
		Boolean actual = x.targetisFile();
		Boolean expected = false;
		assertSame(expected, actual);
	}

	
	@Test
	public void verifyTargetIsDirectoryTest() {
		Boolean actual = x.targetisDirectory();
		Boolean expected = true;
		assertSame(expected, actual);
	}

	
	@Test
	public void setTargetTest() {
		x.setTarget(code);
		ApfsElement actual = x.getTarget();
		ApfsDirectory expected = code;
		assertSame(expected, actual);
	}

	
	@Test
	public void verifyEqualityOfLinkX() {
		ApfsDirectory expected = code;
		ApfsElement actual = x.getTarget();
		assertSame(expected, actual);
	}


	@Test
	public void verifyEqualityOfLinkY() {
		ApfsFile expected = b;
		ApfsElement actual = y.getTarget();
		assertSame(expected, actual);
	}
}