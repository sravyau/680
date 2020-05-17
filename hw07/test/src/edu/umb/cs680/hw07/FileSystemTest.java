package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystemTest {

	private LocalDateTime date1 = LocalDateTime.now();

	private Directory[] LinkedListToArray(LinkedList<Directory> rootList) {
		Directory[] rootArray = new Directory[rootList.size()];
		int i = 0;
		for (Directory root : rootList) {
			rootArray[i++] = root;
		}
		return rootArray;
	}

	@Test
	public void sameFileSystemTest() {
		FileSystem fs1 = FileSystem.getFileSystem();
		FileSystem fs2 = FileSystem.getFileSystem();
		assertSame(fs1, fs2);
	}

	@Test
	public void getRootDirsTest() {
		FileSystem fs = FileSystem.getFileSystem();
		Directory[] actual = this.LinkedListToArray(fs.getRootDirs());
		Directory[] expected = {};
		assertArrayEquals(expected, actual);
	}

	@Test
	public void addRootDirTest() {
		Directory root = new Directory(null, "Root", 0, this.date1);
		FileSystem fs = FileSystem.getFileSystem();
		fs.addRootDir(root);
		LinkedList<Directory> rootsRes = fs.getRootDirs();
		Directory[] actual = this.LinkedListToArray(rootsRes);
		Directory[] expected = { root };
		assertArrayEquals(actual, expected);
	}
}