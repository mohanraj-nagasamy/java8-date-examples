package com.test.date.example1;


import com.test.date.TimeZone;
import org.joda.time.*;
import org.joda.time.format.*;

import java.util.Calendar;
import java.util.Locale;


public class Java7Main {

    public static void example1() {
        log("How to get today's date/time in Joda-Time");

        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime timeWithDate = LocalDateTime.now();

        System.out.println("today = " + today);
        System.out.println("local date with time now = " + timeWithDate);
        System.out.println("time = " + time);
    }

    public static void example2() {
        log("How to get current day, month and year in Joda-Time");

        LocalDate today = LocalDate.now();
        System.out.println(String.format("Year : %s Month : %s day : %s", today.getYear(), today.getMonthOfYear(), today.getDayOfMonth()));

        LocalDateTime time = LocalDateTime.now();
        System.out.println(String.format("Hour : %s Mins : %s Sec : %s", time.getHourOfDay(), time.getMinuteOfHour(), time.getMillisOfSecond()));
    }

    public static void example3() {
        log("How to get a particular date in Joda-Time");

        LocalDate dateOfBirth = new LocalDate(2010, 1, 14);
        System.out.println("1 Your Date of birth is : " + dateOfBirth);
        dateOfBirth = LocalDate.now().withYear(2010).withMonthOfYear(1).withDayOfMonth(14);
        System.out.println("2 Your Date of birth is : " + dateOfBirth);
    }

    public static void example4() {
        log("How to check if two dates are equal in Joda-Time");

        LocalDate date1 = LocalDate.now();
        LocalDate date2 = new LocalDate(date1.getYear(), date1.getMonthOfYear(), date1.getDayOfMonth());
        if (date1.equals(date2)) {
            System.out.printf("Today %s and date1 %s are same date %n", date1, date2);
        }
    }

