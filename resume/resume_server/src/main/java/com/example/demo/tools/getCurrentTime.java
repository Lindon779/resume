package com.example.demo.tools;

public class getCurrentTime {

    public String getTime() {
        java.util.Locale locale=java.util.Locale.CHINA;
        String pattern = "yyyy-MM-dd kk:mm:ss";
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(pattern,locale);
        java.util.Date date = new java.util.Date();
        String bjTime = df.format(date);
        return bjTime;
    }

}
