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
