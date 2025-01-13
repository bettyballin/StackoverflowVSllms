public class Time {
    public int year;
    public int month;
    public int day;

    public static Time getCurrentTime() {
        Time time = new Time();
        time.year = 2023;
        time.month = 10;
        time.day = 1;
        return time;
    }

    public static void main(String[] args) {
        Time time = getCurrentTime();
        System.out.println(time.year);  // prints "2023"
    }
}