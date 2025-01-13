import java.text.NumberFormat;
import java.util.Locale;

public class Main_96_96 {
    public static void main(String[] args) throws Exception {
        String str = "835,111.2";
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        Number number = format.parse(str);
        double d = number.doubleValue();
        System.out.println(d);
    }
}