package org.ram.test;

import java.util.Stack;

public class BalancedOrNot {

    private static final char LT = '<';
    private static final char GT = '>';

    public static void main(String[] args) {
        int replacements[] = balanceOrNot(
                new String[]{"<", ">", ">"},
                new int[]{2, 2, 2}
        );
        for (int k : replacements) {
            System.out.println(k);
        }
    }

    private static int[] balanceOrNot(String[] expressions, int[] maxReplacements) {
        int[] replacements = new int[expressions.length];
        for (int i = 0; i < expressions.length; i++) {
            Stack<Character> expressionStack = createExpressionStack(expressions[i]);
            String leftOver = "";
            if (expressionStack.isEmpty()) {
                replacements[i] = 1;
            } else {
                while (!expressionStack.isEmpty()) {
                    leftOver += expressionStack.pop();
                }
                if (leftOver.length() <= maxReplacements[i]) {
                    replacements[i] = 1;
                }
            }
        }
        return replacements;
    }

    private static Stack<Character> createExpressionStack(String expression) {
        Stack<Character> expressionStack = new Stack<>();
        for (int j = 0; j < expression.length(); j++) {
            char expressionChar = expression.charAt(j);
            if (LT == expressionChar) {
                expressionStack.push(LT);
            } else if (GT == expressionChar && !expressionStack.isEmpty()) {
                if (expressionStack.peek().equals(LT)) {
                    expressionStack.pop();
                } else {
                    expressionStack.push(GT);
                }
            } else {
                expressionStack.push(GT);
            }
        }
        return expressionStack;
    }


}
