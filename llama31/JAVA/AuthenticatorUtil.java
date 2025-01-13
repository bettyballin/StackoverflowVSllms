import java.lang.String;

public class AuthenticatorUtil {
    // Generate a secret key for the authenticator app
    String secretKey = "your_secret_key_here";

    // Generate a QR code for the user to scan
    String qrCodeUrl = "https://chart.googleapis.com/chart?chs=200x200&cht=qr&choe=UTF-8&chl=otpauth://totp/your_service_name?secret=" + secretKey + "&issuer=your_service_name";

    public static void main(String[] args) {
        // Create an instance of the class to avoid static context issues
        AuthenticatorUtil authUtil = new AuthenticatorUtil();
        System.out.println(authUtil.qrCodeUrl);
    }
}