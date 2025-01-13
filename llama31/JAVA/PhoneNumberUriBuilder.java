public class PhoneNumberUriBuilder {
    String address;
    String phoneNumber;

    public PhoneNumberUriBuilder(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.address = "mms://" + phoneNumber;
    }

    public static void main(String[] args) {
        PhoneNumberUriBuilder builder = new PhoneNumberUriBuilder("1234567890");
        System.out.println(builder.address);
    }
}