package com.leetcode.string.test;

/**
 * @Author zzj
 * @Date 2021/7/28 10:04
 * @Description
 */

public class IsNumberDemo {

    public boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        int firstIndex = 0;
        int eNumber = 0;
        int fNumber = 0;

        if ("+".equals(chars[0]) || "-".equals(chars[0])) {
            firstIndex = 1;
        }
        for (int i = firstIndex; i < chars.length; i++) {
            char nowIndex = chars[i];
            if ("e".equals(nowIndex) || "E".equals(nowIndex)) {

            }
        }
        return true;
    }
    public static void main(String[] args) {

    }


}
