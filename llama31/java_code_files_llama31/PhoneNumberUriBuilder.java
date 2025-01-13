/*
 * Decompiled with CFR 0.152.
 */
public class PhoneNumberUriBuilder {
    String address;
    String phoneNumber;

    public PhoneNumberUriBuilder(String string) {
        this.phoneNumber = string;
        this.address = "mms://" + string;
    }

    public static void main(String[] stringArray) {
        PhoneNumberUriBuilder phoneNumberUriBuilder = new PhoneNumberUriBuilder("1234567890");
        System.out.println(phoneNumberUriBuilder.address);
    }
}
