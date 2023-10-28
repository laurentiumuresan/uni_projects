package isp.lab2.Exercise5EvenOddSearch;

import java.util.Scanner;

public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(int[] integers) {

        int largestEven = -1;
        int largestEvenPosition = -1;
        int smallestOdd = -1;
        int smallestOddPosition = -1;

        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 2 == 0 && integers[i] > largestEven) {
                largestEven = integers[i];
                largestEvenPosition = i;
            } else if (integers[i] % 2 == 1 && (smallestOdd == -1 || integers[i] < smallestOdd)) {
                smallestOdd = integers[i];
                smallestOddPosition = i;
            }
        }

        int[] result = {largestEven, largestEvenPosition, smallestOdd, smallestOddPosition};
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read in list of integers separated by commas
        System.out.print("Enter list of integers separated by commas: ");
        String input = scanner.nextLine();

        // Split input string into array of integers
        String[] integerStrings = input.split(",");
        int[] integers = new int[integerStrings.length];
        for (int i = 0; i < integerStrings.length; i++) {
            integers[i] = Integer.parseInt(integerStrings[i]);
        }

        // Call findEvenOdd method to find largest even and smallest odd numbers
        int[] result = findEvenOdd(integers);

        // Display results
        if (result[0] == -1) {
            System.out.println("No even numbers in the list");
        } else {
            System.out.println("Largest even number: " + result[0] + " at position " + result[1]);
        }

        if (result[2] == -1) {
            System.out.println("No odd numbers in the list");
        } else {
            System.out.println("Smallest odd number: " + result[2] + " at position " + result[3]);
        }
    }
        }

