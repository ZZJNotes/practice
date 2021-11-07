package com.list;

/**
 * @Author zzj
 * @Date 2021/6/2 18:21
 * @Description 已知 sqrt (2)约等于 1.414，要求不用数学库，求 sqrt (2)精确到小数点后 10 位
 *      可以使用二分法
 */

public class sqrt2Demo {
    private static final double EPSILON = 0.0000000001;

    public static double sqrt2() {
        double low = 1.4, high = 1.5;
        double mid = (low + high) / 2;
        while (high - low > EPSILON) {
            if (mid * mid > 2)
                high = mid;
            else
                low = mid;
            mid = (low + high) / 2;

        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println("sqrt2: " + sqrt2());
    }
}
