public class TimeZoneConverter {
    // assume 'userTimezoneOffset' is the user's timezone offset in minutes
    // and 'eventTimeUtc' is the event time in seconds from midnight UTC
    public static void main(String[] args) {
        int userTimezoneOffset = 0; // example value
        int eventTimeUtc = 0; // example value
        int userTime = eventTimeUtc + (userTimezoneOffset * 60);
        System.out.println(userTime);
    }
}