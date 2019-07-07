package com.hjn.leetcode;

/**
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class MedianOfTwoSortedArrays {
    /**
     * 题目意思： 给定两个排好序的数组nums1和nums2，他们的长度分别未m和n。找出他们两个排序数组的中位数。
     *            整体的时间复杂度应该为O(log(m+n)),你可以假定nums1和nums2都不为空
     *
     * 思路： 因为两个数组都是排序的，可以尝试找到一对数i,j。使得i+1+j+1 == nums1.length-i + nums2.length-j && max(nuns1[i]+nums2[j]) < min(nums1[i+1],nums[j+1])。那么这两个数就是中位数了
     * 参考：https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn))-solution-with-explanation
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        assert (nums1 != null && nums2 != null);

        boolean even = (nums1.length + nums2.length) % 2 == 0;
        // 其中一个数组长度为0的情况
        if (nums1.length == 0) {
            return handleSingleArr(nums2,even);
        }
        if (nums2.length == 0) {
            return handleSingleArr(nums1,even);
        }

        if (nums1.length < nums2.length) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int halfLen = (len1 + len2) / 2;
        int left = 0, right = nums1.length - 1;

        // nums1的最小值大于num2的最大值，会导致在二分查找的时候找不到符合条件的i，j
        if (nums1[0] > nums2[nums2.length-1]) {
            if (even) {
                if (halfLen == nums1.length) {
                    return ((double) nums1[nums1.length - 1] + (double) nums2[0]) / 2;
                }
                return ((double) nums1[halfLen-nums2.length] + (double) nums1[halfLen -nums2.length- 1]) / 2;
            } else {
                return nums1[halfLen-nums2.length];
            }
        }

        while (left <= right) {
            int middle = (left + right) / 2;
            // 切的太少
            if (middle + 1 + nums2.length < halfLen) {
                left = middle + 1;
                continue;
            }
            int tmp = halfLen - (middle + 1);
            // 切的太多
            if (tmp < 0) {
                right = middle - 1;
                continue;
            }

            int leftMax = 0, rightMin = 0;
            if (tmp == 0) {
                leftMax = nums1[middle];
                if (middle == nums1.length - 1) {
                    rightMin = nums2[0];
                } else {
                    rightMin = Math.min(nums1[middle + 1], nums2[0]);
                }
            } else {
                leftMax = Math.max(nums1[middle], nums2[tmp - 1]);
                rightMin = tmp < len2 ? Math.min(nums1[middle + 1], nums2[tmp]) : nums1[middle + 1];
            }

            if (leftMax <= rightMin) {
                if (even) {
                    return ((double) leftMax + (double) rightMin) / 2;
                } else {
                    return rightMin;
                }
            }
            if (tmp == 0) {
                right = middle - 1;
            } else {
                if (nums1[middle] > nums2[tmp - 1]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }

        // 到这里的话应该属于异常
        return -1;
    }
    //  求一个数组的中位数
    private double handleSingleArr(int[] nums, boolean even) {
        int half = nums.length / 2;
        if (even) {
            return ((double) nums[half] + (double) nums[half - 1]) / 2;
        } else {
            return nums[nums.length / 2];
        }
    }

//  先计算出两个数组中位数的位置mid，然后逐个比较两个数组。直到找到第mid位置的元素。
//  时间复杂度O( (nums1.length + nums2.length)/2 ),
//  不满足题目要求但能在leetcode上拿一个比较好的分数，应该是leetcode对java的时间复杂度的支持不是很友好
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        boolean even = (nums1.length + nums2.length) % 2 == 0;
//        int middle = (nums1.length + nums2.length) / 2;
//
//        int len1 = 0;
//        int len2 = 0;
//        int pre = 0;
//        while (len1 < nums1.length && len2 < nums2.length) {
//            if (nums1[len1] < nums2[len2]) {
//                if (len1 + len2 == middle) {
//                    if (!even) {
//                        return nums1[len1];
//                    }else {
//                        return ((double)nums1[len1] + (double)pre)/2;
//                    }
//                }
//                if (even && len1 + len2 == middle - 1) {
//                    pre = nums1[len1];
//                }
//                len1++;
//            } else {
//                if (len1 + len2 == middle) {
//                    if (!even) {
//                        return nums2[len2];
//                    }else {
//                        return ((double)nums2[len2] + (double)pre)/2;
//                    }
//                }
//                if (even && len1 + len2 == middle - 1) {
//                    pre = nums2[len2];
//                }
//                len2++;
//            }
//        }
//        if (len1 == nums1.length) {
//            if (!even) {
//                return nums2[middle - len1];
//            } else {
//                if (len1 + len2 == middle) {
//                    return ((double) pre + (double) nums2[len2]) / 2;
//                } else {
//                    return ((double)nums2[middle - len1] + (double)nums2[middle - len1 - 1]) / 2;
//                }
//            }
//        }
//
//        if (len2 == nums2.length) {
//            if (!even) {
//                return nums1[middle - len2];
//            } else {
//                if (len1 + len2 == middle) {
//                    return ((double)pre + (double)nums1[len1]) / 2;
//                } else {
//                    return ((double)nums1[middle - len2] + (double)nums1[middle - len2 - 1])/2;
//                }
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays mos = new MedianOfTwoSortedArrays();
        System.out.println(mos.findMedianSortedArrays(new int[]{}, new int[]{1}));
    }
}
