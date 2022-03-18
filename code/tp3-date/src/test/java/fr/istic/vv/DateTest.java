package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    private Date date;

    @BeforeEach
    void setUp() {
        date = new Date(20, 3, 2022);
    }

    @Test
    public void checkIfLeapYearIsLeap() {
        assertTrue(date.isLeapYear(1912));
        assertTrue(date.isLeapYear(1992));
        assertTrue(date.isLeapYear(2020));
        assertTrue(date.isLeapYear(2024));
        assertTrue(date.isLeapYear(2044));
    }

    @Test
    public void checkIfLeapYearIsNotLeapForRandomYears() {
        assertFalse(date.isLeapYear(1977));
        assertFalse(date.isLeapYear(2147));
        assertFalse(date.isLeapYear(2301));
    }

    @Test
    public void checkIfLeapYearIsNotLeapForSpecificYears() {
        assertFalse(date.isLeapYear(1900));
        assertFalse(date.isLeapYear(2100));
        assertFalse(date.isLeapYear(2200));
        assertFalse(date.isLeapYear(2300));
    }

    @Test
    public void checkGetMonthsForLeapYears() {
        int[] months = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
        assertArrayEquals(date.getMonths(1912), months);
        assertArrayEquals(date.getMonths(1992), months);
        assertArrayEquals(date.getMonths(2020), months);
        assertArrayEquals(date.getMonths(2024), months);
    }

    @Test
    public void checkGetMonthsForNotLeapYears() {
        int[] months = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        assertArrayEquals(date.getMonths(1943), months);
        assertArrayEquals(date.getMonths(1973), months);
        assertArrayEquals(date.getMonths(2021), months);
        assertArrayEquals(date.getMonths(2047), months);
    }

    @Test
    public void checkIfDateIsValid() {
        assertTrue(date.isValidDate(12, 03, 1947));
        assertTrue(date.isValidDate(25, 8, 1957));
    }

    @Test
    public void checkIfDateIsNOTValid() {
        assertFalse(date.isValidDate(-12, 03, 1947));
        assertFalse(date.isValidDate(25, 8, -1957));
        assertFalse(date.isValidDate(25, 14, 1957));
        assertFalse(date.isValidDate(25, -8, 1957));
    }

    @Test
    public void checkValidDateForLeapYear() {
        assertTrue(date.isValidDate(29, 2, 2020));
        assertTrue(date.isValidDate(29, 2, 2024));
        assertFalse(date.isValidDate(29, 2, 1941));
    }

    @Test
    public void checkNextDate() {
        Date date1 = new Date(23, 3, 1945);
        Date date2 = new Date(31, 3, 1945);
        Date date3 = new Date(31, 12, 1945);
        assertEquals(date1.nextDate(), new Date(24, 3, 1945));
        assertEquals(date2.nextDate(), new Date(1, 4, 1945));
        assertEquals(date3.nextDate(), new Date(1, 1, 1946));
    }

    @Test
    public void checkPreviousDate() {
        Date date1 = new Date(23, 3, 1945);
        Date date2 = new Date(1, 3, 1945);
        Date date3 = new Date(1, 1, 1945);
        assertEquals(date1.previousDate(), new Date(22, 3, 1945));
        assertEquals(date2.previousDate(), new Date(28, 2, 1945));
        assertEquals(date3.previousDate(), new Date(31, 12, 1944));
    }
}