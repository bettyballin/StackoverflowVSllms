import org.w3c.tidy.Tidy;

public class TidyConfigurator {
    public static void main(String[] args) {
        Tidy tidy = new Tidy();
        tidy.setOutputXml(true);
    }
}