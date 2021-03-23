package com.company.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 将一个偶数分成两个素数之和$
 * @Author: shulin
 * @date: 2020/9/10
 */
public class Test02 {
    public static void main(String[] args) {
        int num = 24;
        if (num % 2 == 0 && num > 0) {
            method(num);
        }
    }

    public static void method(int num) {
        if (num != 2) {
            List<Integer> primes = getPrime(num);
            for (int i = 0; i < primes.size(); i++) {
                for (int j = 0; j < primes.size(); j++) {
                    if (primes.get(i) + primes.get(j) == num) {
                        System.out.println(primes.get(i) + "+" + primes.get(j) + "=" + num);
                    }
                }
            }
        } else if (num == 2) {
            System.out.println("2是素数，且不能拆分");
        }
    }

    /**获取0到当前数的质数
     * @param
     * @return
     */
    public static List<Integer> getPrime(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            boolean b = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                list.add(i);
            }
        }
        return list;
    }
}

