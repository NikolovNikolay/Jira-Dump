package com.nnikolov.jiradump.utils;

import java.util.Calendar;
import java.util.Date;

public abstract class DateUtils {

    private DateUtils() {
    }

    public static String stringifyStartOfWeek() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

        return new Date(cal.getTimeInMillis()).toString().replaceAll(" ", "_").replaceAll(":", "-");
    }
}
