package dp;

public class DpUtilImpl implements DpUtil {

    @Override
    public int fibonacci(int n) {
        if (n == 0) return 0; // Base case: F(0) = 0
        if (n == 1) return 1; // Base case: F(1) = 1

        int a = 0; // F(0)
        int b = 1; // F(1)
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = a + b; // Fibonacci relation
            a = b; // Move 'b' to 'a'
            b = result; // Update 'b' with the new result
        }

        return result; // Return the nth Fibonacci number
    }

    @Override
    public int houseRober(int[] arr) {
        // Step 1: Handle edge cases
        if (arr == null || arr.length == 0) {
            return 0; // No houses to rob
        }
        if (arr.length == 1) {
            return arr[0]; // Only one house to rob
        }

        // Step 2: Initialize base cases
        int prev2 = arr[0]; // Maximum money robbed up to the 1st house
        int prev1 = Math.max(arr[0], arr[1]); // Maximum money robbed up to the 2nd house

        // Step 3: Iteratively calculate the maximum money
        for (int i = 2; i < arr.length; i++) {
            int current = Math.max(prev1, prev2 + arr[i]); // Choose between robbing the current house or skipping it
            prev2 = prev1; // Update prev2 to the previous value of prev1
            prev1 = current; // Update prev1 to the current maximum
        }

        // Step 4: Return the maximum money robbed
        return prev1;
    }
}
