package array;

import java.util.stream.IntStream;

public class ArrayUtilsImpl implements ArrayUtils {

    // Method to find the second smallest number in an array
    @Override
    public int findSecondSmallestNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int smallestNumber = Integer.MAX_VALUE;
        int secondSmallestNumber = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallestNumber) {
                secondSmallestNumber = smallestNumber;
                smallestNumber = num;
            } else if (num < secondSmallestNumber && num != smallestNumber) {
                secondSmallestNumber = num;
            }
        }

        if (secondSmallestNumber == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("No second smallest number found (all elements may be equal).");
        }

        return secondSmallestNumber;
    }

    // Method to remove duplicates from an array
    @Override
    public int[] removeTheDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0]; // Return an empty array for null or empty input
        }

        return IntStream.of(arr) // Create an IntStream from the array
                .distinct()      // Remove duplicate values
                .toArray();      // Collect the results into an int[]
    }

    // Method to sort an array using Bubble Sort
    @Override
    public int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0]; // Return an empty array for null or empty input
        }

        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the last iteration, the array is sorted
            if (!swapped) {
                break;
            }
        }

        return arr;
    }
}
