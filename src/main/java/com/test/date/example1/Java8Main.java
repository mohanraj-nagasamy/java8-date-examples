package com.test.date.example1;

import com.test.date.TimeZone;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.time.temporal.ChronoUnit.*;

public class Java8Main {

    public static void example1() {
        log("How to get today's date/time in Java 8");

        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime timeWithDate = LocalDateTime.now();

        System.out.println("today = " + today);
        System.out.println("local date with time now = " + timeWithDate);
        System.out.println("time = " + time);
    }

    public static void example2() {
        log("How to get current day, month and year in Java 8");

        LocalDate today = LocalDate.now();
        System.out.println(String.format("Year : %s Month : %s day : %s", today.getYear(), today.getMonthValue(), today.getDayOfMonth()));

        LocalDateTime time = LocalDateTime.now();
        System.out.println(String.format("Hour : %s Mins : %s Sec : %s", time.getHour(), time.getMinute(), time.getSecond()));
    }

    public static void example3() {
        log("How to get a particular date in Java 8");

        LocalDate dateOfBirth = LocalDate.of(2010, 1, 14);
        System.out.println("Your Date of birth is : " + dateOfBirth);
    }

    public static void example4() {
        log("How to check if two dates are equal in Java 8");

        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(date1.getYear(), date1.getMonth(), date1.getDayOfMonth());
        if (date1.equals(date2)) {
            System.out.printf("Today %s and date1 %s are same date %n", date1, date2);
        }
    }

