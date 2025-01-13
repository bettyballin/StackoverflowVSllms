/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JTextPane;

public class HtmlTextPaneBuilder {
    private JTextPane textPane;
    private String htmlContent;

    public HtmlTextPaneBuilder(String string) {
        this.htmlContent = string;
        this.textPane = new JTextPane();
        this.textPane.setContentType("text/html");
        this.textPane.setText(string);
    }

    public static void main(String[] stringArray) {
        String string = "<html><body>Hello, World!</body></html>";
        HtmlTextPaneBuilder htmlTextPaneBuilder = new HtmlTextPaneBuilder(string);
    }
}
