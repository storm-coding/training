package com.hjn;

import java.util.PriorityQueue;


public class TopK {
    /**
     * TopN：求给定的N个有序数组里最大的K个数
     * 算法思路：
     * topk问题，这里使用java本身的数据结构优先队列(底层最小堆实现)来辅助topk元素的存储；
     * 因为每个数组都是从小到大排序的，所以这里我们只需要从后往前遍历，
     * 如果遍历到的元素小于最小堆的最小的元素，则可以遍历下面的数组
     * 算法时间复杂度：O(nlgn), 空间复杂度：O(k)
     *
     * @param array 给定的二位数组
     * @param k 最大的k个元素
     * @return 最大k个元素组成的数组
     */
    public long[] topn(long[][] array, int k) {
        if(array == null || array.length == 0){
            throw new NullPointerException("array is null or empty");
        }

        PriorityQueue<Long> queue = new PriorityQueue(k);
        for (int i = 0; i < array.length; i++) {
            for (int j = array[i].length - 1; j >= 0; j--) {
                if (queue.size() == k) {
                    // array中每个数组从小到大，这里如果最后的一个元素小于query中的最小元素，则遍历下一个数组
                    if (array[i][j] <= queue.peek()) {
                        break;
                    }else {
                        queue.poll();
                        queue.offer(array[i][j]);
                    }
                }else {
                    queue.offer(array[i][j]);
                }
            }
        }

        if (queue.size() < k) {
            throw new RuntimeException("array`s element is less k");
        }
        long[] result = new long[k];
        for(int i = 0; i< k;i++){
            result[i] = queue.poll();
        }
        return result;
    }

}
