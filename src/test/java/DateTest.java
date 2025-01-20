import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testIsLeapYear() {
        assertTrue(Date.isLeapYear(2000)); // Divisible by 400
        assertFalse(Date.isLeapYear(1900)); // Divisible by 100 but not 400
        assertTrue(Date.isLeapYear(2004)); // Divisible by 4 but not 100
        assertFalse(Date.isLeapYear(2001)); // Not divisible by 4
        assertTrue(Date.isLeapYear(2400)); // Divisible by 400
        assertFalse(Date.isLeapYear(2300)); // Divisible by 100 but not 400
        assertTrue(Date.isLeapYear(2028)); // Divisible by 4 but not 100
        assertFalse(Date.isLeapYear(2001)); // Not divisible by 4
    }

    @Test
    void testGetNameOfDay() {
        assertEquals("Sunday", Date.getNameOfDay(0));
        assertEquals("Monday", Date.getNameOfDay(1));
        assertEquals("Tuesday", Date.getNameOfDay(2));
        assertEquals("Wednesday", Date.getNameOfDay(3));
        assertEquals("Thursday", Date.getNameOfDay(4));
        assertEquals("Friday", Date.getNameOfDay(5));
        assertEquals("Saturday", Date.getNameOfDay(6));
    }

    @Test
    void testGetMonthNumber() {
        assertEquals(1, Date.getMonthNumber("January"));
        assertEquals(2, Date.getMonthNumber("February"));
        assertEquals(3, Date.getMonthNumber("March"));
        assertEquals(4, Date.getMonthNumber("April"));
        assertEquals(5, Date.getMonthNumber("May"));
        assertEquals(6, Date.getMonthNumber("June"));
        assertEquals(7, Date.getMonthNumber("July"));
        assertEquals(8, Date.getMonthNumber("August"));
        assertEquals(9, Date.getMonthNumber("September"));
        assertEquals(10, Date.getMonthNumber("October"));
        assertEquals(11, Date.getMonthNumber("November"));
        assertEquals(12, Date.getMonthNumber("December"));
        assertEquals(-1, Date.getMonthNumber("InvalidMonth"));
    }

    @Test
    void testGetMonthName() {
        assertEquals("January", Date.getMonthName(1));
        assertEquals("February", Date.getMonthName(2));
        assertEquals("March", Date.getMonthName(3));
        assertEquals("April", Date.getMonthName(4));
        assertEquals("May", Date.getMonthName(5));
        assertEquals("June", Date.getMonthName(6));
        assertEquals("July", Date.getMonthName(7));
        assertEquals("August", Date.getMonthName(8));
        assertEquals("September", Date.getMonthName(9));
        assertEquals("October", Date.getMonthName(10));
        assertEquals("November", Date.getMonthName(11));
        assertEquals("December", Date.getMonthName(12));
        assertEquals(-1, Date.getMonthNumber("InvalidMonth"));
    }

    @Test
    void testGetDaysInMonthWithNumbers() {
        assertEquals(31, Date.getDaysInMonth(1, 2023)); // January
        assertEquals(28, Date.getDaysInMonth(2, 2023)); // Non-leap February
        assertEquals(29, Date.getDaysInMonth(2, 2024)); // Leap February
        assertEquals(30, Date.getDaysInMonth(4, 2023)); // April
        assertEquals(30, Date.getDaysInMonth(4, 2024)); // May
        assertEquals(30, Date.getDaysInMonth(6, 2023)); // June
        assertEquals(31, Date.getDaysInMonth(7, 2023)); // July
        assertEquals(31, Date.getDaysInMonth(8, 2023)); // August
    }

    @Test
    void testGetDaysInMonthWithNames() {
        assertEquals(31, Date.getDaysInMonth("January", 2023));
        assertEquals(28, Date.getDaysInMonth("February", 2023)); // Non-leap year
        assertEquals(29, Date.getDaysInMonth("February", 2024)); // Leap year
        assertEquals(30, Date.getDaysInMonth("April", 2023));
        assertEquals(31, Date.getDaysInMonth("May", 2023)); // May
        assertEquals(30, Date.getDaysInMonth("June", 2023)); // June
        assertEquals(31, Date.getDaysInMonth("July", 2023)); // July
        assertEquals(31, Date.getDaysInMonth("August", 2023)); // August
    }

    @Test
    void testDayOfWeekWithNumbers() {
        assertEquals(0, Date.dayOfWeek(7, 23, 2023)); // Sunday
        assertEquals(1, Date.dayOfWeek(7, 24, 2023)); // Monday
        assertEquals(2, Date.dayOfWeek(4, 23, 2024)); // Sunday
        assertEquals(6, Date.dayOfWeek(11, 30, 2024)); // Monday
        assertEquals(4, Date.dayOfWeek(3, 5, 2026)); // Sunday
        assertEquals(4, Date.dayOfWeek(5, 22, 2025)); // Monday
        assertEquals(-1, Date.dayOfWeek(13, 1, 2023)); // Invalid month
        assertEquals(-1, Date.dayOfWeek(2, 30, 2023)); // Invalid day in February
    }

    @Test
    void testDayOfWeekWithNames() {
        assertEquals(0, Date.dayOfWeek("July", 23, 2023)); // Sunday
        assertEquals(1, Date.dayOfWeek("July", 24, 2023)); // Monday
        assertEquals(2, Date.dayOfWeek("April", 23, 2024)); // Sunday
        assertEquals(6, Date.dayOfWeek("November", 30, 2024)); // Monday
        assertEquals(4, Date.dayOfWeek("March", 5, 2026)); // Sunday
        assertEquals(4, Date.dayOfWeek("May", 22, 2025)); // Monday
        assertEquals(-1, Date.dayOfWeek("Sepetembereee", 1, 2023)); // Invalid month
    }

    @Test
    void testGetMonthOffset() {
        assertEquals(3, Date.getMonthOffset(2, 2023)); // February
        assertEquals(6, Date.getMonthOffset(4, 2023)); // April
        assertEquals(1, Date.getMonthOffset(5, 2023)); // May
        assertEquals(-1, Date.getMonthOffset(13, 2023)); // Invalid month
    }
}