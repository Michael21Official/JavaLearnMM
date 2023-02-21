package com.fo4ik.dates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dates {
    public static void main(String[] args) throws Exception {
        //Date is a class that represents a specific instant in time, with millisecond precision.
        Date date = new Date();
        System.out.println(date);

        System.out.println("========================================");
        /*Calendar is an abstract class that provides methods for converting between a specific instant in time and a set of calendar fields such as
         YEAR, MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar fields, such as getting the date of the next week.*/
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar.getTime());

        System.out.println("========================================");
        //DateFormat is an abstract class for date/time formatting subclasses which formats and parses dates or time in a language-independent manner.
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(dateFormat.format(date));

        System.out.println("========================================");
        //SimpleDateFormat is a concrete class for formatting and parsing dates in a locale-sensitive manner.
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss \n" + "dd.MM.yyyy");
        System.out.println(simpleDateFormat.format(date));

        System.out.println("========================================");
        //Parse date
        Date date1 = simpleDateFormat.parse("12:00:00 \n" + "12.12.2012");
        System.out.println(date1);
    }
}
