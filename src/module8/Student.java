package module8;

// Student's record
public class Student {
	private String name;
	private String address;
	private double gpa;

	// Constructor
	public Student(String name, String address, double gpa) {
		this.name = name;
		this.address = address;
		this.gpa = gpa;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public double getGpa() {
		return gpa;
	}

	// Format for text file output
	@Override
	public String toString() {
		return String.format("Name: %s | Address: %s | GPA: %.2f", name, address, gpa);
	}
}
