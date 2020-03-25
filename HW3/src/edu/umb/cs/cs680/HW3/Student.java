package edu.umb.cs.cs680.HW3;

enum StudentStatus {
	INSTATE, OUTSTATE, INTL
}

public class Student {

	private float tuition;
	private String name, usAddr, foreignAddr;
	private int i20num, yrsInState;
	private StudentStatus status;

	private Student(String name, String usAddr, String foreignAddr, int i20num, int yrsInState, StudentStatus status) {
		this.name = name;
		this.usAddr = usAddr;
		this.foreignAddr = foreignAddr;
		this.i20num = i20num;
		this.yrsInState = yrsInState;
		this.status = status;
	}

	public static Student createinStateStudent(String name, String usAddr) {
		return new Student(name, usAddr, null, -1, -1, StudentStatus.INSTATE);
	}

	public static Student createOutStateStudent(String name, String usAddr, int yrsInState) {
		return new Student(name, usAddr, null, -1, yrsInState, StudentStatus.OUTSTATE);
	}

	public static Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr) {
		return new Student(name, usAddr, foreignAddr, i20num, -1, StudentStatus.INTL);
	}

	public float getTuition() {
		if (this.status == StudentStatus.INSTATE)
			return 7000;
		if (this.status == StudentStatus.OUTSTATE)
			return 10000;
		else
			return 15000;

	}

	public StudentStatus getStatus() {
		return this.status;
	}

	public static void main(String[] args) {

		Student intlStudent = createIntlStudent("John", "Boston", 100, "England");
		System.out.println("Student Status is: " + intlStudent.getStatus() + " and Student tuition is: "
				+ intlStudent.getTuition());

	}

}