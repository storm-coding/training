package com.hjn.leetcode;

import java.util.Arrays;

/**
 * leetCode 215
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {
    /**
     * 题意：在一个未排序的数组中找出第k大的元素，不是第k大的不同数字(也就是说这里的排序不需要去重)
     * <p>
     * 思路： 经典的topK问题
     * 解法一、先对整个数组排序(这里直接使用jdk的)，然后返回第K大的，缺点：但是只需要找到第K大的，不需要对整个数组进行排序
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 解法二 首先创建一个k的最小堆，后面维持一个这个最小堆，最后这个最小堆的头就是第k大的元素
     */
    int[] minHeap;
    int k;

    public int findKthLargest1(int[] nums, int k) {
        minHeap = new int[k];
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                int index = i;
                minHeap[i] = nums[i];
                while (index >= 0) {
                    int parent = (index - 1) / 2;
                    if (minHeap[index] < minHeap[parent]) {
                        swap(minHeap, index, parent);
                        index = parent;
                        continue;
                    }
                    break;
                }
            } else if (nums[i] > minHeap[0]) {
                heapReplaceTop(nums[i]);
            }
        }
        return minHeap[0];
    }

    private void heapReplaceTop(int data) {
        int parent = 0;
        minHeap[parent] = data;
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        while (left < k) {
            int min = left;
            if (right < k) {
                min = minHeap[left] < minHeap[right] ? left : right;
            }
            if (minHeap[parent] > minHeap[min]) {
                swap(minHeap, parent, min);
                parent = min;
                left = parent * 2 + 1;
                right = parent * 2 + 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray k = new KthLargestElementInAnArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(k.findKthLargest1(nums, 2));
    }

    /**
     * 解法三，利用快排，不需要将整个数组排序完成。只需要找到最近的那个排序第k的即可（参考leetcode）
     */
    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length, target = n - k;
        quickSort(nums, 0, n - 1, target);
        return nums[target];
    }

    public void quickSort(int[] nums, int start, int end, int target) {
        if (start == end) return;
        int mid = (start + end) / 2;
        int pivot = findPivot(nums[start], nums[mid], nums[end]);
        int i = start, j = end;
        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        if (target <= i - 1) quickSort(nums, start, i - 1, target);
        else {
            quickSort(nums, i, end, target);
        }

    }

    public int findPivot(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        return a + b + c - max - min;
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
