package array;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {



        ArrayUtils arrayUtils = new ArrayUtilsImpl();
       // System.out.println(arrayUtils.findSecondSmallestNumber(new int[] {1, 2, 4, 5, 6, 7}));


        // Find sorted array
        System.out.println(Arrays.toString(arrayUtils.bubbleSort(new int[]{1, 6, 4, 6, 39, 3})));
    }
}
