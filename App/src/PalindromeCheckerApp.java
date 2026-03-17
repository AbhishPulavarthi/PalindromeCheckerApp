import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String str = input.toLowerCase().replaceAll("\\s+", "");
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String str = input.toLowerCase().replaceAll("\\s+", "");
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

// Recursive Strategy
class RecursiveStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {
        String str = input.toLowerCase().replaceAll("\\s+", "");
        return check(str, 0, str.length() - 1);
    }

    private boolean check(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return check(str, start + 1, end - 1);
    }
}

// Main Application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // List of strategies
        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new RecursiveStrategy()
        );

        String[] names = {"Stack Strategy", "Deque Strategy", "Recursive Strategy"};

        System.out.println("\nPerformance Comparison:\n");

        for (int i = 0; i < strategies.size(); i++) {

            long startTime = System.nanoTime();

            boolean result = strategies.get(i).isPalindrome(input);

            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.println(names[i] + ": " + result +
                    " | Time taken: " + duration + " ns");
        }

        scanner.close();
    }
}