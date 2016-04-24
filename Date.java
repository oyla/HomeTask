/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Oyla
 */
class Date {

    private int day;
    private int month;
    private int year;
    private GregorianCalendar today = new GregorianCalendar();
    static private String[] ttlMonths = {
        "Jan", "Feb", "Mar", "Apr",
        "Мау", "Jun", "Jul", "Aug",
        "Sep", "Oct", "Nov", "Dec"
    };
    static private int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date() {
        setTodayDate();
    }

    public Date(int day, int month, int year) {
        if (!(setYear(year) && setMonth(month) && setDay(day))) {
            setTodayDate();
        }
    }

    public Date(String dateString) {
        Pattern p = Pattern.compile("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$");
        Matcher m = p.matcher(dateString);
        if (m.find()) {
            String[] dateArray = dateString.split("-");
            if (!(setYear(Integer.parseInt(dateArray[0])) && setMonth(Integer.parseInt(dateArray[1])) && setDay(Integer.parseInt(dateArray[2])))) {
                setTodayDate();
            }
        } else {
            setTodayDate();
        }
    }

    public void setTodayDate() {
        day = today.get(Calendar.DATE);
        month = today.get(Calendar.MONTH);
        year = today.get(Calendar.YEAR);
    }

    public boolean setYear(int year) {
        if (year > 1900 && year <= today.get(Calendar.YEAR)) {
            this.year = year;
            return true;
        }
        return false;
    }

    public boolean setMonth(int month) {
        if (month > 0 && month <= ttlMonths.length) {
            this.month = month - 1;
            return true;
        }
        return false;
    }

    public boolean setDay(int day) {
        daysInMonths[1] = (year % 4 == 0) ? 29 : 28;
        if (day > 0 && day <= daysInMonths[month]) {
            this.day = day;
            return true;
        }
        return false;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month + 1;
    }

    public String getStringMonth() {
        return ttlMonths[month];
    }

    public int getDay() {
        return day;
    }

    public int defineDaysDifference(int day2) {
        return Math.abs(day - day2);
    }

    public int defineDaysDifference(Date d2) {
        return Math.abs(day - d2.getDay());
    }

    public Date moveDayByStep(int step) {
        day += step;
        while (day > daysInMonths[month]) {
            day -= daysInMonths[month];
            month++;
            if (month == ttlMonths.length) {
                month = 0;
                year++;
            }
        }
        while (day <= 0) {
            month--;
            if (month < 0) {
                month = ttlMonths.length - 1;
                year--;
            }
            day = daysInMonths[month] + day;
        }
        return this;
    }

    public String showDate() {
        return day + " " + ttlMonths[month] + " " + year;
    }
}
