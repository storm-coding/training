package com.hjn.leetcode;

import java.util.Stack;

/**
 * leetcode 020
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class ValidParentheses {
    /**
     * 题目意思： 给定一个只包含(){}[]的字符串，判断这个字符串是不是有效的。
     *如果字符串是有效的那么：
     * 开括号必须由相同类型的括号关闭。
     * 开括号必须按正确的顺序关闭
     * 空字符串是有效的
     *
     * 思路：遍历字符串，用一个栈保存遍历的字符串。如果遇到闭括号，则将栈顶的元素抛出匹配
     */
    public boolean isValid(String s) {
        if(s == null ) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            switch (c) {
                case ')':
                    if(stack.empty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.empty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.empty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }
        if(!stack.empty() ){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses valid = new ValidParentheses();
        System.out.println(valid.isValid("()"));
    }
}
