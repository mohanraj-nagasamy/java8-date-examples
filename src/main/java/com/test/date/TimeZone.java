package com.test.date;

import org.joda.time.DateTimeZone;

import java.time.ZoneId;

public class TimeZone {
    public static final ZoneId INDIA = ZoneId.of("Asia/Kolkata");
    public static final ZoneId UTAH = ZoneId.of("America/Denver");
    public static final ZoneId NEW_YORK = ZoneId.of("America/New_York");

    public static final DateTimeZone INDIA_TZ = DateTimeZone.forID(INDIA.getId());
    public static final DateTimeZone UTAH_TZ = DateTimeZone.forID(UTAH.getId());
    public static final DateTimeZone NEW_YORK_TZ = DateTimeZone.forID(NEW_YORK.getId());

}
