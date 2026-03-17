import java.util.Scanner;

// Service class encapsulating palindrome logic
class PalindromeChecker {

    // Public method to check palindrome
    public boolean checkPalindrome(String input) {
        // Normalize string (ignore case & spaces)
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Use internal helper (recursion)
        return isPalindrome(normalized, 0, normalized.length() - 1);
    }

    // Private helper method (encapsulation)
    private boolean isPalindrome(String str, int start, int end) {
        // Base condition
        if (start >= end) {
            return true;
        }

        // Compare characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }
}

// Main application class
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create object of service class
        PalindromeChecker checker = new PalindromeChecker();

        // Call service method
        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }
}