package edu.trincoll.part4;

public class InToPrefix {
  private LStack stack;

  /**
   * Constructs an InToPrefix object with an empty stack.
   */
  public InToPrefix() {
    stack = new LStack();
  }

  /**
   * Converts an infix expression to a prefix expression.
   *
   * @param infixString The infix string to be converted
   * @return The converted prefix string
   */
  public String inToPrefixConvert(String infixString) {
    StringBuilder prefixString = new StringBuilder();
    for (int i = infixString.length() - 1; i >= 0; i--) {
      char ch = infixString.charAt(i);
      if (ch == ' ') {
        continue;
      }
      if (ch == ')') {
        stack.push(ch);
      } else if (ch == '(') {
        while (!stack.isEmpty() && stack.topValue() != ')') {
          prefixString.append(stack.pop());
        }
        stack.pop();
      } else if (isOperator(ch)) {
        while (!stack.isEmpty() && precedence(ch) < precedence(stack.topValue())) {
          prefixString.append(stack.pop());
        }
        stack.push(ch);
      } else {
        prefixString.append(ch);
      }
    }
    while (!stack.isEmpty()) {
      prefixString.append(stack.pop());
    }
    return prefixString.reverse().toString();
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