package array.subArray;

import java.util.Arrays;

public class SubArrayUtilsImpl implements SubArrayUtils {

    // Finds two elements in the array whose sum equals the given sum
    @Override
    public int[] findTheSubArrayWithGivenSum(int[] arr, int sum) {
        if (arr == null || arr.length < 2) return new int[0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return new int[]{arr[i], arr[j]};
                }
            }
        }
        return new int[0]; // Return empty array if no subarray is found
    }

    // Splits the array into two subarrays with equal sums, if possible
    @Override
    public void splitArrayByEqualSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Array is too small to split.");
            return;
        }

        int totalSum = Arrays.stream(arr).sum(); // Calculate total sum of the array
        if (totalSum % 2 != 0) {
            throw new ArithmeticException("Array cannot be split into two equal sums as the total sum is odd.");
        }

        int targetSum = totalSum / 2;
        int runningSum = 0;
        int pointer = -1;

        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            if (runningSum == targetSum) {
                pointer = i;
                break;
            }
        }

        if (pointer == -1) {
            throw new ArithmeticException("Array cannot be split into two equal sums.");
        }

        // Split the array into two subarrays
        int[] arr1 = Arrays.copyOfRange(arr, 0, pointer + 1);
        int[] arr2 = Arrays.copyOfRange(arr, pointer + 1, arr.length);

        System.out.println("First Subarray: " + Arrays.toString(arr1));
        System.out.println("Second Subarray: " + Arrays.toString(arr2));
    }

    // Finds a subarray from the start of the array that sums to the target
    @Override
    public void findTheSubArrayWithGivenSum(int[] arr, double target) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null.");
            return;
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == target) {
                int[] subArray = Arrays.copyOfRange(arr, 0, i + 1);
                System.out.println("Subarray with the given sum: " + Arrays.toString(subArray));
                return;
            }
        }

        System.out.println("No subarray with the given sum found.");
    }

    @Override
    public void findTheMaximumSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null.");
            return;
        }

        int globalSum = arr[0];
        int localSum = arr[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (localSum + arr[i] > arr[i]) {
                localSum += arr[i];
            } else {
                localSum = arr[i];
                tempStart = i;
            }

            if (localSum > globalSum) {
                globalSum = localSum;
                start = tempStart;
                end = i;
            }
        }

        int[] newArr = Arrays.copyOfRange(arr, start, end + 1);

        System.out.println("Maximum Subarray Sum: " + globalSum);
        System.out.println("Maximum Subarray: " + Arrays.toString(newArr));
    }

    public static void main(String[] args) {
        SubArrayUtils utils = new SubArrayUtilsImpl();

        // Test findTheSubArrayWithGivenSum (two-element subarray)
        System.out.println("Two-element Subarray Result: " + Arrays.toString(utils.findTheSubArrayWithGivenSum(new int[]{1, 3, 2, 5}, 4)));

        // Test splitArrayByEqualSum
        try {
            utils.splitArrayByEqualSum(new int[]{1, 2, 3, 4, 6});
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        // Test findTheSubArrayWithGivenSum (continuous subarray)
        utils.findTheSubArrayWithGivenSum(new int[]{1, 2, 3, 7, 5}, 10);

        // Test findTheMaximumSubArray
        utils.findTheMaximumSubArray(new int[]{1, -2, 3, 4, -1, 2, 1, -5, 4});

        // Test demo method
        utils.demo(4);
    }
}
