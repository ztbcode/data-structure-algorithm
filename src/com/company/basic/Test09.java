package com.company.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个字符串，求全排列$
 * @Author: shulin
 * @date: 2020/9/10
 */
public class Test09 {
    public static void main(String[] args){
        String str = "abc";
        List<String> result = new ArrayList<>();
        getAllList(result, str.toCharArray(), 0);
        for(String each : result){
            System.out.println(each);
        }
    }
    public static void getAllList(List<String> list,char[] chars,int begin){
        if (begin == chars.length){
            list.add(String.valueOf(chars));
        }
        for (int i = begin; i < chars.length; i++) {
            swap(chars,i,begin);
            getAllList(list,chars,begin+1);
            swap(chars,i,begin);
        }
    }
    //交换char数组两个位置的元素
    public static void swap(char[] chars, int index1,int index2){
        char temp;
        temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}

