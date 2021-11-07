package com.leetcode;

/**
 * @Author zj
 * @Date 2021/9/24 11:02
 * @Description 卡牌分组
 *  满足条件的X，由于每一组都有X张卡牌，所以X必须是卡牌总数N的约数
 *  组内所有的牌上都写着相同的整数，所以X必须是count_i的约数
 */

public class Leetcode941 {
    /**
     * 求两个数的最大公约数
     * @param x
     * @param y
     * @return
     */
    private static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        int[] nums = new int[10004];
        // 计算每种卡牌出现的次数
        for (int x : deck) {
            ++nums[x];
        }
        int g = 0;
        // X必须有是count_i的约数
        for (int x : nums) {
            g = gcd(g, x);
            if (g == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,4,3,2,1};
        boolean result = hasGroupsSizeX(input);
        System.out.println(result);
    }
}
