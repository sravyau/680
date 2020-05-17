package edu.umb.cs680.hw10;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {

	private ApfsElement target;

	public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, ApfsElement target,
			String ownerName, LocalDateTime modifiedDate) {
		super(parent, name, size, creationTime, ownerName, modifiedDate);
		this.target = target;
	}

	public boolean isLink() {
		return true;
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return false;
	}

	public int getTargetSize() {
		return target.getSize();
	}

	public boolean targetisLink() {
		return target.isLink();
	}

	public boolean targetisFile() {
		return target.isFile();
	}

	public boolean targetisDirectory() {
		return target.isDirectory();
	}

	public void setTarget(ApfsElement target) {
		this.target = target;
	}

	public ApfsElement getTarget() {
		return this.target;
	}

	public void accept(ApfsFSVisitor v) {
		v.visit(this);
	}
}