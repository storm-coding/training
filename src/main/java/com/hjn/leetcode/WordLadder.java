package com.hjn.leetcode;

import java.util.*;

/**
 * leetcode 127
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {
    /**
     * 题目意思： 给定两个单词（beginWord 和 endWord），和一个字典单词的列表
     *            找出从开始词到结束词的最短变换序列的长度，想下面这样:
     *            依次只能变换一个单词
     *            每个转换后的单词必须存在于单词列表中。beginWord不是一个转换后的单词。
     * 注意点：如果没有这样的转换序列，返回0
     *         所有的单词都是相同长度
     *         所有的单词只包含小写字母
     *         你可以假定单词列表中没有重复的
     *         你可以假设开始词和结束词都是非空的，而且它们是不一样的
     *
     * 思路： 类似279题，使用广度优先的思路
     *        1、使用一个队列存储链路中符合条件的单词
     *        2、在没一层的遍历当中针对当前的字符串找出下一层中符合条件的字符串，并用一个临时队列存储
     *        3、在当前层节点遍历完之后，将下一层的节点赋给当前的队列
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            Queue<String> levelQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                String cur = queue.poll();
                if (endWord.equals(cur)) {
                    return result;
                }
                Iterator<String> it = wordList.iterator();
                while (it.hasNext()) {
                    String tmp = it.next();
                    if (isLadder(cur, tmp)) {
                        levelQueue.add(tmp);
                        it.remove();
                    }
                }
            }
            result++;
            queue = levelQueue;
        }
        return 0;
    }

    public boolean isLadder(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int diffLen = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffLen++;
                if (diffLen > 1) {
                    return false;
                }
            }
        }

        return diffLen == 1;
    }

    /**
     * "leet"
     * "code"
     * ["lest","leet","lose","code","lode","robe","lost"]
     *
     * @param args
     */
    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        List<String> strArr = new ArrayList<String>(Arrays.asList(new String[]{"lest", "leet", "lose", "code", "lode", "robe", "lost"}));
        int len = wl.ladderLength("leet", "code", strArr);
        System.out.println(len);
    }

}
