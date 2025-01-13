/*
 * Decompiled with CFR 0.152.
 */
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class OAuthSignatureGenerator {
    public static String generateSignature(String string, String string2, String string3, String string4, String string5, String string6, String ... stringArray) throws Exception {
        String string7 = OAuthSignatureGenerator.getConcatenatedParams(stringArray);
        String string8 = string + "&" + URLEncoder.encode(string2, "UTF-8") + "&" + URLEncoder.encode(string7, "UTF-8");
        String string9 = string4 + "&" + (string6 != null ? string6 : "");
        Mac mac = Mac.getInstance("HmacSHA1");
        SecretKeySpec secretKeySpec = new SecretKeySpec(string9.getBytes(StandardCharsets.UTF_8), "HmacSHA1");
        mac.init(secretKeySpec);
        byte[] byArray = mac.doFinal(string8.getBytes(StandardCharsets.UTF_8));
        String string10 = Base64.getEncoder().encodeToString(byArray);
        return string10;
    }

    private static String getConcatenatedParams(String ... stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
    }
}
