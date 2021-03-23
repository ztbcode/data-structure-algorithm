package com.company.basic;

/**
 * @Description: 阿拉伯数字金额转化为中文$
 * @Author: shulin
 * @date: 2020/9/10
 */
public class Test08 {
    public static void main(String[] args) {
        int money=2350230;
        String renMingBi = method(money);
        System.out.println(renMingBi);
    }

    public static String method(int money){
        char[] data = new char[]{'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
        char[] units = new char[]{'元','拾','佰','仟','万','拾','佰','仟','亿'};
        StringBuffer sb=new StringBuffer();
        int unit=0;
        while(money!=0){
            sb.insert(0, units[unit++]);
            int num=money%10;
            sb.insert(0, data[num]);
            money/=10;
        }
        return sb.toString();
    }
}
