package array.rotation;

import java.util.Arrays;

public interface BasicUtil {
    int[] swapTheArrayRight(int[] arr, int k);

    int[]  swapTheArrayLeft(int[] arr, int k);

    default void demo() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Array after Right Rotation by " + k + ": " + Arrays.toString(swapTheArrayRight(arr, k)));
    }
}
