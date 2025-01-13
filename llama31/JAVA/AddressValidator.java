import java.lang.String;
import java.util.regex.Pattern;

public class AddressValidator {
    private static final Pattern STREET_NUMBER_PATTERN = Pattern.compile("^[0-9]+([A-Za-z]+)?$");
    private static final Pattern ZIP_CODE_PATTERN = Pattern.compile("^[0-9]{5}(-[0-9]{4})?$");

    public boolean isValidAddress(String streetNumber, String streetName, String city, String state, String zipCode) {
        // Normalize input data
        streetNumber = streetNumber.trim().toUpperCase();
        streetName = streetName.trim().toUpperCase();
        city = city.trim().toUpperCase();
        state = state.trim().toUpperCase();
        zipCode = zipCode.trim().toUpperCase();

        // Check for valid components
        if (streetNumber.isEmpty() || streetName.isEmpty() || city.isEmpty() || state.isEmpty() || zipCode.isEmpty()) {
            return false;
        }

        // Validate ZIP code
        if (!ZIP_CODE_PATTERN.matcher(zipCode).matches()) {
            return false;
        }

        // Perform regex checks
        if (!STREET_NUMBER_PATTERN.matcher(streetNumber).matches()) {
            return false;
        }

        // Use third-party API (example: USPS Web API)
        // USPSApi api = new USPSApi();
        // if (!api.validateAddress(streetNumber, streetName, city, state, zipCode)) {
        //     return false;
        // }

        return true;
    }

	public static void main(String[] args) {
	}
}