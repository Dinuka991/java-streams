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
}
