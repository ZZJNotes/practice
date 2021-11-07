package com.java8.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author zj
 * @Date 2021/9/27 15:18
 * @Description
 */

public class DateTest {

    public static void main(String[] args) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = "2021-01-11 00:00:00";
        Date parse = format.parse(date);
        System.out.println(parse);
        String point = "388";
        double v = Double.parseDouble(point);
        System.out.println("point:" + v);
        byte a = 1;
        short b = 100;
        int c = 'a';
//        long d = 8888888888;
    }
}
