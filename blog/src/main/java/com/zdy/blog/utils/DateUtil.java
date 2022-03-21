package com.zdy.blog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String DATE_PATTERN_DEFAULT = "yyyy-MM-dd";

    public static final String DATE_PATTERN_TIME = "HH:mm:ss";

    public static final String DATE_PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    public final static String newDate(Date str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN_DATETIME);
        String date = simpleDateFormat.format(str);
        /*try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        return date;
    }
}
