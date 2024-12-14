package array.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BasicUtilImpl implements BasicUtil {

    @Override
    public int findMax(int[] arr) {
        // Handle null or empty array case
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int max = Integer.MIN_VALUE;

        // Iterate through the array to find the maximum value
        for (int val : arr) {
            if (max < val) {
                max = val;
            }
        }

        return max;
    }

    @Override
    public int[] removeTheDuplicates(int[] arr) {

        Set<Integer> uniqueSet = new HashSet<>();

        for (int a : arr) {
            uniqueSet.add(a);
        }
        return uniqueSet.stream().mapToInt(Integer::intValue).toArray();
    }

}
