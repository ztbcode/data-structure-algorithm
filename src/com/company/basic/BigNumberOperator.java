package com.company.basic;

/**
 * @Description: 大数操作类$
 * @Author: shulin
 * @date: 2020/9/11
 */
public class BigNumberOperator {
    //大数相乘       乘法规律:
    //对 a * b 而言，a 的第 i 位和 b 的第 j 位相乘的结果会放在 result[i+j]中
    //两个数（a,b）相乘最后的结果位数一定小于或等于 a.len + b.len ;
    public String multiply(String s1, String s2) {
        if (s1.startsWith("-") && s2.startsWith("-")) {
            return multiply(s1.substring(1), s2.substring(1));
        } else if (s1.startsWith("-")) {
            return "-" + multiply(s1.substring(1), s2);
        } else if (s2.startsWith("-")) {
            return "-" + multiply(s1, s2.substring(1));
        }
        char[] chars1 = new StringBuilder(s1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(s2).reverse().toString().toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        //创建临时结果数组
        int[] tempArray = new int[length1 + length2];
          for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                tempArray[i + j] = (chars1[i] - '0') * (chars2[j] - '0') + tempArray[i + j];
            }
        }
        //处理进位
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] >= 10) {
                tempArray[i + 1] = tempArray[i + 1] + tempArray[i] / 10;
                tempArray[i] = tempArray[i] % 10;
            }
        }
        //获得结果
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (int i = tempArray.length - 1; i >= 0; i--) {
            if (tempArray[i] == 0 && flag) {
                continue;
            }
            stringBuilder.append(tempArray[i]);
            flag = false;
        }
        String s = stringBuilder.toString();
        return s.equals("") ? "0" : s;

    }

    //大数相减 s1绝对值 s2绝对值
    public String sub(String s1, String s2) {
        char[] chars1 = new StringBuilder(s1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(s2).reverse().toString().toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        int max = Math.max(length1, length2);
        //符号位 是否正数
        boolean isPostive = true;
        if (length1 < length2) {
            isPostive = false;
        } else if (length1 == length2) {
            //遍历判断正负
            for (int i = length1 - 1; i >= 0; i--) {
                if (chars1[i] < chars2[i]) {
                    isPostive = false;
                    break;
                } else if (chars1[i] > chars2[i]) {
                    break;
                }
            }
        }
        int[] tempArray = new int[max + 1];
        //处理相减
        for (int i = 0; i < max; i++) {
            int intA = i < length1 ? chars1[i] - '0' : 0;
            int intB = i < length2 ? chars2[i] - '0' : 0;
            if (isPostive) {
                tempArray[i] = intA - intB;
            } else {
                tempArray[i] = intB - intA;
            }
        }
        //处理进位
        for (int i = 0; i < max; i++) {
            if (tempArray[i] < 0) {
                tempArray[i] = tempArray[i] + 10;
                tempArray[i + 1] = tempArray[i + 1] - 1;
            }
        }
        //输出结果
        StringBuilder stringBuilder = isPostive ? new StringBuilder() : new StringBuilder("-");
        boolean flag = true;
        for (int i = tempArray.length - 1; i >= 0; i--) {
            if (tempArray[i] == 0 && flag) {
                continue;
            }
            stringBuilder.append(tempArray[i]);
            flag = false;
        }
        String s = stringBuilder.toString();
        return s.equals("") ? "0" : s;
    }

    //大数相加
    public String add(String s1, String s2) {
        //先判断符号位
        if (s1.startsWith("-") && s2.startsWith("-")) {
            return "-" + add(s1.substring(1), s2.substring(1));
        } else if (s1.startsWith("-")) {
            return sub(s2, s1.substring(1));
        } else if (s2.startsWith("-")) {
            return sub(s1, s2.substring(1));
        }
        char[] chars1 = new StringBuilder(s1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(s2).reverse().toString().toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        int maxLength = length1 > length2 ? length1 : length2;
        //临时结果
        int[] tempChars = new int[maxLength + 1];
        for (int i = 0; i < maxLength; i++) {
            int intA = i < length1 ? chars1[i] - '0' : 0;
            int intB = i < length2 ? chars2[i] - '0' : 0;
            tempChars[i] = intA + intB;
        }
        //处理进位
        for (int i = 0; i < maxLength; i++) {
            if (tempChars[i] >= 10) {
                tempChars[i + 1] = tempChars[i + 1] + tempChars[i] / 10;
                tempChars[i] = tempChars[i] % 10;
            }
        }
        //输出结果
        StringBuilder stringBuilder = new StringBuilder();
        //表示是否遇到0
        boolean flag = true;
        for (int i = tempChars.length - 1; i >= 0; i--) {
            if (tempChars[i] == 0 && flag) {
                continue;
            }
            stringBuilder.append(tempChars[i]);
            flag = false;
        }
        return stringBuilder.toString();
    }
}

