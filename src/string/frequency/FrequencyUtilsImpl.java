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

        // Convert string to a character array
        char[] chars = s.toCharArray();

        // Map to store character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map
        for (char c : chars) {
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

    public static void main(String[] args) {
        FrequencyUtilsImpl utils = new FrequencyUtilsImpl();

        // Test cases
        System.out.println("Highest frequency character in 'hello': " + utils.highestFrequencyCharacter("hello")); // l
        System.out.println("Highest frequency character in 'abracadabra': " + utils.highestFrequencyCharacter("abracadabra")); // a
        System.out.println("Highest frequency character in 'aaaaaa': " + utils.highestFrequencyCharacter("aaaaaa")); // a
        try {
            System.out.println("Highest frequency character in null: " + utils.highestFrequencyCharacter(null)); // Exception
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        try {
            System.out.println("Highest frequency character in '  ': " + utils.highestFrequencyCharacter("  ")); // Exception
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
