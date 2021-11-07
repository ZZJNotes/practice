package com.java8.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author zj
 * @Date 2021/8/2 15:40
 * @Description
 */

public class DateDemo {

    public static void main(String[] args) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date endDate = cal.getTime();
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd"); //HH表示24小时制；
        String format = dFormat.format(endDate) + " 23:59:59";
        System.out.println(format);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse(format);

        System.out.println(parse);
    }
}
