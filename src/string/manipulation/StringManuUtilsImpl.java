package string.manipulation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringManuUtilsImpl implements StringManuUtils {

    @Override
    public String reverseString(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }

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
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }

        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);

            // If the character is already in the map and within the current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1;
            }

            // Update the character's latest index
            charIndexMap.put(currentChar, i);

            // Calculate the current window length
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }

    @Override
    public String findTheLongestSubstring(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }

        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int startOfMaxSubstring = 0;

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);

            // If the character is already in the map and within the current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1;
            }

            // Update the character's latest index
            charIndexMap.put(currentChar, i);

            // Calculate the current window length and update the max substring details
            if (i - start + 1 > maxLength) {
                maxLength = i - start + 1;
                startOfMaxSubstring = start;
            }
        }

        return string.substring(startOfMaxSubstring, startOfMaxSubstring + maxLength);
    }

    @Override
    public char findFirstNonRepeatingCharacter(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }

        Map<Character, Integer> characterFrequencyMap = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            characterFrequencyMap.put(c, characterFrequencyMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : characterFrequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0'; // Null character
    }
}
