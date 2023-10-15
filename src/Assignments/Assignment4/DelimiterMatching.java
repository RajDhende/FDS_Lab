package Assignments.Assignment4;

/**
 * The DelimiterMatching class is used to check if delimiters (brackets) in a given string are properly matched.
 */
public class DelimiterMatching extends Stacks {

    /**
     * Constructor for the DelimiterMatching class.
     *
     * @param size The size of the stack to be created for delimiter matching.
     */
    public DelimiterMatching(int size) {
        super(size);
    }

    /**
     * Checks if delimiters in a given string are properly matched.
     *
     * @param input The string containing delimiters to be checked.
     * @return True if delimiters are properly matched, false otherwise.
     */
    public static boolean isDelimiterMatched(String input) {
        Stacks<Character> stack = new Stacks<>(10);
        char[] character = input.toCharArray();

        for (int i = 0; i < character.length; i++) {
            char ch = character[i];
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.Push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.Pop();
                if (!(top == '(' && ch == ')' || top == '{' && ch == '}' || top == '[' && ch == ']')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * The main method to demonstrate delimiter matching.
     *
     * @param args The command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        String bracket = "{}()[]()";
        boolean result = isDelimiterMatched(bracket);
        System.out.println(result);
    }
}
