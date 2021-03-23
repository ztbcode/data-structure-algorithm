package com.company.sort;

/**
 * @Description: 排序测试$
 * @Author: shulin
 * @date: 2020/9/10
 */
public class SortOperatorTest {
    public static void main(String[] args) {
        int[] arr = {4,3,5,2,6};
        SortOperator sortOperator = new SortOperator();
        sortOperator.quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

