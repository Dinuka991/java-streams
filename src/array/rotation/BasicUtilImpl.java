package array.rotation;

import java.util.Arrays;

public class BasicUtilImpl implements BasicUtil {

    @Override
    public int[] swapTheArrayRight(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr; // Return as is for null or empty arrays
        }

        int n = arr.length;
        k = k % n; // Handle cases where k > n

        // Step 1: Reverse the entire array
        reverseArray(arr, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverseArray(arr, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverseArray(arr, k, n - 1);

        return arr;
    }

    @Override
    public int[] swapTheArrayLeft(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr; // Return as is for null or empty arrays
        }

        int n = arr.length;
        k = k % n; // Handle cases where k > n

        // Reverse the first k elements
        reverseArray(arr, 0, k - 1);

        // Reverse the remaining n-k elements
        reverseArray(arr, k, n - 1);

        // Reverse the entire array to complete the left rotation
        reverseArray(arr, 0, n - 1);

        return arr; // Return the rotated array
    }

    public void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    @Override
    public void demo() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("Demo - Original Array: " + Arrays.toString(arr));
        int[] rotatedArray = swapTheArrayRight(arr.clone(), k);
        System.out.println("Demo - Array after Right Rotation by " + k + ": " + Arrays.toString(rotatedArray));
    }

    public static void main(String[] args) {
        BasicUtilImpl util = new BasicUtilImpl();

        // Call demo to showcase functionality
        util.demo();

        // Additional test
        int[] customArr = {8, 9, 10, 11, 12};
        int customK = 2;
        System.out.println("Custom Array Before Rotation: " + Arrays.toString(customArr));
        System.out.println("Custom Array After Right Rotation by " + customK + ": " +
                Arrays.toString(util.swapTheArrayRight(customArr, customK)));
    }
}
