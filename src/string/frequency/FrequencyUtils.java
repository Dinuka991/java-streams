package string.frequency;

import java.util.Map;

public interface FrequencyUtils {
    Character highestFrequencyCharacter(String s);
    Character firstNonRepeatingCharacter(String s);
    Character findTheFirstRepeativeCharacter(String a);
    Map<String, Integer> findFrequencyOfWords(String s);
    boolean findUniqueFrequency(int[] arr);
    Character findTheFirstNonRepeatingCharacter(String s);

}
