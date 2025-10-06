package module8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentLinkedListApp {

	// Constants for GPA validation and output file name
	private static final double MIN_GPA = 0.0;
	private static final double MAX_GPA = 4.0;
	private static final String OUTPUT_FILE = "students.txt";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> students = new LinkedList<>();

		System.out.println("=== Student Data Entry ===");
		boolean keepGoing = true;

		// Loop to collect user input for multiple students
		while (keepGoing) {
			String name = promptNonEmpty(sc, "Enter student name: ");
			String address = promptNonEmpty(sc, "Enter student address: ");
			double gpa = promptValidGpa(sc, "Enter GPA (0.0 - 4.0): ");

			// Create Student object and add to list
			students.add(new Student(name, address, gpa));

			System.out.print("Add another student? (y/n): ");
			String answer = sc.nextLine().trim();
			keepGoing = answer.equalsIgnoreCase("y");
		}

		// Sort students by name using comparator
		Collections.sort(students, new StudentNameComparator());

		// Write sorted list to a text file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
			writer.write("=== Students (sorted by name) ===");
			writer.newLine();
			for (Student s : students) {
				writer.write(s.toString());
				writer.newLine();
			}
			System.out.println("\nSaved " + students.size() + " students to file: " + OUTPUT_FILE);
		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}

		sc.close();
		System.out.println("Done.");
	}

	// Helper method to get non-empty input
	private static String promptNonEmpty(Scanner sc, String message) {
		while (true) {
			System.out.print(message);
			String input = sc.nextLine().trim();
			if (!input.isEmpty())
				return input;
			System.out.println("Input cannot be empty. Try again.");
		}
	}

	// Helper method to validate GPA input
	private static double promptValidGpa(Scanner sc, String message) {
		while (true) {
			System.out.print(message);
			String input = sc.nextLine().trim();
			try {
				double value = Double.parseDouble(input);
				if (value >= MIN_GPA && value <= MAX_GPA)
					return value;
				System.out.println("GPA must be between " + MIN_GPA + " and " + MAX_GPA + ".");
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number for GPA.");
			}
		}
	}
}
