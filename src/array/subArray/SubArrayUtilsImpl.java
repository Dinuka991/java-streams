package array.subArray;

import java.util.Arrays;

public class SubArrayUtilsImpl implements SubArrayUtils {

    @Override
    public int[] findTheSubArrayWithGivenSum(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) { // Fixed the loop condition
                if (arr[i] + arr[j] == sum) { // Check for subarray sum
                    return new int[]{arr[i], arr[j]};
                }
            }
        }
        return new int[0]; // Return empty array if no subarray is found
    }

    @Override
    public void splitArrayByEqualSum(int[] arr) {
        int sum = 0;
        int sum2 = 0;
        int pointer = -1;

        // Calculate the total sum of the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // Check if the total sum is odd, in which case splitting into equal sums is impossible
        if (sum % 2 != 0) {
            throw new ArithmeticException("Array cannot be split into two equal sums as the total sum is odd.");
        }

        int targetSum = sum / 2;

        // Find the index where the array can be split
        for (int j = 0; j < arr.length; j++) {
            sum2 += arr[j];
            if (sum2 == targetSum) {
                pointer = j;
                break;
            }
        }

        // If pointer is not updated, splitting is not possible
        if (pointer == -1) {
            throw new ArithmeticException("Array cannot be split into two equal sums.");
        }

        // Split the array into two subarrays
        int[] arr1 = Arrays.copyOfRange(arr, 0, pointer + 1);
        int[] arr2 = Arrays.copyOfRange(arr, pointer + 1, arr.length);

        // Output the results
        System.out.println("First Subarray: " + Arrays.toString(arr1));
        System.out.println("Second Subarray: " + Arrays.toString(arr2));


    }

    @Override
    public void demo(int args) {
        // Call the default implementation from the interface
        SubArrayUtils.super.demo(args);
    }

    public static void main(String[] args) {
        SubArrayUtils utils = new SubArrayUtilsImpl();
        System.out.println("Result: " + Arrays.toString(utils.findTheSubArrayWithGivenSum(new int[]{1, 3, 2, 5}, 4)));
        // You can also call demo directly
        utils.demo(4);
    }
}
