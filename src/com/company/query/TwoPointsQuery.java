package com.company.query;

/**
 * @Description: 二分查找$
 * @Author: shulin
 * @date: 2020/9/10
 */
public class TwoPointsQuery {
    /**
     * @param a   有序数组
     * @param key 要查找的值
     * @return
     */
    public int twoPoint(int[] a, int key) {

        int middle = a.length + 1;
        int high = a.length;
        int low = 0;
        if(key < a[low] || key > a[high] || low > high){
            return -1;
        }
        while (low <= high) {
            if (a[middle] == key) {
                return key;
            } else if (a[middle] < key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
            middle = (low + high) / 2;
        }
        //未找到值
        return -1;
    }
}

