import java.lang.String;
public class DelimitedStringPrinter {
    String delimiter = "|";
    String textItems = "item1" + delimiter + "item2" + delimiter + "item3";

    {
        System.out.println(textItems);
    }

    public static void main(String[] args) {
        new DelimitedStringPrinter();
    }
}