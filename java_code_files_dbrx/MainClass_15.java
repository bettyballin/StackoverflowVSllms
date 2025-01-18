import java.text.DecimalFormat;
import java.text.ParseException;

public class MainClass {
    public boolean isANumber(String s) {
        DecimalFormat df = new DecimalFormat("###,##0"); // adjust the pattern to your needs
        try {
            Object o = df.parseObject(s);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}