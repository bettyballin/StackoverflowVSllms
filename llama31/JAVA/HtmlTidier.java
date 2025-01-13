import org.w3c.tidy.Tidy;

public class HtmlTidier {
    public static void main(String[] args) {
        Tidy tidy = new Tidy();
        tidy.setSpaces(false);
    }
}