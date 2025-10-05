package module5;

import java.util.Scanner;

public class RecursiveSum {

    // Recursive method to find the sum of numbers in an array
    public static int sumRecursive(int[] numbers, int index) {
        // Base case: when the end of the array is reached
        if (index == numbers.length) {
            return 0;
        }
        // Recursive case: add current number to the sum of the rest
        return numbers[index] + sumRecursive(numbers, index + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];  
        System.out.println("Enter five numbers:");

        // Loop to collect input
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // Call the recursive method starting at index 0
        int total = sumRecursive(numbers, 0);

        // Display the result
        System.out.println("\nThe sum of all five numbers is: " + total);

        input.close();
    }
}
