package string.frequency;

import java.util.*;
import java.util.*;

public class FrequencyUtilsImpl implements FrequencyUtils {

    @Override
    public Character highestFrequencyCharacter(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Input string is empty or null");
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    @Override
    public Character firstNonRepeatingCharacter(String s) {
        if (s == null || s.isBlank()) {
            return null;
        }

        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (char c : s.trim().toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Character findTheFirstRepeativeCharacter(String a) {
        if (a == null || a.isEmpty()) {
            throw new IllegalArgumentException("The input is null or empty");
        }

        Set<Character> seenCharacters = new HashSet<>();
        for (char c : a.toCharArray()) {
            if (seenCharacters.contains(c)) {
                return c;
            }
            seenCharacters.add(c);
        }

        return null;
    }

    @Override
    public Map<String, Integer> findFrequencyOfWords(String s) {
        if (s == null || s.trim().isEmpty()) {
            return Collections.emptyMap();
        }

        String cleanedString = s.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
        String[] words = cleanedString.split("\\s+");

        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        return wordFrequencyMap;
    }

    @Override
    public boolean findUniqueFrequency(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> frequencySet = new HashSet<>(frequencyMap.values());
        return frequencyMap.size() == frequencySet.size();
    }

    @Override
    public Character findTheFirstNonRepeatingCharacter(String s) {
        // Validate the input to ensure it's not null or empty
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string must not be null or empty");
        }

        // Step 1: Use a LinkedHashMap to maintain insertion order for character frequency
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        // Step 2: Populate the frequency map
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Step 3: Find the first character with a frequency of 1
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey(); // Return the first non-repeating character
            }
        }
        // Step 4: If no non-repeating character is found, return null
        return null;
    }

    public static void main(String[] args) {
        FrequencyUtilsImpl utils = new FrequencyUtilsImpl();

        // Test Cases
        System.out.println("Highest frequency character: " + utils.highestFrequencyCharacter("abracadabra")); // a
        System.out.println("First non-repeating character: " + utils.firstNonRepeatingCharacter("abracadabra")); // c
        System.out.println("First repetitive character: " + utils.findTheFirstRepeativeCharacter("abracadabra")); // a
        System.out.println("Word frequencies: " + utils.findFrequencyOfWords("Java is awesome! Java is great.")); // {java=2, is=2, awesome=1, great=1}
        System.out.println("Unique frequencies: " + utils.findUniqueFrequency(new int[]{1, 2, 2, 3, 3, 3})); // false
    }
}
