package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;

import java.util.LinkedList;
import java.time.LocalDateTime;


public class AlphabeticalComparatorTest {

	static private LocalDateTime date1 = LocalDateTime.now();
	static private LocalDateTime date2 = LocalDateTime.now().plusDays(1);
	static ApfsDirectory root = new ApfsDirectory(null, "root", 0, date1, "Admin", date2);
	static ApfsDirectory home = new ApfsDirectory(null, "Home", 0, date1, "Admin", date2);
	static ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, date1, "Admin", date2);
	static ApfsDirectory code = new ApfsDirectory(null, "Code", 0, date2, "Admin", date2);
	static ApfsDirectory apps = new ApfsDirectory(null, "Apps", 0, date1, "Admin", date2);
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
		home.appendChild(apps);
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
	public void GetChildrenTest() {
		ApfsDirectory dir = root;
		LinkedList<ApfsElement> actualList = dir.getChildren(new AlphabeticalComparator());
		ApfsElement[] actual = actualList.toArray(new ApfsElement[actualList.size()]);
		ApfsElement[] expected = { applications, home };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getSubDirectoriesTest() {
		ApfsDirectory dir = home;
		LinkedList<ApfsDirectory> actualList = dir.getSubDirectories(new AlphabeticalComparator());
		ApfsDirectory[] actual = actualList.toArray(new ApfsDirectory[actualList.size()]);
		ApfsDirectory[] expected = { apps, code };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getFilesTest() {
		ApfsDirectory dir = home;
		LinkedList<ApfsFile> actualList = dir.getFiles(new AlphabeticalComparator());
		ApfsFile[] actual = actualList.toArray(new ApfsFile[actualList.size()]);
		ApfsFile[] expected = { c, d };
		assertArrayEquals(expected, actual);
	}
}