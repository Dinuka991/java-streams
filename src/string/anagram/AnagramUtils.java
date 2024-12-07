package string.anagram;

public interface AnagramUtils {

    // Check if two strings are anagrams using sorting
    boolean isAnagrams(String string1, String string2);

    // Check if two strings are anagrams using frequency counting (optimized way)
    boolean isAnagramsOpt(String string1, String string2);
}
