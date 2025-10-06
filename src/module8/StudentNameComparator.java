package module8;

import java.util.Comparator;

// Sorts students by name (ascending and case-insensitive)
public class StudentNameComparator implements Comparator<Student> {
	@Override
	public int compare(Student a, Student b) {
		return a.getName().compareToIgnoreCase(b.getName());
	}
}
