public class Main_400 {
    public static void main(String[] args) {
        String s = "example";
        int result = calculate(s);
        System.out.println(result);
    }

    public static int calculate(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            result = result * 31 + c;
        }
        return result;
    }
}