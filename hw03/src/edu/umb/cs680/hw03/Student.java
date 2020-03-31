package edu.umb.cs680.hw03;

enum StudentStatus {
	INSTATE, OUTSTATE, INTL
}

public class Student {

	private float tuitionfee;
	private String name, usAddress, foreignAddress;
	private int i20number, yrsInState;
	private StudentStatus status;

	private Student(String name, String usAddress, String foreignAddress, int i20number, int yrsInState, StudentStatus status) {
		this.name = name;
		this.usAddress = usAddress;
		this.foreignAddress = foreignAddress;
		this.i20number = i20number;
		this.yrsInState = yrsInState;
		this.status = status;
	}

	public static Student createInStateStudent(String name, String usAddress) {
		return new Student(name, usAddress, null, 2, 2, StudentStatus.INSTATE);
	}

	public static Student createOutStateStudent(String name, String usAddress, int yrsInState) {
		return new Student(name, usAddress, null, 2, yrsInState, StudentStatus.OUTSTATE);
	}

	public static Student createIntlStudent(String name, String usAddress, int i20number, String foreignAddress) {
		return new Student(name, usAddress, foreignAddress, i20number, 2, StudentStatus.INTL);
	}

	public float getTuition() {
		if (this.status == StudentStatus.INSTATE)
			return 5000;
		if (this.status == StudentStatus.OUTSTATE)
			return 12000;
		else
			return 20000;

	}

	public StudentStatus getStatus() {
		return this.status;
	}

	public static void main(String[] args) {

		Student intlStudent = createIntlStudent("John", "Boston", 120, "UK");
		System.out.println("Student Status is: " + intlStudent.getStatus() + " and Student tuition is: "
				+ intlStudent.getTuition());

	}

}
