/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class DigestAuth_1 {
    public static void main(String[] stringArray) {
        String string = "Digest username=\"john\", realm=\"myrealm\", nonce=\"123456\", response=\"abcdef\", uri=\"/private\", qop=\"auth\"";
        if (string != null && string.startsWith("Digest ")) {
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            Map<String, String> map = DigestAuth_1.parseAuthHeader(string);
            String string7 = map.get("username");
            if (DigestAuth_1.verifyCredentials(string7, string6 = map.get("realm"), string5 = map.get("nonce"), string4 = map.get("response"), string3 = map.get("uri"), string2 = map.get("qop"))) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }
        }
    }

    private static Map<String, String> parseAuthHeader(String string) {
        String[] stringArray;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (String string2 : stringArray = string.substring(7).split(", ")) {
            String[] stringArray2 = string2.split("=");
            hashMap.put(stringArray2[0].trim(), stringArray2[1].trim().replaceAll("\"", ""));
        }
        return hashMap;
    }

    private static boolean verifyCredentials(String string, String string2, String string3, String string4, String string5, String string6) {
        return true;
    }
}
