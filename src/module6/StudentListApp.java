package module6;

import java.util.ArrayList;

public class StudentListApp {
    public static void main(String[] args) {
        // ArrayList to store students
        ArrayList<Student> students = new ArrayList<>();

        // Add 10 students
        students.add(new Student(104, "Maria Lopez", "Denver"));
        students.add(new Student(102, "James Smith", "Aurora"));
        students.add(new Student(110, "Lily Nguyen", "Boulder"));
        students.add(new Student(107, "Carlos Ramirez", "Littleton"));
        students.add(new Student(101, "Emily Johnson", "Fort Collins"));
        students.add(new Student(109, "Ethan Brown", "Pueblo"));
        students.add(new Student(105, "Olivia Wilson", "Greeley"));
        students.add(new Student(106, "Mason Clark", "Lakewood"));
        students.add(new Student(103, "Sophia Martinez", "Colorado Springs"));
        students.add(new Student(108, "Daniel Anderson", "Golden"));

        // Print before sorting
        System.out.println("Before Sorting:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort using merge sort
        MergeSort.mergeSort(students, new StudentComparator());

        // Print after sorting
        System.out.println("\nAfter Sorting by Roll Number:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
