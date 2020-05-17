package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

	private LinkedList<FSElement> children = new LinkedList<FSElement>();
	private LinkedList<File> files = new LinkedList<File>();
	private LinkedList<Directory> subdir = new LinkedList<Directory>();

	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, 0, creationTime);
	}

	public LinkedList<FSElement> getChildren() {
		return this.children;
	}

	public void appendChild(FSElement child) {
		this.children.add(child);
		child.setParent(this);
	}

	public int countChildren() {
		return this.children.size();
	}

	public boolean isDirectory() {
		return true;
	}

	public boolean isFile() {
		return false;
	}

	public boolean isLink() {
		return false;
	}

	public LinkedList<File> getFiles() {
		for (FSElement element : children) {
			if (element.isFile()) {
				files.add((File) element);
			}
		}
		return files;
	}

	public LinkedList<Directory> getSubDirectories() {
		for (FSElement element : children) {
			if (element.isDirectory()) {
				subdir.add((Directory) element);
			}
		}
		return subdir;
	}

	public int getTotalSize() {
		int totalSize = 0;
		for (FSElement element : children) {
			if (element.isDirectory()) {
				totalSize += ((Directory) element).getTotalSize();
			} else {
				totalSize += element.getSize();
			}
		}
		return totalSize;
	}
}
