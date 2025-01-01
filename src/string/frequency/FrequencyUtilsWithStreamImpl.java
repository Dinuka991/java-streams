package string.frequency;

import java.util.HashSet;
import java.util.Set;

public class FrequencyUtilsWithStreamImpl implements FrequencyUtilsWithStream {

    @Override
    public Character findTheFirstRepeativeCharacter(String a) {
        // Validate input to handle null or empty strings
        if (a == null || a.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        // Set to track characters that have already been seen
        Set<Character> seen = new HashSet<>();

        // Use Stream API to find the first repeated character
        return a.chars() // Convert the string to an IntStream of characters
                .mapToObj(c -> (char) c) // Convert each int to its corresponding char
                .filter(c -> !seen.add(c)) // Filter out the first character that is already in the set
                .findFirst() // Get the first matched character
                .orElse(null); // Return null if no repeated character is found
    }

    @Override
    public Character findTheNoneRepeativeCharacter(String a) {

        if(a == null || a.isEmpty()){
            throw  new IllegalArgumentException("Input string cannot be null or empty");
        }

        //

        return null;
    }
}
