package string.frequency;

import java.util.HashMap;
import java.util.Map;

public class FrequencyUtilsImpl implements FrequencyUtils {

    @Override
    public Character highestFrequencyCharacter(String s) {
        // Handle null or empty input
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Input string is empty or null");
        }

        // Map to store character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Determine the character with the highest frequency
        int maxFrequency = 0;
        Character maxChar = null;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        return maxChar;
    }

    public Character firstNonRepeatingCharacter(String s) {
        if (s == null || s.isBlank()) {
            return null; // Handle null or blank input
        }

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map
        for (char c : s.trim().toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Find the first character with a frequency of 1
        for (char c : s.trim().toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                return c; // Return the first non-repeating character
            }
        }

        return null; // No non-repeating character found
    }

    @Override
    public Map<String, Integer> findFrequencyOfWords(String s) {
        // Check for null or empty input
        if (s == null || s.trim().isEmpty()) {
            return new HashMap<>(); // Return an empty map
        }

        // Normalize the string: Convert to lowercase and remove punctuation
        String cleanedString = s.toLowerCase().replaceAll("[^a-z0-9\\s]", "");

        // Split the string into words
        String[] words = cleanedString.split("\\s+");

        // Create a map to store word frequencies
        Map<String, Integer> wordMap = new HashMap<>();

        // Iterate over the words and calculate frequencies
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        return wordMap;
    }

    public static void main(String[] args) {
        FrequencyUtilsImpl utils = new FrequencyUtilsImpl();

        // Demo: Test cases for both methods
        System.out.println("Highest frequency character: " + utils.highestFrequencyCharacter("abracadabra")); // a
        System.out.println("First non-repeating character: " + utils.firstNonRepeatingCharacter("abracadabra")); // c
    }
}
