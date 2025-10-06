package module6;

import java.util.*;

// Implement merge sort for ArrayLists of Students
public class MergeSort {

    public static void mergeSort(ArrayList<Student> list, Comparator<Student> comparator) {
        if (list.size() <= 1) {
            return; // base case
        }

        int mid = list.size() / 2;
        ArrayList<Student> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(list.subList(mid, list.size()));

        // Recursive calls to split the list
        mergeSort(left, comparator);
        mergeSort(right, comparator);

        // Merge the two halves
        merge(list, left, right, comparator);
    }

    private static void merge(ArrayList<Student> list, ArrayList<Student> left,
                              ArrayList<Student> right, Comparator<Student> comparator) {
        int i = 0, j = 0, k = 0;

        // Compare and merge elements
        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        // Copy remaining elements
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
}
