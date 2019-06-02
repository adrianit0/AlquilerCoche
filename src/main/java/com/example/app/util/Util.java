package com.example.app.util;

import java.sql.Date;

public class Util {

    public static Date stringToDate(String dateString) {
        return Date.valueOf(dateString);
    }

    public static String dateToString (Date date) {
        return date.toString();
    }

}
