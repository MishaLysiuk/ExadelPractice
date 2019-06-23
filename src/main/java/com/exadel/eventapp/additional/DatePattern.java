package com.exadel.eventapp.additional;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePattern {
    public static String currentDate(Long millisec, String dateFormat){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Date currentDate = new Date(millisec);
        return simpleDateFormat.format(currentDate);
    }
}
