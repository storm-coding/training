package com.hjn;


public class FindPairNumSumInArr {

    /**
     * 给定一个有序（从小到大）数组，判断中是否存在一对数字相加等于给定值
     * 算法思路：遍历给定数组data,对于遍历的当前元素，使用sum减去当前元素的值：target，然后在data里面查找是否存在target
     * 时间复杂度O(nlgn) 空间复杂度O(1)
     * @param data  给定数组
     * @param sum  数组中一对数的和
     * @return  返回数组中是否存在一对数的和等于sum
     */
    boolean find(int[] data, int sum) {
        if (data == null || data.length < 2) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (i != 0) {
                // 重复元素
                if (data[i] == data[i - 1]) {
                    continue;
                }
            }
            int target = sum - data[i];
            if (target == 0) {
                return false;
            }
            if (binarySearch(data, target, i)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 二分查找
     * @param data 给定数组
     * @param target 目标值
     * @param preIndex 和sum相减的那个元素下标
     * @return 是不是在给定数组中能找到目标值
     */
    private boolean binarySearch(int[] data, int target, int preIndex) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            // 这个处理有两个相同元素组成的情况
            if (middle == preIndex && data[middle] == target) {
                if (middle == data.length - 1) {
                    return data[middle - 1] == target;
                }
                if (middle == 0) {
                    return data[middle + 1] == target;
                }
                return data[middle - 1] == target || data[middle + 1] == target;
            }
            if (data[middle] == target) {
                return true;
            }
            if (data[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

}
