public class ImeiRetriever {
    public static void main(String[] args) {
        try {
            // Attempting to get the IMEI number using a manufacturer-specific System Property.
            String imei = System.getProperty("com.nokia.device.imei");
            if (imei == null || imei.trim().isEmpty()) {
                imei = System.getProperty("DeviceID");  // Try another common property name
            }
            if (imei != null && !imei.trim().isEmpty()) {
                System.out.println("IMEI: " + imei);
            } else {
                System.out.println("IMEI could not be retrieved.");
            }
        } catch (SecurityException e) {
            System.out.println("Access to IMEI is restricted due to security settings.");
        }
    }
}