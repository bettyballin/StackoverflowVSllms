public class GetIMEI {
    public static void main(String[] args) {
        String imei = System.getProperty("com.nokia.mid.imei");
        if (imei == null) {
            imei = System.getProperty("IMEI");
        }
        if (imei == null) {
            imei = System.getProperty("com.sonyericsson.imei");
        }

        System.out.println("IMEI: " + imei);
    }
}