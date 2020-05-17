package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
import java.time.LocalDateTime;
import java.util.LinkedList;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FileSystemTest {

	private LocalDateTime testDate;

	private Directory[] LinkedListToArray(LinkedList<Directory> rootList) {
		Directory[] rootArray = new Directory[rootList.size()];
		int i = 0;
		for (Directory root : rootList) {
			rootArray[i++] = root;
		}
		return rootArray;
	}

	//@Order(1)
	@Test
	public void sameFileSystemTest() {
		FileSystem fs1 = FileSystem.getFileSystem();
		FileSystem fs2 = FileSystem.getFileSystem();
		assertSame(fs1, fs2);
	}

	//@Order(2)
	@Test
	public void getRootDirsTest() {
		FileSystem fs = FileSystem.getFileSystem();
		Directory[] actual = this.LinkedListToArray(fs.getRootDirs());
		Directory[] expected = {};
		assertArrayEquals(actual, expected);
	}

	//@Order(3)
	@Test
	public void addRootDirTest() {
		Directory root = new Directory(null, "Root", 0, this.testDate);
		FileSystem fs = FileSystem.getFileSystem();
		fs.addRootDir(root);
		LinkedList<Directory> rootsRes = fs.getRootDirs();
		Directory[] actual = this.LinkedListToArray(rootsRes);
		Directory[] expected = { root };
		assertArrayEquals(actual, expected);
	}
}