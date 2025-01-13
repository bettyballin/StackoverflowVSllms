import oracle.sql.TIMESTAMPTZ;

public class TimeZoneExtractor {
    public static void main(String[] args) {
        try {
            // Assume you have a TIMESTAMPTZ object named 'tstz'
            // For the purpose of compilation, let's create a new TIMESTAMPTZ object
            TIMESTAMPTZ tstz = new TIMESTAMPTZ(new oracle.sql.TIMESTAMP(new java.sql.Date(0)), "UTC");

            // Get the bytes representation of the TIMESTAMPTZ object
            byte[] bytes = tstz.toBytes();

            // Extract the last two bytes, which contain the time zone information
            byte tzByte1 = bytes[bytes.length - 2];
            byte tzByte2 = bytes[bytes.length - 1];

            // Decode the time zone offset in minutes
            int tzOffsetMinutes = ((tzByte1 & 0xFF) << 8) | (tzByte2 & 0xFF);

            // Convert the offset to hours and minutes
            int tzOffsetHours = tzOffsetMinutes / 60;
            int tzOffsetMinutesRemaining = tzOffsetMinutes % 60;

            System.out.println("Time zone offset: " + tzOffsetHours + " hours, " + tzOffsetMinutesRemaining + " minutes");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}