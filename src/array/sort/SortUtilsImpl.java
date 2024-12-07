package array.sort;

import java.util.Arrays;

public class SortUtilsImpl implements SortUtils {

    @Override
    public int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr; // Return the array as it is for null or single-element arrays
        }

        boolean swapped;

        // Outer loop for each pass
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false; // Reset swap flag for the current pass

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < arr.length - i - 1; j++) { // Adjusted loop condition
                if (arr[j] > arr[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // A swap occurred
                }
            }

            // If no swaps occurred in this pass, the array is sorted
            if (!swapped) {
                break;
            }
        }

        return arr; // Return the sorted array
    }

    @Override
    public void demo() {
        // Example array for sorting demonstration
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Demo: Original Array: " + Arrays.toString(arr));
        int[] sortedArr = bubbleSort(arr);
        System.out.println("Demo: Sorted Array: " + Arrays.toString(sortedArr));
    }

    public static void main(String[] args) {
        SortUtilsImpl sortUtils = new SortUtilsImpl();

        // Call demo method to demonstrate bubble sort
        sortUtils.demo();

        // Additional test
        int[] customArr = {5, 1, 4, 2, 8};
        System.out.println("Custom Array Before Sort: " + Arrays.toString(customArr));
        System.out.println("Custom Array After Sort: " + Arrays.toString(sortUtils.bubbleSort(customArr)));
    }
}
