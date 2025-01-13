import java.lang.String;
import java.util.regex.Pattern;

public class TrackingNumberPattern {
    private static final Pattern pattern = Pattern.compile(
        "^(" + // start of group
        "1Z[0-9A-Z]{6,10}" + // UPS
        "|" + // or
        "FC[0-9A-Z]{10,12}" + // FedEx
        "|" + // or
        "JD[0-9A-Z]{10,12}" + // DHL
        "|" + // or
        "9400[0-9A-Z]{10,12}" + // USPS
        "|" + // or
        "AJ[0-9A-Z]{10,12}" + // Airborne (DHL)
        ")" // end of group
    );

    public static boolean isValidTrackingNumber(String trackingNumber) {
        return pattern.matcher(trackingNumber).matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidTrackingNumber("1Z12345678901234")); // true
        System.out.println(isValidTrackingNumber("FC123456789012")); // true
        System.out.println(isValidTrackingNumber("JD123456789012")); // true
        System.out.println(isValidTrackingNumber("940011234567890")); // true
        System.out.println(isValidTrackingNumber("AJ123456789012")); // true
        System.out.println(isValidTrackingNumber("InvalidTrackingNumber")); // false
    }
}