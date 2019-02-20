package com.hjn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 447
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k)
 * such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 */
public class NumberOfBoomerangs {
    /**
     * 题目意思： 给定出一个平面的n个点，一个boomerang，指的是一个元祖(i,j,k)使得i到j的距离和i到k的距离相等(他们的顺序很重要)
     *            找出这样boomerangs的数量，你可以假定n的数量最多500，点的坐标在[-10000,10000]之间
     * 思路：   1、遍历所有的点，
     *           2、对1中遍历的当前节点i，计算出所有到节点i的距离（除节点i本身），放入一个key为距离，value为距离数量的map中
     *           3、对map中，values大于2的数值进行计算，加入结果集中
     */
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            // 复用一个map，运行时间从166ms 变成 100ms
            // Map<Long, Integer> distanceMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                        (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                distanceMap.put(dis, distanceMap.getOrDefault(dis, 0) + 1);
            }

            for (int nums : distanceMap.values()) {
                if (nums > 1) {
                    result += nums * (nums - 1);
                }
            }
            distanceMap.clear();
        }

        return result;
    }

    /**
     * 思路2：  对上面的改进，去除内层不必要的循环(参考leetcode)
     */
    public int numberOfBoomerangs1(int[][] points) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int d = distance(points[i], points[j]);
                if (map.containsKey(d)) {
                    int v = map.get(d);
                    // For current i, and d, there are j1, j2, ..., jv in map.
                    // Now we have jv+1, we pick one j from j1, ..., jv as 'j', and use 'jv+1' as k, then
                    // there are v permutations.
                    // Because i,j,k and i,k,j are two boomerangs, we need double the count.
                    // n*(n-1)/2 ==  (1+2+....+n-1
                    ans += 2 * v;
                    map.put(d, v + 1);
                } else {
                    map.put(d, 1);
                }
            }
            map.clear();
        }
        return ans;
    }

    private int distance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }


    public static void main(String[] args) {
        for (int i = 0; i< 100000; i++) {
            if (!test(i)) {
                System.out.println(i);
            }
        }

    }

    public static boolean test(int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += 2 * i ;
        }
        return result == n * (n-1);
    }
}
