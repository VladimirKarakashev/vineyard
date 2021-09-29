package com.vtk.vineyard.util;

import java.util.Calendar;

public class CalendarGenerator {

    public static String generateYearIndex(){
        Calendar now = Calendar.getInstance();
        String currentYearIndex = now.get(Calendar.YEAR) + "";
        return currentYearIndex;
    }

    public static String generateMonthIndex(){
        String[] strMonth = new String[]{
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12"
        };
        Calendar now = Calendar.getInstance();
        String currentMonthIndex = strMonth[now.get(Calendar.MONTH)];
        return currentMonthIndex;
    }

    public static String generateDayIndex(){
        String[] strMonthDays = new String[] {
                "01","02","03","04","05","06","07","08","09","10",
                "11","12","13","14","15","16","17","18","19","20",
                "21","22","23","24","25","26","27","28","29","30","31"
        };
        Calendar now = Calendar.getInstance();
        String currentDayIndex = strMonthDays[now.get(Calendar.DAY_OF_MONTH) - 1];
        return currentDayIndex;
    }

    public static String generateMothName(){
        String[] strMonths = new String[] {
                "Януари", "Февруари", "Март", "Април", "Май", "Юни", "Юли",
                "Август", "Септември", "Октомври", "Ноември", "Декември"
        };
        Calendar now = Calendar.getInstance();
        String monthName = strMonths[now.get(Calendar.MONTH)];
        return monthName;
    }

    public static String generateDayName(){
        String[] strDayNames = new String[] {
                "Неделя", "Понеделник", "Вторник", "Сряда", "Четвъртък",
                "Петък", "Събота"
        };
        Calendar now = Calendar.getInstance();
        String dayName = strDayNames[now.get(Calendar.DAY_OF_WEEK) - 1];
        System.out.println(dayName);
        return dayName;
    }

    public static String specifficDateFormat(){
        String nameOfDay = generateDayName();
        String day = generateDayIndex();
        String month = generateMonthIndex();
        String year = generateYearIndex();
        String specDate =
                nameOfDay
                + ", "
                + day
                + "."
                + month
                + "."
                + year
                + "г.";
        return specDate;
    }

}
