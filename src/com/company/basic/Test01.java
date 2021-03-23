package com.company.basic;

/**
 * @Description: 测试类$
 * @Author: shulin
 * @date: 2020/9/10
 */
public class Test01 {
    //按照字节数截取字符串
    //得到的字节数组如果出现截半 那么ascll小于0
    public static void main(String[] args) {
        String str="我ABC";
        String str1="我ABC汉DEF";
        String s = subStringByBytes(str, 4);
        System.out.println(s);
        String s1 = subStringByBytes(str1, 8);
        System.out.println(s1);
    }
    public static String subStringByBytes(String str,int len){
        if(str==null){
            return null;
        }

        if(len>str.length()){
            len=str.length();
        }

        byte [] bytes=str.getBytes();
        for (int i = 0; i < 2; i++) {
            if (bytes[len-i]<0){
                len--;
            }
        }
        return new String(bytes,0,len);

    }
}

