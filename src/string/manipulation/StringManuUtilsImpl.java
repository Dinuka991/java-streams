package string.manipulation;

public class StringManuUtilsImpl implements StringManuUtils {

    @Override
    public String reverseString(String string) {
        int length = string.length();
        char[] arr = string.toCharArray();
        char[] reverse = new char[length];

        for (int i = 0; i < length; i++) {
            reverse[i] = arr[length - 1 - i];
        }
        return new String(reverse);
    }

    @Override
    public int findLengthLongestSubstring(String string) {
        // Step 1: Input validation
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Input string is invalid!");
        }

        // Step 2: Initialize variables
        int current = 1; // Length of the current substring (at least one character)
        int max = 1; // Minimum maximum length for non-empty strings

        // Step 3: Traverse the string
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i - 1)) {
                current++; // Increment current length if characters match
            } else {
                max = Math.max(max, current); // Update max length
                current = 1; // Reset current length for a new substring
            }
        }

        // Step 4: Final check after the loop
        max = Math.max(max, current);

        return max;
    }

    @Override
    public String findTheLongestSubstring(String string) {
        // Step 1: Input validation
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Input string is invalid");
        }

        // Step 2: Initialize variables
        int current = 1; // Current substring length (start with 1 for first character)
        int max = 0; // Max length found
        int startOfMax = 0; // Start index of the longest substring
        int startOfCurrent = 0; // Start index of the current substring

        // Step 3: Traverse the string
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i - 1)) {
                current++; // Increment current length if characters match
            } else {
                // Update the max substring details if the current is longer
                if (current > max) {
                    max = current;
                    startOfMax = startOfCurrent;
                }
                // Reset current length and update start index
                current = 1;
                startOfCurrent = i;
            }
        }

        // Step 4: Final check after the loop
        if (current > max) {
            max = current;
            startOfMax = startOfCurrent;
        }

        // Step 5: Return the longest substring
        return string.substring(startOfMax, startOfMax + max);
    }
}
