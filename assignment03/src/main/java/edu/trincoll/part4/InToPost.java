package edu.trincoll.part4;

public class InToPost extends LStack {
    /**
     * Constructs an InToPost object with an empty stack.
     */
    public InToPost() {
        super();
    }

    /**
     * Converts an infix expression to a postfix expression.
     *
     * @param infixString The infix string to be converted
     * @return The converted postfix string
     */
    public String inToPost_convert(String infixString) {
        StringBuilder postfixString = new StringBuilder();
        for (int i = 0; i < infixString.length(); i++) {
            char ch = infixString.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (ch == '(') {
                push(ch);
            } else if (ch == ')') {
                while (!isEmpty() && topValue() != '(') {
                    postfixString.append(pop());
                }
                pop();
            } else if (isOperator(ch)) {
                while (!isEmpty() && precedence(ch) <= precedence(topValue())) {
                    postfixString.append(pop());
                }
                push(ch);
            } else {
                postfixString.append(ch);
            }
        }
        while (!isEmpty()) {
            postfixString.append(pop());
        }
        return postfixString.toString();
    }

    /**
     * Checks if a character is an operator.
     *
     * @param ch The character to check
     * @return true if the character is an operator, false otherwise
     */
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /**
     * Determines the precedence of an operator.
     *
     * @param ch The operator character
     * @return The precedence value of the operator
     */
    private int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}