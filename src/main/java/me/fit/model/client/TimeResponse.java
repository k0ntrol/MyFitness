package me.fit.model.client;

import java.util.Date;

public class TimeResponse {

    private float year;
    private float month;
    private float day;
    private float hour;
    private float minute;
    private float seconds;
    private float milliSeconds;
    private String dateTime;
    private String date;
    private String time;
    private String timeZone;
    private String dayOfWeek;
    private boolean dstActive;

    public TimeResponse() {
        super();
    }

    public TimeResponse(float year, float month, float day, float hour, float minute, float seconds, float milliSeconds,String dateTime, String date, String time, String timeZone, String dayOfWeek, boolean dstActive) {

        super();
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.seconds = seconds;
        this.milliSeconds = milliSeconds;
        this.dateTime = dateTime;
        this.date = date;
        this.time = time;
        this.timeZone = timeZone;
        this.dayOfWeek = dayOfWeek;
        this.dstActive = dstActive;
    }

    public float getYear() {
        return year;
    }

    public void setYear(float year) {
        this.year = year;
    }

    public float getMonth() {
        return month;
    }

    public void setMonth(float month) {
        this.month = month;
    }

    public float getDay() {
        return day;
    }

    public void setDay(float day) {
        this.day = day;
    }

    public float getHour() {
        return hour;
    }

    public void setHour(float hour) {
        this.hour = hour;
    }

    public float getMinute() {
        return minute;
    }

    public void setMinute(float minute) {
        this.minute = minute;
    }

    public float getSeconds() {
        return seconds;
    }

    public void setSeconds(float seconds) {
        this.seconds = seconds;
    }

    public float getMilliSeconds() {
        return milliSeconds;
    }

    public void setMilliSeconds(float milliSeconds) {
        this.milliSeconds = milliSeconds;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isDstActive() {
        return dstActive;
    }

    public void setDstActive(boolean dstActive) {
        this.dstActive = dstActive;
    }

    @Override
    public String toString() {
        return "TimeResponse{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", seconds=" + seconds +
                ", milliSeconds=" + milliSeconds +
                ", dateTime='" + dateTime + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", dstActive=" + dstActive +
                '}';
    }
}
