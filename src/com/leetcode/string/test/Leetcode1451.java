package com.leetcode.string.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * @Author zj
 * @Date 2021/9/23 10:25
 * @Description 重新排列句子中的单词
 */

public class Leetcode1451 {
    public static String arrangeWords(String text) {
        String[] words = text.toLowerCase().split("\\ ");
        Arrays.sort(words, Comparator.comparingInt(String::length));
        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String text = "Leetcode is cool";
        System.out.println(text);

        String result = arrangeWords(text);
        System.out.println(result);
    }
}
