import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.StringReader;

public class Main_691_691 {
    public static void main(String[] args) {
        String s = "Happy &amp; Sad";
        System.out.println(s);

        StringReader reader = new StringReader(s);
        HTMLEditorKit.Parser parser = new ParserDelegator();
        final StringBuilder sb = new StringBuilder();
        parser.parse(reader, new HTMLEditorKit.ParserCallback() {
            @Override
            public void handleText(char[] data, int pos) {
                sb.append(data);
            }
        }, true);
        System.out.println(sb.toString());
    }
}