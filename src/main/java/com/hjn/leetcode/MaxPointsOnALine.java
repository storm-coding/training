package com.hjn.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 149
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnALine {
    /**
     * 题目意思： 给出一个二位平面上的n个点，找出在一条直线上最多点的数量
     * <p>
     * 思路：  1、遍历points，
     * 2、遍历points,针对1中遍历的当前节点i,找出所有点与点i的两点构成直线的斜率，添加到map中
     * 遍历的时候需要判断是不是同一点。在最后的时候需要加上和当前节点相同的点 n。
     * 3、当2遍历完成之后，遍历map，找出values中最大的value,再让value+n和当前的最大值比较
     * 注意点：在计算斜率的时候，使用double，会存在浮点数精度的问题，所以不能采用直接计算出斜率的方法。
     *         所以，下面采用的方法是，找出两个点的最大公约数，然后x,y分别除以最大公约数，然后保存相除之后的结果
     */
    public int maxPoints(Point[] points) {
        if (points.length < 3) {
            return points.length;
        }

        int result = 0;
        Map<String, Integer> slopeMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int equal = 0;
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    equal++;
                    continue;
                }
                //利用浮点数计算会存在精度丢失，无法通过leetcode的test case
                //Double d = (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
                int dy = points[i].y - points[j].y;
                int dx = points[i].x - points[j].x;
                int gcdNum = gcd(dy, dx);
                int xGcd = dx / gcdNum;
                int yGcd = dy / gcdNum;
                slopeMap.put(xGcd + "" + yGcd, slopeMap.getOrDefault(xGcd + "" + yGcd, 1) + 1);
            }

            int max = 0;
            for (int n : slopeMap.values()) {
                max = n > max ? n : max;
            }
            result = result > max + equal ? result : max + equal;
            if (slopeMap.size() == 0) {
                result = result > ++equal ? result : equal;
            }
            slopeMap.clear();
        }

        return result;
    }

    /**
     * 最大公约数性质
     * 性质1 如果a>b，则a和b与a-b和b的最大公约数相同，即Gcd(a, b) = Gcd(a-b, b)
     * 性质2 如果b>a，则a和b与a和b-a的最大公约数相同，即Gcd(a, b) = Gcd(a, b-a)
     * 性质3 如果a=b，则a和b的最大公约数与a值和b值相同，即Gcd(a, b) = a = b
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

}
