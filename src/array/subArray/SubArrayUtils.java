package array.subArray;

import java.util.Arrays;

public interface SubArrayUtils {
    int[] findTheSubArrayWithGivenSum(int[] arr, int sum);

    void splitArrayByEqualSum(int[] arr);



    default void demo(int args) {
        System.out.println(Arrays.toString(findTheSubArrayWithGivenSum(new int[]{1, 3, 2, 5}, args)));
    }
}
