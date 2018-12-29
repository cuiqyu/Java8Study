package com.limpid;

import java.time.*;

/**
 * java8新特性之新的时间日期API学习
 *
 * @auther cuiqiongyu
 * @create 2018/12/29 15:13
 */
public class Feature8NewDateTimeApi {

    public static void main(String[] args) {
        /**
         * Java 8通过发布新的Date-Time API (JSR 310)来进一步加强对日期与时间的处理。
         * 在旧版的 Java 中，日期时间 API 存在诸多问题，其中有：
         *  * 非线程安全 − java.util.Date 是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一。
         *  * 设计很差 − Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类在java.text包中定义。
         *    java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。
         *    另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
         *  * 时区处理麻烦 − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。
         * Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
         *  * Local(本地) − 简化了日期时间的处理，没有时区的问题。
         *  * Zoned(时区) − 通过制定的时区处理日期时间。
         * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作。
         */

        // LocalDateTime类
        testLocalDateTime();

        // ZonedDateTime类
        testZonedDateTime();
    }

    /**
     * LocalDateTime类
     */
    private static void testLocalDateTime() {
        // 获取当前的日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间: " + now);

        LocalDate date1 = now.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = now.getMonth();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int seconds = now.getSecond();
        System.out.println("月: " + month + ", 日: " + day + ", 时: " + hour + ", 分: " + minute + ", 秒: " + seconds);

        LocalDateTime date2 = now.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);
        LocalDateTime date3 = now.withDayOfMonth(11).withYear(2012);
        System.out.println("date3: " + date3);

        // 12 december 2014
        LocalDate date4 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date4: " + date4);

        // 22 小时 15 分钟
        LocalTime date5 = LocalTime.of(22, 15);
        System.out.println("date5: " + date5);

        // 解析字符串
        LocalTime date6 = LocalTime.parse("20:15:30");
        System.out.println("date6: " + date6);
    }

    /**
     * ZonedDateTime类
     */
    private static void testZonedDateTime() {
        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+08:00[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }

}
