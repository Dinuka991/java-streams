package array.subArray;

import java.util.Arrays;

public interface SubArrayUtils {
    int[] findTheSubArrayWithGivenSum(int[] arr, int sum);

    void splitArrayByEqualSum(int[] arr);

    void findTheSubArrayWithGivenSum(int arr[] , double target);



    default void demo(int args) {
        System.out.println(Arrays.toString(findTheSubArrayWithGivenSum(new int[]{1, 3, 2, 5}, args)));
        splitArrayByEqualSum(new int[] {1,5,6,2,6,4});
    }
}
