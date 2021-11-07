package com.java8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author zzj
 * @Date 2021/4/14 14:35
 * @Description Java8新引入的时间和日期API
 */

public class LocalDateDemo {

    public static void main(String[] args) {

        // create localDate
        LocalDate localDate = LocalDate.of(2021,4,14);
        System.out.println("localDate: " + localDate);

        int year = localDate.getYear();
        System.out.println("year:" + year);

        Month month = localDate.getMonth();
        System.out.println("month:" + month);

        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println("dayOfMonth:" + dayOfMonth);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("dayOfWeek:" + dayOfWeek);
        int lengthOfMonth = localDate.lengthOfMonth();
        System.out.println("lengthOfMonth:" + lengthOfMonth);
        int lengthOfYear = localDate.lengthOfYear();
        System.out.println("lengthOfYear:" + lengthOfYear);
        boolean leapYear = localDate.isLeapYear();
        System.out.println("leapYear:" + leapYear);

        LocalDate withYear = localDate.withYear(2020);
        System.out.println("withYear:" + withYear);
        LocalDate withMonth = localDate.withMonth(5);
        System.out.println("withMonth:" + withMonth);
        LocalDate withDayOfMonth = localDate.withDayOfMonth(15);
        System.out.println("withDayOfMonth:" + withDayOfMonth);

        LocalDate plusWeeks = localDate.plusWeeks(1);
        System.out.println("plusWeeks:" + plusWeeks);
        LocalDate plusMonths = localDate.plusMonths(1);
        System.out.println("plusMonths: " + plusMonths);
        LocalDate plusYears = localDate.plusYears(1);
        System.out.println("plusYears: " + plusYears);

        LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayOfMonth: " + lastDayOfMonth);
        LocalDate dayOfWeekFriday = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("dayOfWeekFriday:" + dayOfWeekFriday);

        // get now
        LocalDate now = LocalDate.now();
        System.out.println("localDate get now: " + now);

        // String to Date
        String date = "2021-04-14";
        LocalDate parseDate = LocalDate.parse(date);
        System.out.println("String to Date: " + parseDate);
        LocalDate parse = LocalDate.parse("20210414", DateTimeFormatter.BASIC_ISO_DATE);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String format = localDate.format(dateTimeFormatter);
        System.out.println("dateFormat: " + format);

        // LocalTime
        LocalTime localTime = LocalTime.of(13, 45, 20);
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        LocalTime parseTime = LocalTime.parse("13:45:20");

        // LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

    }
}
