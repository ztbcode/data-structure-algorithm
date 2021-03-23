package com.company.basic;

import java.util.MissingFormatArgumentException;

/**
 * @Description: 开方类$
 * @Author: shulin
 * @date: 2020/9/21
 */
public class Demo {
    public static void main(String[] args) {
        float v = get((float) 0.09);
        System.out.println(v);
    }

    public static float get(float a) {
        if (a < 0) {
            throw new RuntimeException();
        }
/*        if (a < 1) {
            return getByBinary(a, a, 1);
        }
        return getByBinary(a, 1, a);*/
        return getByNewton(a);
    }

    public static float getByBinary(float a, float low, float high) {
        float middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (Math.abs(middle * middle - a) < 1e-3) {
                return middle;
            }
            if (middle * middle - a > 0) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return -1;
    }

    /** 通过牛顿算法
     * @param a 被开方数
     * @return
     */
    public static float getByNewton(float a){
        float err = (float) 1e-3;
        float t = a;
        while (Math.abs(t - a/t) > err * t){
            t = (a/t + t)/2;
        }
        return t;
    }
}

