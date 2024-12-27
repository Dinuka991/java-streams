package string.substring;

/**
 * Interface for finding substrings in a given string.
 */
public interface SubString {

    /**
     * Finds the longest substring of identical characters in the given string.
     *
     * @param str the input string
     * @return the longest substring consisting of identical characters
     * @throws IllegalArgumentException if the input string is null or empty
     */
    String findTheLongestSubstringOfIdenticalCharacters(String str);
}
