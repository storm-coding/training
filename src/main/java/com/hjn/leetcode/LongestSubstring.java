package com.hjn.leetcode;

/**
 * leetcode 003
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = -1;
        int result = 0;
        int temp = 0;
        int strArr[] = new int[256];
        while (left < s.length()){

            if( (right < s.length()-1) && (strArr[s.charAt(right+1)] == 0)){
                strArr[s.charAt(++right)] = 1;
                temp++;
                if(temp>result) {
                    result = temp;
                }
            }else{
                strArr[s.charAt(left)] = 0;
                temp--;
                left++;
            }
        }
        return result;
    }
}
