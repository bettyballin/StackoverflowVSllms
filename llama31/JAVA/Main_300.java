import org.apache.commons.lang3.StringUtils;

public class Main_300 {
    public static void main(String[] args) {
        String text = StringUtils.join(
            new String[] {
                "This is a multiline string.",
                "It can span multiple lines.",
                "No need for concatenation or escaping."
            },
            "\n"
        );

        System.out.println(text);
    }
}