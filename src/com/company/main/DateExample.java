package com.company.main;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateExample {

    public static void main(String[] args){


        clock();
        //get current localDate
        LocalDate today = LocalDate.now();

        //get tomorrow localDate
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);

        //get yesterday LocalDate
        LocalDate yesterday = LocalDate.now().minusDays(1); // or tomorrow.minusDays(2);

        //print all dates
        System.out.println(today);

        System.out.println(tomorrow);

        System.out.println(yesterday);

        getIndependanceDay();

        myBirthday();

        formatters();

        localTimeExamples();
    }

    private static void myBirthday() {
        LocalDate independenceDay = LocalDate.of(1992, Month.AUGUST, 17);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println();
        System.out.printf("BIRTHDAY :%s \n",dayOfWeek);
    }


    private static void localTimeExamples() {

        //take two times and compare them with differences
        LocalTime now1 = LocalTime.now();
        LocalTime now2 = LocalTime.now(ZoneId.of("Europe/London"));

        System.out.printf("my time %s \n", now1);
        System.out.printf("London time %s \n ", now2);
        System.out.println();
        System.out.println("Comparing my time with London Time");
        System.out.printf("is my time is before London time %s \n", now1.isBefore(now2));  // false
        System.out.printf("is London time is before my time %s \n", now2.isBefore(now1));  // true


        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println();
        System.out.printf("Hours difference %s \n",hoursBetween);       // -3
        System.out.printf("Minutes difference %s \n ",minutesBetween);     // -239

    }

    private static void clock() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();


        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date

    }

    private static void formatters() {
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMANY);
        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(xmas);   // 2014-12-24
    }

    private static void getIndependanceDay() {
        LocalDate independenceDay = LocalDate.of(1947, Month.AUGUST, 14);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);    // THURSDAY
    }
}
