/*
 * Decompiled with CFR 0.152.
 */
public class AuthenticatorUtil {
    String secretKey = "your_secret_key_here";
    String qrCodeUrl = "https://chart.googleapis.com/chart?chs=200x200&cht=qr&choe=UTF-8&chl=otpauth://totp/your_service_name?secret=" + this.secretKey + "&issuer=your_service_name";

    public static void main(String[] stringArray) {
        AuthenticatorUtil authenticatorUtil = new AuthenticatorUtil();
        System.out.println(authenticatorUtil.qrCodeUrl);
    }
}
