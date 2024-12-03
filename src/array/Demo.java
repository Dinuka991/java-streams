package array;

public class Demo {

    public static void main(String[] args) {

        ArrayUtils arrayUtils = new ArrayUtilsImpl();
        System.out.println(arrayUtils.findSecondSmallestNumber(new int[] {1, 2, 4, 5, 6, 7}));
    }
}
