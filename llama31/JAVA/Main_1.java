public class Main_1 {
    public static void main(String[] args) {
        String timestamp = "your_timestamp_here";
        String signature = "your_signature_here";
        String token = timestamp + ":" + signature;
        System.out.println(token);
    }
}