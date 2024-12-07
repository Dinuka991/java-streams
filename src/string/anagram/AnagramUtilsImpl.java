package string.anagram;

import java.util.Arrays;
import java.util.HashMap;

public class AnagramUtilsImpl implements AnagramUtils {

    // Check if two strings are anagrams using sorting
    @Override
    public boolean isAnagrams(String string1, String string2) {
        // Handle null inputs
        if (string1 == null || string2 == null) {
            return false;
        }

        // Trim and convert to lowercase for consistent comparison
        string1 = string1.trim().toLowerCase();
        string2 = string2.trim().toLowerCase();

        // Check lengths; if not equal, they can't be anagrams
        if (string1.length() != string2.length()) {
            return false;
        }

        // Convert strings to character arrays and sort them
        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }

    // Check if two strings are anagrams using frequency counting (optimized way)
    @Override
    public boolean isAnagramsOpt(String string1, String string2) {
        // Handle null inputs
        if (string1 == null || string2 == null) {
            return false;
        }

        // Trim and convert to lowercase for consistent comparison
        string1 = string1.trim().toLowerCase();
        string2 = string2.trim().toLowerCase();

        // Check lengths; if not equal, they can't be anagrams
        if (string1.length() != string2.length()) {
            return false;
        }

        // Create a frequency map for characters in the first string
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for (char c : string1.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Decrement frequency for characters in the second string
        for (char c : string2.toCharArray()) {
            if (!charFrequency.containsKey(c)) {
                return false; // Character not found
            }

            charFrequency.put(c, charFrequency.get(c) - 1);
            if (charFrequency.get(c) == 0) {
                charFrequency.remove(c); // Remove character when count reaches 0
            }
        }

        // If the map is empty, the strings are anagrams
        return charFrequency.isEmpty();
    }

    public static void main(String[] args) {
        AnagramUtilsImpl anagramUtils = new AnagramUtilsImpl();

        // Test cases
        System.out.println("Using Sorting:");
        System.out.println("Are 'listen' and 'silent' anagrams? " + anagramUtils.isAnagrams("listen", "silent")); // true
        System.out.println("Are 'triangle' and 'integral' anagrams? " + anagramUtils.isAnagrams("triangle", "integral")); // true
        System.out.println("Are 'apple' and 'pale' anagrams? " + anagramUtils.isAnagrams("apple", "pale")); // false
        System.out.println("Are null inputs anagrams? " + anagramUtils.isAnagrams(null, null)); // false
        System.out.println("Are empty strings anagrams? " + anagramUtils.isAnagrams("", "")); // true

        System.out.println("\nUsing Frequency Counting:");
        System.out.println("Are 'listen' and 'silent' anagrams? " + anagramUtils.isAnagramsOpt("listen", "silent")); // true
        System.out.println("Are 'triangle' and 'integral' anagrams? " + anagramUtils.isAnagramsOpt("triangle", "integral")); // true
        System.out.println("Are 'apple' and 'pale' anagrams? " + anagramUtils.isAnagramsOpt("apple", "pale")); // false
        System.out.println("Are null inputs anagrams? " + anagramUtils.isAnagramsOpt(null, null)); // false
        System.out.println("Are empty strings anagrams? " + anagramUtils.isAnagramsOpt("", "")); // true
    }
}
