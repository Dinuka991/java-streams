package array.sort;

import java.util.Arrays;

public interface SortUtils {

    int[] bubbleSort(int[] arr);

    int findTheSecondLargest(int[] arr);

    // Default demo method to showcase bubbleSort functionality
    default void demo() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Sorted Array: " + Arrays.toString(bubbleSort(arr)));
    }
}
