/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class TrackingNumberPattern {
    private static final Pattern pattern = Pattern.compile("^(1Z[0-9A-Z]{6,10}|FC[0-9A-Z]{10,12}|JD[0-9A-Z]{10,12}|9400[0-9A-Z]{10,12}|AJ[0-9A-Z]{10,12})");

    public static boolean isValidTrackingNumber(String string) {
        return pattern.matcher(string).matches();
    }

    public static void main(String[] stringArray) {
        System.out.println(TrackingNumberPattern.isValidTrackingNumber("1Z12345678901234"));
        System.out.println(TrackingNumberPattern.isValidTrackingNumber("FC123456789012"));
        System.out.println(TrackingNumberPattern.isValidTrackingNumber("JD123456789012"));
        System.out.println(TrackingNumberPattern.isValidTrackingNumber("940011234567890"));
        System.out.println(TrackingNumberPattern.isValidTrackingNumber("AJ123456789012"));
        System.out.println(TrackingNumberPattern.isValidTrackingNumber("InvalidTrackingNumber"));
    }
}
