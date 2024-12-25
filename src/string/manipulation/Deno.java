package string.manipulation;

public class Deno {
    public static void main(String[] args) {
        StringManuUtils stringManuUtils = new StringManuUtilsImpl();

        // Test reverseString
        System.out.println("Reversed string: " + stringManuUtils.reverseString("aolaaacva"));

        // Test findLengthLongestSubstring
        System.out.println("Length of longest substring without repeating characters: " +
                stringManuUtils.findLengthLongestSubstring("vwkwkbkwweeee"));

        // Test findTheLongestSubstring
        System.out.println("The longest substring without repeating characters: " +
                stringManuUtils.findTheLongestSubstring("vwkwkbkwweeee"));

        // Test findFirstNonRepeatingCharacter
        System.out.println("First non-repeating character: " +
                stringManuUtils.findFirstNonRepeatingCharacter("swiss"));
    }
}
