import java.io.IOException;

public class SafeJspWriterUsage {

    public static void main(String[] args) {
        JspWriter out = getOut();
        String text = null;

        try {
            out.print(text); // Outputs: null
            // out.write(text); // This would throw NullPointerException
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static JspWriter getOut() {
        return new JspWriter();
    }
}

class JspWriter {
    public void print(String s) throws IOException {
        System.out.println(String.valueOf(s));
    }

    public void write(String s) throws IOException {
        if (s == null) throw new NullPointerException();
        System.out.println(s);
    }
}