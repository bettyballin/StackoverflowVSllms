/*
 * Decompiled with CFR 0.152.
 */
public class SecureExample {
    private String sensitiveData;

    public SecureExample(String string) {
        this.sensitiveData = string;
    }

    public String getPublicData() {
        return "Public Data";
    }

    public String getSensitiveData() {
        return this.sensitiveData.substring(0, 4) + "****";
    }

    public static void main(String[] stringArray) {
    }
}
