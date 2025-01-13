import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Main_98_98 {
    public static void main(String[] args) throws Exception {
        String str = "835,111.2";
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        Number number = format.parse(str);
        BigDecimal bd = new BigDecimal(number.toString());
        System.out.println(bd);
    }
}