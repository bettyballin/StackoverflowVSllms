public class StringFormatter_1_1 {
    public static void main(String[] args) {
        StringFormatter_1 formatter = new StringFormatter_1();
        formatter.template = "%02d";
        formatter.result = String.format(formatter.template, 5);
        System.out.println(formatter.result);
    }
    String template;
    String result;
}