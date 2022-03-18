package fr.istic.vv;

class Date implements Comparable<Date> {
    int day;
    int month;
    int year;

    public Date(int day, int month, int year) {
        if(!isValidDate(day, month, year))
            throw new IllegalArgumentException("This date is not valid.");
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static int[] getMonths(int year) {
        int[] months;
        if(!isLeapYear(year))
            months = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        else
            months = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
        return months;
    }

    public static boolean isValidDate(int day, int month, int year) {
        int[] months = getMonths(year);
        if(month < 1 || month > 12) return false;
        if(year < 0) return false;
        return day >= 0 && day <= months[month];
    }

    public static boolean isLeapYear(int year) {
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
        if(isValidDate(months[month - 1], month + 1, year))
            return new Date(months[month - 1], month + 1, year);
        return new Date(31,  12, year - 1);
    }

    public int compareTo(Date other) {
        if(this.year == other.year && this.month == other.month && this.day == other.day)
            return 0;
        if(this.year == other.year && this.month == other.month)
            return this.day > other.day ? 1 : -1;
        if(this.year == other.year)
            return this.month > other.month ? 1 : -1;
        return this.year > other.year ? 1 : -1;
    }
}