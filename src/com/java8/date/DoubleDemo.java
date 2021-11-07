package com.java8.date;

import java.math.BigDecimal;

/**
 * @Author zzj
 * @Date 2021/5/18 14:20
 * @Description
 */

public class DoubleDemo {
    static boolean out(char c){
        System.out.println(c);
        return true;
    }
    public static void main(String[] args) {

        double payAmount=3364.72, discountAmount=271.33;
        double totalAmount=3636.05;
        double changeAmount=0.0;
        double sum = payAmount + discountAmount + changeAmount;
//        double sum = payAmount * 100 + discountAmount * 100;
//        double sum = add(payAmount, discountAmount);
//        sum = sum + changeAmount * 100;
        sum = getTotal(payAmount, discountAmount, changeAmount);
        System.out.println("sum: " + sum );
        System.out.println("payAmountValid ? " + (totalAmount == sum));

        int[] arr = new int[10];
        System.out.println("arr: " + arr[2]);
        int i = 0;
        for(out('A');out('B') && (i<2);out('C')){
            i++;
            out('D');
        }
    }

    public static double getTotal(double v1, double v2, double v3) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        BigDecimal b3 = new BigDecimal(Double.toString(v3));

        return b1.add(b2).subtract(b3).doubleValue();
    }


    /*public void test(){
        private class inner{

        }

        public class inner1{

        }

        protected class inner2{

        }

        static class inner3 {

        }

    }*/



}
