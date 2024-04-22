package stack.representation;

import java.util.Stack;

public class Main {

    public static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                handleClosingBracket(stack, result);
            } else {
                handleOperator(stack, result, c);
            }
        }

        handleRemainingOperators(stack, result);

        return result.toString();
    }

    private static void handleClosingBracket(Stack<Character> stack, StringBuilder result) {
        while (!stack.isEmpty() && stack.peek() != '(') {
            result.append(stack.pop());
        }
        if (!stack.isEmpty() && stack.peek() != '(') {
            throw new IllegalArgumentException("Invalid expression");
        } else {
            stack.pop();
        }
    }

    private static void handleOperator(Stack<Character> stack, StringBuilder result, char c) {
        while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
            result.append(stack.pop());
        }
        stack.push(c);
    }

    private static void handleRemainingOperators(Stack<Character> stack, StringBuilder result) {
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Invalid expression");
            }
            result.append(stack.pop());
        }
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + infixToPostfix(infixExpression));
    }
}
