import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OptionPrinterTag {
    private List<Object> option;

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (option != null) {
            for (Object o : option) {
                out.print(o.toString()); // Corrected line to print each element
            }
        } else {
            out.print("No options available"); // Optional: handle case where the list is not set
        }
    }

    public static void main(String[] args) {
        // Test code
        OptionPrinterTag tag = new OptionPrinterTag();
        tag.option = List.of("Option1", "Option2", "Option3");
        try {
            tag.doTag();
        } catch (JspException | IOException e) {
            e.printStackTrace();
        }
    }

    // Simulating JspException
    public static class JspException extends Exception {
        public JspException() {
            super();
        }

        public JspException(String message) {
            super(message);
        }
    }

    // Simulating JspWriter
    public static class JspWriter {
        private PrintWriter writer;

        public JspWriter(PrintWriter writer) {
            this.writer = writer;
        }

        public void print(String s) throws IOException {
            writer.print(s);
            writer.flush();
        }
    }

    // Simulating JspContext
    public JspContext getJspContext() {
        return new JspContext();
    }

    public class JspContext {
        public JspWriter getOut() {
            return new JspWriter(new PrintWriter(System.out, true));
        }
    }

}