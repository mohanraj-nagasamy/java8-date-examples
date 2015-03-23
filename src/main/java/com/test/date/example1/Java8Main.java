package com.test.date.example1;

import com.test.date.Print;
import com.test.date.PrintDoc;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static com.test.date.Value.INDIA;
import static com.test.date.Value.UTAH;

@PrintDoc("Example 1 - How to get today's date in Java 8")
public class Java8Main {


    public static void main(String[] args) {
        Print.me((Java8Main.class));

        System.out.println("INDIA = " + INDIA);

        System.out.println("LocalDate.now(Today)   = " + LocalDate.now());
        System.out.println("LocalDate.now(INDIA)   = " + LocalDate.now(INDIA));
        System.out.println("Instant.now()          = " + Instant.now(Clock.systemDefaultZone()));
        System.out.println("LocalDateTime.now()    = " + LocalDateTime.now());
        System.out.println("LocalDateTime.now(INDI)= " + LocalDateTime.now(INDIA));
        System.out.println("LocalDateTime.now(MST) = " + Instant.now().atZone(ZoneId.of(ZoneId.SHORT_IDS.get("MST"))));
        System.out.println("LocalDateTime.now(PST) = " + Instant.now().atZone(ZoneId.of(ZoneId.SHORT_IDS.get("PST"))));
        System.out.println("LocalDateTime.now(EST) = " + Instant.now().atZone(ZoneId.of(ZoneId.SHORT_IDS.get("EST"))));
        System.out.println("LocalDateTime.now(CST) = " + Instant.now().atZone(ZoneId.of(ZoneId.SHORT_IDS.get("CST"))));
        System.out.println("LocalDateTime.now(India= " + Instant.now().atZone(INDIA));
        System.out.println("-----------");

        System.out.println("Clock.systemDefaultZone()        = " + Clock.systemDefaultZone().instant());
        System.out.println("Clock.systemUTC()                = " + Clock.systemUTC().instant());
        System.out.println("Clock.system(ZoneId.of(\"PST\"))   = " + Clock.system(ZoneId.of(ZoneId.SHORT_IDS.get("PST"))).instant());
        System.out.println("Clock.system(ZoneId.of(\"CST\"))   = " + Clock.system(ZoneId.of(ZoneId.SHORT_IDS.get("CST"))).instant());
        System.out.println("-----------");

        System.out.println("LocalDate.now() = " + LocalDate.now().plus(10, ChronoUnit.MONTHS));
        System.out.println("(new Date()) = " + (new Date()));
        System.out.println("LocalDate.now().plusMonths(1) = " + LocalDate.now().plusMonths(1));
        System.out.println("-----------");

        System.out.println("LocalDate.now() = " + LocalDateTime.now().plus(10, ChronoUnit.MONTHS));
        System.out.println("LocalDate.now().plusMonths(1) = " + LocalDateTime.now().plusMonths(1));
        System.out.println("-----------");

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        // Jump to 25 hours and 3 minutes into the future
        LocalDateTime inTheFuture = localDateTime.plusHours(25).plusMinutes(3);
        System.out.println("inTheFuture = " + inTheFuture);
        // We could do the same on localTime or localDate
        System.out.println(localDateTime.toLocalTime().plusHours(25).plusMinutes(3));
        System.out.println(localDateTime.toLocalDate().plusMonths(2));

        // We could also use TemportalAmount (in this case a Duration and Period)
        System.out.println(localDateTime.toLocalTime().plus(Duration.ofHours(25).plusMinutes(3)));
        System.out.println(localDateTime.toLocalDate().plus(Period.ofMonths(2)));
        System.out.println("-----------");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime usTenTen = now.withHour(10).withMinute(10).withSecond(10);
        System.out.println("usTenTen = " + usTenTen);

        LocalDateTime india = now.now(INDIA);
        LocalDateTime indiaTenTen = india.withDayOfMonth(19).withHour(10).withMinute(10).withSecond(10);
        System.out.println("indiaTenTen = " + indiaTenTen);

        System.out.println("usTenTen.toLocalTime() = " + usTenTen.toLocalTime());
        System.out.println("indiaTenTen.toLocalTime() = " + indiaTenTen.toLocalTime());

        Instant usInstant = usTenTen.atZone(UTAH).toInstant();
        Instant indiaInstant = indiaTenTen.atZone(INDIA).toInstant();

        System.out.println("usInstant = " + usInstant);
        System.out.println("indiaInstant = " + indiaInstant);

        long betweenHours = ChronoUnit.HOURS.between(usInstant, indiaInstant);
        long betweenMins = ChronoUnit.MINUTES.between(usInstant, indiaInstant);
//        long betweenMins = ChronoUnit.between(usInstant, indiaInstant);
        System.out.println("betweenHours = " + betweenHours);
        System.out.println("betweenMins = " + (betweenMins/60.0));
        System.out.println("Duration.between(usInstant, indiaInstant) = " + Duration.between(indiaInstant, usInstant));

        ZonedDateTime localTimeZone = ZonedDateTime.now(INDIA);
        System.out.println("localTimeZone = " + localTimeZone);

        System.out.println("OffsetTime.now()     = " + OffsetTime.now());
        System.out.println("OffsetDateTime.now() = " + OffsetDateTime.now());

        Period period = Period.of(3, 2, 1);
        System.out.println("period = " + period.toString());


        System.out.println("Instant.now().plus(1, ChronoUnit.MONTHS) = " + Instant.now().plus(1, ChronoUnit.DAYS));
    }
}
