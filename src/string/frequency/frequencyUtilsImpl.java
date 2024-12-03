package string.frequency;

import java.util.HashMap;
import java.util.Map;

public class frequencyUtilsImpl implements  frequencyUtils{
    @Override
    public Character highestFrequencyCharacter(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Input is empty or null");
        }

        char[] chars = s.toCharArray();

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : chars) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Determine the character with the maximum frequency
        int maxFrequency = Integer.MIN_VALUE;
        Character maxChar = null; // Should be null initially to handle edge cases

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        return maxChar;
    }
}
