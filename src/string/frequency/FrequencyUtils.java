package string.frequency;

import java.util.Map;

public interface FrequencyUtils {
    // Method to find the character with the highest frequency in a string
    Character highestFrequencyCharacter(String s);

    Character firstNonRepeatingCharacter(String s);

    Map<String,Integer> findFrequencyOfWords(String s);
}