    public static void example5() {
        log("How to check for recurring events e.g. birthday in Java 8");
        LocalDate dateOfBirth = LocalDate.now();
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(LocalDate.now());

        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }
    }

    public static void example6() {
        log("Adding stuffs to date/time in Java 8");

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime nextHour = time.plusHours(1);

        System.out.println("today = " + today);
        System.out.println("1) tomorrow = " + tomorrow + " \n2) tomorrow = " + today.plus(1, DAYS));
        System.out.println("local time now = " + time);
        System.out.println("1) nextHour = " + nextHour + " \n2) nextHour = " + time.plus(1, HOURS));

        LocalDate nextWeek = today.plus(1, WEEKS);
        System.out.println("Date after 1 week : " + nextWeek);

        LocalDate previousYear = today.minus(1, YEARS);
        System.out.println("Date before 1 year : " + previousYear);

        LocalDate nextYear = today.plus(1, YEARS);
        System.out.println("Date after 1 year : " + nextYear);

        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDayOfMonth = " + firstDayOfMonth);
    }

    private static void example7() {
        log("How to see if a date is before or after another dates in Java 8");

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate yesterday = today.minus(1, DAYS);

        if (tomorrow.isAfter(today)) {
            System.out.println("Tomorrow comes after today");
        }

        if (yesterday.isBefore(today)) {
            System.out.println("Yesterday is day before today");
        }
    }

    private static void example8() {
        log("Dealing with time zones in Java 8");

        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(now, TimeZone.INDIA);
        System.out.println("now = " + now);
        System.out.println("Current date and time in a particular timezone : " + zonedDateTime);

        now = LocalDateTime.now(TimeZone.INDIA);
        System.out.println("now in India = " + now);

        zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime with default(system) timezone = " + zonedDateTime);
        System.out.println("zonedDateTime with India timezone = " + ZonedDateTime.now(TimeZone.INDIA));

        String isoFormatted = DateTimeFormatter.ISO_INSTANT.format(ZonedDateTime.now(TimeZone.INDIA));
        System.out.println("ISO Formatted = " + isoFormatted);

        ZonedDateTime utahMarch8thAt2AM = ZonedDateTime.of(LocalDateTime.of(2015, 3, 8, 1, 0), TimeZone.UTAH);
        System.out.println("utahMarch8thAt2AM = " + utahMarch8thAt2AM);
        System.out.println("utahMarch8thAt2AM.plusHours(1) = " + utahMarch8thAt2AM.plusHours(1));
        System.out.println("utahMarch8thAt2AM.plusHours(2) = " + utahMarch8thAt2AM.plusHours(2));
    }

    private static void example9() {
        log("How to represent fixed date e.g. credit card expiry, YearMonth in Java 8");

        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: No of days: %s \n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s: No of days: %s \n", creditCardExpiry, creditCardExpiry.lengthOfMonth());
    }

    private static void example10() {
        log("How to check Leap Year in Java 8");

        LocalDate today = LocalDate.now();
        if (today.isLeapYear()) {
            System.out.println("This year is Leap year");
        } else {
            System.out.println("2015 is not a Leap year");
        }

        if (today.withYear(2016).isLeapYear()) {
            System.out.println("2016 is Leap year");
        }

    }

    private static void example11() {
        log("How many days, month between two dates in Java 8");

        LocalDate today = LocalDate.now();
        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        Period period = Period.between(java8Release, today);
        System.out.println("Period between today and Java 8 release : " + period);
        System.out.println("Period between Java 8 release and today : " + Period.between(today, java8Release));

        long millisBetween = MILLIS.between(LocalDateTime.now(), LocalDateTime.now().plusMinutes(1));
        System.out.println("millisBetween = " + millisBetween);

        LocalDate startEmployment = LocalDate.of(2010, Month.SEPTEMBER, 8);

        period = startEmployment.until(today);
        System.out.println("period = " + period);
        long numberOfDays = startEmployment.until(today, DAYS);
        System.out.println("numberOfDays = " + numberOfDays);

        int yearsAtOctanner = 4;
        int monthsAtOctanner = 6;
        Period periodAtOct = Period.ofYears(yearsAtOctanner).withMonths(monthsAtOctanner);
        System.out.println("periodAtOct = " + periodAtOct);

        LocalDateTime utah = LocalDateTime.now();
        LocalDateTime india = LocalDateTime.now(TimeZone.INDIA);
        long betweenHours = ChronoUnit.HOURS.between(utah, india);
        long betweenMins = ChronoUnit.MINUTES.between(utah, india);
        System.out.println("betweenHours = " + betweenHours);
        System.out.println("betweenMins = " + (betweenMins/60.0));
    }

    private static void example12() {
        log("Date and Time with timezone offset in Java 8");

        LocalDateTime datetime = LocalDateTime.now();
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);

        System.out.println("OffsetDateTime.now() = " + OffsetDateTime.now());
        System.out.println("OffsetDateTime.now(TimeZone.INDIA) = " + OffsetDateTime.now(TimeZone.INDIA));
        System.out.println("Date and Time: " + datetime);
        System.out.println("Date and Time with timezone offset: " + date);
    }

    private static void example13() {
        log("How to get current time stamp in Java 8");
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
    }

    private static void example14() {
        log("How to parse/format date in Java 8 using predefined formatter in Java 8");

        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);
        System.out.println("Formatted today = " + DateTimeFormatter.BASIC_ISO_DATE.format(LocalDateTime.now()));

        // Custom formatter
        String goodFriday = "Apr 18 2014";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        LocalDate holiday = LocalDate.parse(goodFriday, formatter);
        System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a z");
        ZonedDateTime arrivalDate = ZonedDateTime.now();
        String landing = arrivalDate.format(format);
        System.out.printf("Arriving at :  %s %n", landing);
    }

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
        example6();
        example7();
        example8();
        example9();
        example10();
        example11();
        example12();
        example13();
        example14();
        example15();
    }

    private static void example15() {
        log("Date conversions in Java 8");

        // convert old date/calendar/timezone classes
        Instant instantFromDate = new Date().toInstant();
        Instant instantFromCalendar = Calendar.getInstance().toInstant();
        ZoneId zoneId = java.util.TimeZone.getDefault().toZoneId();
        ZonedDateTime zonedDateTimeFromGregorianCalendar = new GregorianCalendar().toZonedDateTime();

        // convert to old classes
        Date dateFromInstant = Date.from(Instant.now());
        java.util.TimeZone timeZone = java.util.TimeZone.getTimeZone(ZoneId.of("America/Los_Angeles"));
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(ZonedDateTime.now());
    }


    public static void log(String message) {
        System.out.println();
        System.out.println(message);
    }
}
