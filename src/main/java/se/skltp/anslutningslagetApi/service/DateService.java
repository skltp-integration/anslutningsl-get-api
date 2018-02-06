package se.skltp.anslutningslagetApi.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface DateService {
    DateFormat df_short = new SimpleDateFormat("yyyyMMdd");
    DateFormat df_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

}
