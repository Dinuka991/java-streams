package string.palindrome;

public class PalindromeUtilsImpl implements PalindromeUtils {

    @Override
    public boolean isPalindrome(String string) {
        // Handle null input
        if (string == null) {
            return false;
        }

        // Sanitize the string: trim and convert to lowercase
        String sanitizedString = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();


        // Use two pointers to check for palindrome
        int i = 0;
        int j = sanitizedString.length() - 1;

        while (i < j) {
            if (sanitizedString.charAt(i) != sanitizedString.charAt(j)) {
                return false; // Mismatch found, not a palindrome
            }
            i++;
            j--;
        }

        return true; // All characters match, it's a palindrome
    }

    public static void main(String[] args) {
        PalindromeUtilsImpl palindromeUtils = new PalindromeUtilsImpl();

        // Test cases
        System.out.println("Is 'madam' a palindrome? " + palindromeUtils.isPalindrome("madam")); // true
        System.out.println("Is 'racecar' a palindrome? " + palindromeUtils.isPalindrome("racecar")); // true
        System.out.println("Is 'hello' a palindrome? " + palindromeUtils.isPalindrome("hello")); // false
        System.out.println("Is '  A Santa at NASA  ' a palindrome? " + palindromeUtils.isPalindrome("  A Santa at NASA  ")); // true
        System.out.println("Is null a palindrome? " + palindromeUtils.isPalindrome(null)); // false
    }
}
