package array;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtilsImpl implements  ArrayUtils{

    // Method to find the second smallest number in an array

    public int findSecondSmallestNumber(int[] arr) {
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

    @Override
    public int[] removeTheDuplicates(int[] arr) {
            return Arrays.stream(arr) // Create an IntStream from the array
                    .distinct()   // Remove duplicate values
                    .toArray();   // Collect the results into an int[]
        }
    }


