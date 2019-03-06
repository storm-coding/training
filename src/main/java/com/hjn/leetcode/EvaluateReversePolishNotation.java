package com.hjn.leetcode;

import java.util.Stack;

/**
 * leetcode 150
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Note:
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 */
public class EvaluateReversePolishNotation {
    /**
     * 题目意思： 求解逆波兰表达式的值。有效操作符的值有+、-、*、/。没个表达式的可以是一个整数或者是一个表达式
     * 注意点：1、两个数的触发应该接近0
     *         2、给定的逆波兰表达式总是有效的。这意味这表达式总是有结果的，不会出现除以0的情况
     *
     * 思路：  使用栈来存，当前没有被运算过的操作数。当遇到操作符时，从栈中抛出两个操作是计算然后再入栈
     */
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<String> stack = new Stack<>();
        int result = 0;
        for (String p : tokens) {
            if ("+".equals(p)) {
                int param1 = Integer.parseInt(stack.pop());
                int param2 = Integer.parseInt(stack.pop());
                result = param2 + param1;
                stack.push(String.valueOf(result));
                continue;
            }
            if ("-".equals(p)) {
                int param1 = Integer.parseInt(stack.pop());
                int param2 = Integer.parseInt(stack.pop());
                result = param2 - param1;
                stack.push(String.valueOf(result));
                continue;
            }
            if ("*".equals(p)) {
                int param1 = Integer.parseInt(stack.pop());
                int param2 = Integer.parseInt(stack.pop());
                result = param2 * param1;
                stack.push(String.valueOf(result));
                continue;
            }
            if ("/".equals(p)) {
                int param1 = Integer.parseInt(stack.pop());
                int param2 = Integer.parseInt(stack.pop());
                result = param2 / param1;
                stack.push(String.valueOf(result));
                continue;
            }
            stack.push(p);
        }
        return result;
    }


    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluate = new EvaluateReversePolishNotation();
        int result = evaluate.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(result);
    }
}
