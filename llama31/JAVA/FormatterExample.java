import java.lang.String;

public class FormatterExample {
    String template = "%02d";
    String result = String.format(template, 5);

    public static void main(String[] args) {
        FormatterExample formatterExample = new FormatterExample();
        System.out.println(formatterExample.result);
    }
}