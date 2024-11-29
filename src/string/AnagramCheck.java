package string;

import java.util.Arrays;

public class AnagramCheck {

    public static void main(String[] args) {

        String str1 = "hello";
        String str2 = "lleh";

        System.out.println(anagram(str1, str2));
    }

    public static boolean anagram(String str1, String str2) {
        // Check if either string is null or their lengths do not match
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted arrays
        return Arrays.equals(arr1, arr2);
    }
}
