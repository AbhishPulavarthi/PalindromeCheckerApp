import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive palindrome check
    public static boolean isPalindrome(String str, int start, int end) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 🔹 Normalize string:
        // 1. Convert to lowercase
        // 2. Remove spaces using regex
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Call recursive function
        boolean result = isPalindrome(normalized, 0, normalized.length() - 1);

        if (result) {
            System.out.println("The string is a palindrome (ignoring case and spaces).");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }
}