    public static void example5() {
        log("How to check for recurring events e.g. birthday in Joda-Time");
        LocalDate dateOfBirth = LocalDate.now();
        MonthDay birthday = new MonthDay(dateOfBirth.getMonthOfYear(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.fromDateFields(LocalDate.now().toDate());

        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }
    }

    public static void example6() {
        log("Adding stuffs to date/time in Joda-Time");

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime nextHour = time.plusHours(1);

        System.out.println("today = " + today);
        System.out.println("1) tomorrow = " + tomorrow + " \n2) tomorrow = " + today.plus(Days.ONE));
        System.out.println("local time now = " + time);
        System.out.println("1) nextHour = " + nextHour + " \n2) nextHour = " + time.plus(Hours.ONE));

        LocalDate nextWeek = today.plusWeeks(1);
        System.out.println("Date after 1 week : " + nextWeek);

        LocalDate previousYear = today.minusYears(1);
        System.out.println("Date before 1 year : " + previousYear);

        LocalDate nextYear = today.plusYears(1);
        System.out.println("Date after 1 year : " + nextYear);

//        LocalDate firstDayOfMonth = LocalDate.now().withDayOfMonth(TemporalAdjusters.firstDayOfMonth());
        int firstDayOfMonth = LocalDate.now().toDateTimeAtStartOfDay().dayOfMonth().getMinimumValue();
        System.out.println("firstDayOfMonth = " + firstDayOfMonth);
        int lastDayOfFeb = LocalDate.now().minusMonths(1).toDateTimeAtStartOfDay().dayOfMonth().getMinimumValue();
        System.out.println("lastDayOfFeb = " + lastDayOfFeb);
    }

    private static void example7() {
        log("How to see if a date is before or after another dates in Joda-Time");

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate yesterday = today.minusDays(1);

        if (tomorrow.isAfter(today)) {
            System.out.println("Tomorrow comes after today");
        }

        if (yesterday.isBefore(today)) {
            System.out.println("Yesterday is day before today");
        }
    }

    private static void example8() {
        log("Dealing with time zones in Joda-Time");

        DateTime now = DateTime.now();

        DateTime zonedDateTime = now.withZone(TimeZone.INDIA_TZ);
        System.out.println("now(system/local TZ) = " + now);
        System.out.println("Current date and time in a particular timezone(India) : " + zonedDateTime);

        LocalDateTime timeInIndia = LocalDateTime.now(TimeZone.INDIA_TZ);
        System.out.println("now in India = " + timeInIndia);

        zonedDateTime = DateTime.now();
        System.out.println("zonedDateTime with default(system) timezone = " + zonedDateTime);
        System.out.println("zonedDateTime with India timezone = " + DateTime.now(TimeZone.INDIA_TZ));

        String isoFormatted = ISODateTimeFormat.dateTime().print(DateTime.now(TimeZone.INDIA_TZ));
        System.out.println("ISO Formatted = " + isoFormatted);

        DateTime utahMarch8thAt2AM = new DateTime(2015, 3, 8, 1, 0, TimeZone.UTAH_TZ);
        System.out.println("utahMarch8thAt2AM = " + utahMarch8thAt2AM);
        System.out.println("utahMarch8thAt2AM.plusHours(1) = " + utahMarch8thAt2AM.plusHours(1));
        System.out.println("utahMarch8thAt2AM.plusHours(2) = " + utahMarch8thAt2AM.plusHours(2));
    }

    private static void example9() {
        log("How to represent fixed date e.g. credit card expiry, YearMonth in Joda-Time");

        YearMonth currentYearMonth = YearMonth.now();

        System.out.printf("Days in month year %s: No of days: %s \n", currentYearMonth, currentYearMonth.monthOfYear().getAsShortText());
//        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
//        System.out.printf("Your credit card expires on %s: No of days: %s \n", creditCardExpiry, creditCardExpiry.lengthOfMonth());
    }

    private static void example10() {
        log("How to check Leap Year in Joda-Time");

        LocalDate today = LocalDate.now();
        if (today.year().isLeap()) {
            System.out.println("This year is Leap year");
        } else {
            System.out.println("2015 is not a Leap year");
        }

        if (today.withYear(2016).year().isLeap()) {
            System.out.println("2016 is Leap year");
        }

    }

    private static void example11() {
        log("How many days, month between two dates in Joda-Time");

        LocalDate today = LocalDate.now();
        LocalDate java8Release = new LocalDate(2014, DateTimeConstants.MARCH, 14);
//        Period period = Period.fieldDifference(java8Release, today);
        Period period = Period.fieldDifference(java8Release, today);
        System.out.println("Period between today and Java 8 release : " + period);
        System.out.println("Period between Java 8 release and today : " + Period.fieldDifference(today, java8Release));

        long daysBetween = Period.fieldDifference(java8Release, today).getDays();
        System.out.println("daysBetween = " + daysBetween);

        LocalDate startEmployment = new LocalDate(2010, DateTimeConstants.SEPTEMBER, 8);

        period = Period.fieldDifference(startEmployment, today);
        System.out.println("period = " + period);
        long numberOfDays = Period.fieldDifference(startEmployment, today).getDays();
        System.out.println("numberOfDays = " + numberOfDays);

        int yearsAtOctanner = 4;
        int monthsAtOctanner = 6;

        YearMonth periodAtOct = new YearMonth(yearsAtOctanner, monthsAtOctanner);
        System.out.println("periodAtOct = " + periodAtOct);

        LocalDateTime utah = LocalDateTime.now(TimeZone.UTAH_TZ);
        LocalDateTime india = LocalDateTime.now(TimeZone.INDIA_TZ);
        System.out.println("utah = " + utah);
        System.out.println("india = " + india);
        Hours betweenHours = Hours.hoursBetween(utah, india);
        Minutes betweenMins = Minutes.minutesBetween(utah, india);
        System.out.println("betweenHours = " + betweenHours.getHours());
        System.out.println("betweenMins = " + (betweenMins.getMinutes()/60.0));
    }

    private static void example12() {
        log("Date and Time with timezone offset in Joda-Time");

        LocalDateTime datetime = LocalDateTime.now();

        DateTimeZone offset = DateTimeZone.forOffsetHoursMinutes(5, 30);

        DateTime date = new DateTime(offset);

        System.out.println("OffsetDateTime.now() = " + DateTime.now(offset));
        System.out.println("OffsetDateTime.now(TimeZone.INDIA) = " + DateTime.now(TimeZone.INDIA_TZ));
        System.out.println("Date and Time: " + datetime);
        System.out.println("Date and Time with timezone offset: " + date);
    }

    private static void example13() {
        log("How to get current time stamp in Joda-Time");
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
    }

    private static void example14() {
        log("How to parse/format date in Joda-Time using predefined formatter in Joda-Time");

        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormat.forPattern("yyyyMMdd"));
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);
        System.out.println("Formatted today = " + ISODateTimeFormat.dateTime().print(LocalDateTime.now()));

        // Custom formatter
        String goodFriday = "Apr 18 2014";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM dd yyyy");
        LocalDate holiday = LocalDate.parse(goodFriday, formatter);
        System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);

        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy MMM dd 'at' HH:mm:ss z");
//        DateTimeZone offset = DateTimeZone.forOffsetHoursMinutes(5, 30);
        LocalDateTime arrivalDate = LocalDateTime.now(TimeZone.INDIA_TZ);
        String landing = format.print(arrivalDate);
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
        log("Date conversions in Joda-Time");

        // from JDK to Joda
        java.util.Date jdkDate1 = new java.util.Date();
        DateTime dt1 = new DateTime(jdkDate1);
        System.out.println("jdkDate1 = " + jdkDate1);
        System.out.println("dt1 = " + dt1);

        // from Joda to JDK
        DateTime dt2 = new DateTime();
        java.util.Date jdkDate2 = dt2.toDate();
        System.out.println("jdkDate2 = " + jdkDate2);
        System.out.println("dt2 = " + dt2);

        // from JDK to Joda
        DateTime dt3 = new DateTime(Calendar.getInstance());
        Calendar jdkCal3 = dt3.toCalendar(Locale.US);
        System.out.println("dt3 = " + dt3);
        System.out.println("jdkCal3 = " + jdkCal3);
    }


    public static void log(String message) {
        System.out.println();
        System.out.println(message);
    }
}
