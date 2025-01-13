public class Main_13 {
    public static String sanitize(String input) {
        return input.trim().replaceAll("<.*?>", "");
    }

    public static void main(String[] args) {
        System.out.println(sanitize("   Hello, <b>world!</b>   "));
    }
}