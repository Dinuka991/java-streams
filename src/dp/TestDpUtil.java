package dp;

public class TestDpUtil {
    public static void main(String[] args) {
        DpUtil dpUtil = new DpUtilImpl();

        // Test Fibonacci
        System.out.println("Fibonacci of 5: " + dpUtil.fibonacci(5)); // Expected: 5
        System.out.println("Fibonacci of 10: " + dpUtil.fibonacci(10)); // Expected: 55

        // Test House Robber
        int[] houses1 = {2, 7, 9, 3, 1};
        System.out.println("Maximum money robbed: " + dpUtil.houseRober(houses1)); // Expected: 12

        int[] houses2 = {5, 5, 10, 100, 10, 5};
        System.out.println("Maximum money robbed: " + dpUtil.houseRober(houses2)); // Expected: 110
    }
}
