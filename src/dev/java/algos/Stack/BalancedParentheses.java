package dev.java.algos.Stack;

import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        // Test cases to verify the solution
        String test1 = "{[()]}";
        String test2 = "{[}]";
        String test3 = "()]";

        System.out.println("Test 1: " + isBalanced(test1));
        System.out.println("Test 2: " + isBalanced(test2));
        System.out.println("Test 3: " + isBalanced(test3));
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stackPipe = new Stack<>();
        for (char c : s.toCharArray()) {
            String checkList = "([{";
            if (c == '(' || c == '[' || c == '{') {
                stackPipe.push(c);
            } else if (c == ')' && !stackPipe.isEmpty()) {
                char topEle = stackPipe.pop();
                if (topEle != '(') {
                    return false;
                }

            } else if (c == ']' && !stackPipe.isEmpty()) {
                char topEle = stackPipe.pop();
                if (topEle != '[') {
                    return false;
                }

            } else if (c == '}' && !stackPipe.isEmpty()) {
                char topEle = stackPipe.pop();
                if (topEle != '{') {
                    return false;
                }
            }
        }
        if (!stackPipe.isEmpty())
            return false;
        return true;
    }
}
