import java.util.*;

public class PalindromeChecker {

    // Method to check if a given string is a palindrome
    public boolean isPalindrome(String input) {
        // Convert the input to lowercase and remove spaces/punctuation
        String cleanedInput = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Push all characters to the stack and queue
        for (char c : cleanedInput.toCharArray()) {
            stack.push(c);
            queue.offer(c);
        }

        // Compare characters from stack and queue
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false; // Not a palindrome
            }
        }

        return true; // Is a palindrome
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();
        String input;

        // Loop until user enters 'q'
        while (true) {
            System.out.println("Enter a string to check if it's a palindrome (or type 'q' to quit):");
            input = scanner.nextLine();

            // Check if the input is a singular 'q' to quit the program
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            // Check if the input string is a palindrome
            if (checker.isPalindrome(input)) {
                System.out.println("The string is a palindrome.");
            } else {
                System.out.println("The string is not a palindrome.");
            }
        }

        scanner.close();
    }
}
