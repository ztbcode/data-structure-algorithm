package com.company.basic;

/**
 * @Description: 大数操作测试类$
 * @Author: shulin
 * @date: 2020/9/11
 */
public class BigNumberTest {
    public static void main(String[] args) {
        BigNumberOperator bigNumberOperator = new BigNumberOperator();
        String s1 = "800";
        String s2 = "1940";
        String add = bigNumberOperator.add(s1, s2);
        String sub = bigNumberOperator.sub(s1, s2);
        String multiply = bigNumberOperator.multiply(s1, s2);
        System.out.println(add);
        System.out.println(sub);
        System.out.println(multiply);
    }
}

