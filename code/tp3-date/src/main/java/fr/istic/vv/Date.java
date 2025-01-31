package fr.istic.vv;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if(!isValidDate(day, month, year))
            throw new IllegalArgumentException("This date is not valid.");
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Get the number of days for each month based on the year
    public int[] getMonths(int year) {
        if(!isLeapYear(year))
            return new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        else
           return new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
    }

    public boolean isValidDate(int day, int month, int year) {
        int[] months = getMonths(year);
        if(month < 1 || month > 12) return false;
        if(year < 0) return false;
        return day >= 1 && day <= months[month];
    }

    public boolean isLeapYear(int year) {
        if(year % 400 == 0)
            return true;
        else if (year % 100 == 0)
            return false;
        else return year % 4 == 0;
    }

    public Date nextDate() {
        if(isValidDate(day + 1, month, year))
            return new Date(day + 1, month, year);
        if(isValidDate(1, month + 1, year))
            return new Date(1, month + 1, year);
        return new Date(1,  1, year + 1);
    }

    public Date previousDate() {
        int[] months = getMonths(year);
        if(isValidDate(day - 1, month, year))
            return new Date(day - 1, month, year);
        if(isValidDate(months[month - 1], month - 1, year))
            return new Date(months[month - 1], month - 1, year);
        return new Date(31,  12, year - 1);
    }

    public int compareTo(Date other) {
        if(other == null)
            throw new NullPointerException("Date is null.");
        if(this.year == other.year && this.month == other.month && this.day == other.day)
            return 0;
        if(this.year == other.year && this.month == other.month)
            return this.day > other.day ? 1 : -1;
        if(this.year == other.year)
            return this.month > other.month ? 1 : -1;
        return this.year > other.year ? 1 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Date)) return false;
        Date date = (Date) o;
        return date.year == this.year && date.month == this.month && date.day == this.day;
    }
}