package com.nnikolov.jiradump.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Helper classes for working with date and time
 */
public abstract class DateUtils {

    private DateUtils() {
    }

    /**
     * Stringifies a timestamp that is the start of the current week.
     * Blanks and columns are replaces for environment compatibility
     *
     * @return stringified timestamp
     */
    public static String stringifyStartOfWeek() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        return new Date(cal.getTimeInMillis()).toString()
                .replaceAll(" ", "_")
                .replaceAll(":", "-");
    }
}
