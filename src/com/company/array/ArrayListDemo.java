package com.company.array;

/**
 * @Description: 集合案例$
 * @Author: shulin
 * @date: 2020/9/3
 */
public class ArrayListDemo {
    /**
     * 指定位置添加袁术
     *
     * @param arr   数组
     * @param index 位置
     * @param o     对象
     * @return
     */
    public static int[] put(int[] arr, int index, int o) {
        int length = arr.length;
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index > length - 1) {
            int[] arr1 = new int[2 * length];
            for (int i = 0; i < length; i++) {
                arr1[i] = arr[i];
            }
            arr = arr1;
        }
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = o;
        return arr;
    }

    /**
     * 删除某个位置的元素
     *
     * @param index 元素位置
     * @return
     */
    public static void delete(Object[] arr, int index) {
        int length = arr.length;
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == length - 1){
            arr[index] = null;
            return;
        }
        for (int i = index; i < length - 1; i++) {
            arr[i] = arr[i+1];
        }
        arr[length - 1] = null;
    }

    public static void main(String[] args) {
        int[] objects = new int[10];
        for (int i = 0; i < 9; i++) {
            objects[i] = i;
        }
        for (int i = 0; i < objects.length; i++) {
            System.out.print(objects[i] + " ");
        }
        System.out.println();
        //添加元素
/*        objects = put(objects,11,11);
        for (int i = 0; i < objects.length ; i++) {
            System.out.print(objects[i]+" ");
        }*/
    }
}

