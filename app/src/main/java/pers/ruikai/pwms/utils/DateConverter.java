package pers.ruikai.pwms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * class to convert Date to String or convert String to Date
 *
 *
 */
public class DateConverter {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * convert string to date
     * @param s the string to be converted, in format of "yyyy-MM-dd"
     * @return corresponding Date object
     * @throws ParseException error in parsing
     */
    public static Date string2Date(String s) throws ParseException {
        return sdf.parse(s);
    }

    /**
     * convert date to string
     * @param date Date object
     * @return string in "yyyy-MM-dd" format
     */
    public static String date2String(Date date) {
        return sdf.format(date);
    }
}
