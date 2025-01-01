package string.frequency;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FrequencyUtilsWithStreamImpl implements FrequencyUtilsWithStream {

    @Override
    public Character findTheFirstRepeatingCharacter(String input) {
        // Validate input to handle null or empty strings
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        // Set to track characters that have already been seen
        Set<Character> seen = new HashSet<>();

        // Use Stream API to find the first repeated character
        return input.chars()
                .mapToObj(c -> (char) c) // Convert IntStream to Stream<Character>
                .filter(c -> !seen.add(c)) // Filter the first character already in the set
                .findFirst() // Return the first matched character
                .orElse(null); // Return null if no repeated character is found
    }

    @Override
    public Character findTheFirstNonRepeatingCharacter(String input) {
        // Validate input to handle null or empty strings
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string must not be null or empty");
        }

        // Step 1: Create a frequency map using Streams
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c) // Convert IntStream to Stream<Character>
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));

        // Step 2: Find the first character with a frequency of 1
        return frequencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1) // Filter non-repeating characters
                .map(Map.Entry::getKey) // Extract the character key
                .findFirst() // Return the first match
                .orElse(null); // Return null if no match is found
    }
}
