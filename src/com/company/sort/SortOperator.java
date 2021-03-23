package com.company.sort;

import com.sun.javafx.scene.text.HitInfo;

/**
 * @Description: 排序操作$
 * @Author: shulin
 * @date: 2020/9/10
 */
public class SortOperator {
    //冒泡排序 从头开始依次和当前数比较大小 当比当前数大时交换位置
    public void bubbleSort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int t = 0;
        for (int i = 0; i < a.length; i++) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    t = a[j + 1];
                    a[j] = t;
                    a[j + 1] = a[j];
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low >high){
            return;
        }
        int temp = arr[low];   //基准值取低位
        int i = low; //低位哨兵
        int j = high; //高位哨兵
        int t; //交换数据占位
        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j){
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //当i和j相等时,交换基准位与j
        arr[low] = arr[j];
        arr[j] = temp;
        //递归右半数组
        quickSort(arr,j+1,high);
        //递归左半数组
        quickSort(arr,low,j-1);

    }

}

