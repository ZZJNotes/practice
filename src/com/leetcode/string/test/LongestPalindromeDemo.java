package com.leetcode.string.test;

/**
 * @Author zzj
 * @Date 2021/6/29 16:29
 * @Description 最长回文子串
 */

public class LongestPalindromeDemo {

    private static int index, len;

    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        // 以某个元素为中心，分别向左右判断，分为奇数和偶数的情况
        for (int i = 0; i < s.length() - 1; i++) {
            PalindromeHelper(s, i , i);
            PalindromeHelper(s, i , i + 1);

        }
        return s.substring(index, index + len);
    }

    private static void PalindromeHelper(String s, int l, int r) {
        while(l > 0 && r < s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        // 判断是否是最长字串
        if (len < r - l - 1) {
            index = l + 1;
            len = r - l - 1;
        }
    }

    public static void main(String[] args) {
        String s = "abaabbaa";
        System.out.println("len:" + len);
        System.out.println("s.length()" + s.length());
        System.out.println("s.substring()" + s.substring(1,2));
        System.out.println(longestPalindrome(s));
    }
}
