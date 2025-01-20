/**
 * This class provides various static methods that calculate various quantities
 * related to dates, including the day of week a date fall on.
 * @author
 * @version
 */
public class Date {
    /**
     * Returns true if the year is a leap year; otherwise false
     * @param year the year
     * @return true if the year is a leap year; otherwise false.
     */
    public static boolean isLeapYear(int year){
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return true;
        }
        return false;
    }

    /**
     * Returns the name of the day given by dayValue
     * @param dayValue Numerical value of the day in the range 0 to 6, inclusively
     * @return the name of the day given by dayValue
     */
    public static String getNameOfDay(int dayValue){
        String dayName = "Saturday";
        dayValue %= 7;
        if (dayValue < 0){
            dayValue = (dayValue % 7) + 7;
        }

        if (dayValue == 0) {
            dayName = "Sunday";
        } else if (dayValue == 1){
            dayName = "Monday";
        } else if (dayValue == 2){
            dayName = "Tuesday";
        } else if (dayValue == 3){
            dayName = "Wednesday";
        } else if (dayValue == 4){
            dayName = "Thursday";
        } else if (dayValue == 5){
            dayName = "Friday";
        }
        return dayName;
    }

    /**\
     * Returns the numeric value of the month.
     *   1 - January
     *   2 - February
     *   ...
     *   12 - December
     * @param name name of the month
     * @return the numeric value of the month.
     */
    public static int getMonthNumber(String name){
        int monthNumber = -1;

        if (name.equalsIgnoreCase("january")) {
            monthNumber = 1;
        } else if (name.equalsIgnoreCase("february")) {
            monthNumber = 2;
        } else if (name.equalsIgnoreCase("march")) {
            monthNumber = 3;
        } else if (name.equalsIgnoreCase("april")) {
            monthNumber = 4;
        } else if (name.equalsIgnoreCase("may")) {
            monthNumber = 5;
        } else if (name.equalsIgnoreCase("june")) {
            monthNumber = 6;
        } else if (name.equalsIgnoreCase("july")) {
            monthNumber = 7;
        } else if (name.equalsIgnoreCase("august")) {
            monthNumber = 8;
        } else if (name.equalsIgnoreCase("september")) {
            monthNumber = 9;
        } else if (name.equalsIgnoreCase("october")) {
            monthNumber = 10;
        } else if (name.equalsIgnoreCase("november")) {
            monthNumber = 11;
        } else if (name.equalsIgnoreCase("december")) {
            monthNumber = 12;
        }
        return monthNumber;
    }

    /**
     * Returns the name of the month given the numeric value provided by month
     *      1 - January
     *      2 - February
     *      ...
     *      12 - December
     * @param month Numeric value of the month.  Should be 1 to 12, inclusively
     * @return the name of the month given the numeric value provided by month
     */
    public static String getMonthName(int month){
        switch(month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return "";
    }

    /**
     * Returns the number of days in the month given by the parameter month
     * @param month the numeric value of the month
     * @param year year
     * @return the number of days in the month given by the parameter month
     */
    public static int getDaysInMonth(int month, int year){
        int daysInMonth = -1;

        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = 31;
                break;
            case 2:
                daysInMonth = 28;
                if (isLeapYear(year)){
                    daysInMonth += 1;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
        }
        return daysInMonth;
    }

    /**
     * Returns the number of days in the month given by the parameter month
     * @param month the name of the month
     * @param year year
     * @return the number of days in the month
     */
    public static int getDaysInMonth(String month, int year){
        return getDaysInMonth(getMonthNumber(month), year);
    }

    /**
     * Returns the offset in days for the month relative to January
     * @param month numeric value of the month
     * @param year year
     * @return the offset in days for the month relative to January
     */
    public static int getMonthOffset(int month, int year){
        if (month < 1 || month > 12){
            return -1;
        }
        int offset = 0;

        switch(month){
            case 2:
            case 3:
            case 11:
                offset = 3;
                break;
            case 4:
            case 7:
                offset = 6;
                break;
            case 5:
                offset = 1;
                break;
            case 6:
                offset = 4;
                break;
            case 8:
                offset = 2;
                break;
            case 9:
            case 12:
                offset = 5;
                break;
        }

        if (isLeapYear(year) && month > 2){
            offset += 1;
        }
        return offset;
    }

    /**
     * Returns the day of the week that the date falls on
     * @param month numeric value of the month
     * @param dayOfMonth day of the month
     * @param year year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(int month, int dayOfMonth, int year){
        if (month < 1 || month > 12 || dayOfMonth < 0 || dayOfMonth > getDaysInMonth(month, year)){
            return -1;
        }
        int dow = ( year + (year - 1)/4 - (year -1)/100 + (year - 1)/400 ) % 7;
        dow = (dow + getMonthOffset(month, year)) % 7;
        dow = (dow + dayOfMonth - 1) % 7;
        return dow;
    }

    /**
     * Returns the day of the week that the date falls on
     * @param month name of the month
     * @param dayOfMonth day of the month
     * @param year year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(String month, int dayOfMonth, int year){
        return dayOfWeek(getMonthNumber(month), dayOfMonth, year);
    }
}
