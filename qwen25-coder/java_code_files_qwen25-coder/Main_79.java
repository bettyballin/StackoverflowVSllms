import javax.swing.text.html.*;
import javax.swing.text.*;
import java.io.*;

public class Main_79 {
    public static void main(String[] args) throws Exception {
        String html = "<html><body><div>Hello World</div></body></html>";
        StringReader reader = new StringReader(html);

        HTMLEditorKit.Parser parser = new HTMLEditorKit().getParser();

        final StringBuilder sb = new StringBuilder();

        parser.parse(reader, new HTMLEditorKit.ParserCallback() {
            private boolean isDiv = false;

            @Override
            public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
                if (tag == HTML.Tag.DIV) {
                    isDiv = true;
                }
            }

            @Override
            public void handleEndTag(HTML.Tag tag, int position) {
                if (tag == HTML.Tag.DIV) {
                    isDiv = false;
                }
            }

            @Override
            public void handleText(char[] data, int position) {
                if (isDiv) {
                    sb.append(data);
                }
            }
        }, true);

        String result = sb.toString();

        System.out.println(result); // Output: Hello World
    }
}