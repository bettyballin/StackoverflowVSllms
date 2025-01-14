import java.lang.String;

public final class Date {

    private int year;
    private int month;
    private int day;

    // Private constructor to force use of factory methods or fluent API
    private Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static Date valueOfYearMonthDay(int year, int month, int day) {
        return new Date(year, month, day);
    }

    public static Date yearMonthDay(int year, int month, int day) {
        return valueOfYearMonthDay(year, month, day);
    }

    public static Date ymd(int year, int month, int day) {
        return valueOfYearMonthDay(year, month, day);
    }

    public static Date date(int year, int month, int day) {
        return valueOfYearMonthDay(year, month, day);
    }

    // Fluent API
    public static MonthSelector january() { return new MonthSelector(1); }
    public static MonthSelector february() { return new MonthSelector(2); }
    // ... Add for other months

    public static class MonthSelector {
        private int month;

        private MonthSelector(int month) {
            this.month = month;
        }

        public DaySelector the(int day) {
            return new DaySelector(month, day);
        }
    }

    public static class DaySelector {
        private int day;
        private int month;

        private DaySelector(int month, int day) {
            this.day = day;
            this.month = month;
        }

        public Date in(int year) {
            return new Date(year, month, day);
        }
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    public static void main(String[] args) {
    }
}