package array;


public class ArrayUtils {

    // Method to find the second smallest number in an array
    public static int findSecondSmallestNumber(int[] arr) {
        int smallestNumber = Integer.MAX_VALUE;
        int secondSmallestNumber = Integer.MAX_VALUE;

        // Find the smallest number
        for (int num : arr) {
            if (smallestNumber > num) {
                smallestNumber = num;
            }
        }

        // Find the second smallest number
        for (int num : arr) {
            if (secondSmallestNumber > num && num > smallestNumber) {
                secondSmallestNumber = num;
            }
        }

        return secondSmallestNumber;
    }
}
