package com.leetcode;

import java.util.Arrays;

/**
 * @Author zj
 * @Date 2021/9/23 10:46
 * @Description 两球之间的磁力
 */

public class Leetcode1552 {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0], ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static boolean check(int x, int[] position, int m) {
        int pre = position[0], cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }

    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;
        int result = maxDistance(position, m);
        System.out.println(result);
    }

}
