package pers.ruikai.pwms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static Date string2Date(String s) throws ParseException {
        return sdf.parse(s);
    }

    public static String date2String(Date date) {
        return sdf.format(date);
    }
}
