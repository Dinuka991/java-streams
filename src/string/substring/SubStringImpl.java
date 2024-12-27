package string.substring;

/**
 * Implementation of the SubString interface for finding substrings.
 */
public class SubStringImpl implements SubString {

    /**
     * Finds the longest substring of identical characters in the given string.
     *
     * @param str the input string
     * @return the longest substring consisting of identical characters
     * @throws IllegalArgumentException if the input string is null or empty
     */
    @Override
    public String findTheLongestSubstringOfIdenticalCharacters(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("The input string must not be null or empty.");
        }

        int maxLength = 1; // Maximum length of identical characters substring
        int currentLength = 1; // Current length of identical characters substring
        int startIndex = 0; // Starting index of the longest substring
        int tempStartIndex = 0; // Temporary start index for the current sequence

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                currentLength++;

                // Update the maximum length and starting index if a longer substring is found
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndex = tempStartIndex;
                }
            } else {
                currentLength = 1; // Reset the current length
                tempStartIndex = i; // Update the temporary starting index
            }
        }

        // Return the longest substring of identical characters
        return str.substring(startIndex, startIndex + maxLength);
    }


        public static void main(String[] args) {
            SubString subString = new SubStringImpl();

            // Example inputs
            String input1 = "aaabbccccdee";
            String input2 = "abcdef";
            String input3 = "aaaaa";

            // Finding and printing the longest substrings
            System.out.println("Input: " + input1 + " -> Longest substring: " + subString.findTheLongestSubstringOfIdenticalCharacters(input1));
            System.out.println("Input: " + input2 + " -> Longest substring: " + subString.findTheLongestSubstringOfIdenticalCharacters(input2));
            System.out.println("Input: " + input3 + " -> Longest substring: " + subString.findTheLongestSubstringOfIdenticalCharacters(input3));
        }

}
