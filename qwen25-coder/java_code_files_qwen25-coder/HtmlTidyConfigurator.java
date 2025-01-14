import java.lang.String;
import org.w3c.tidy.Tidy;

public class HtmlTidyConfigurator {
    Tidy tidy = new Tidy();
    {
        tidy.setIndentCdata(false);
        tidy.setPrintBodyOnly(true);
        tidy.setXHTML(true);
        tidy.setQuoteAmpersand(true);
        tidy.setBreakBeforeBR(false);
    }

    public static void main(String[] args) {
    }
}