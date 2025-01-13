import javax.swing.JTextPane;

public class HtmlTextPaneBuilder {
    private JTextPane textPane;
    private String htmlContent;

    public HtmlTextPaneBuilder(String htmlContent) {
        this.htmlContent = htmlContent;
        this.textPane = new JTextPane();
        this.textPane.setContentType("text/html");
        this.textPane.setText(htmlContent);
    }

    public static void main(String[] args) {
        String htmlContent = "<html><body>Hello, World!</body></html>";
        HtmlTextPaneBuilder builder = new HtmlTextPaneBuilder(htmlContent);
    }
}