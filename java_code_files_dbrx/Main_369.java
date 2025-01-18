public class Main {
    public static void main(String[] args) {
        TextView myTextView = findViewById(R.id.my_textview); // Replace with appropriate id for your view
        String htmlText = "<h1>Hello World!</h1><p>This is a simple HTML text.</p>";
        myTextView.setText(HtmlCompat.fromHtml(htmlText, HtmlCompat.FROM_HTML_MODE_LEGACY)); // or use FROM_HTML_MODE_COMPACT for compacted output
    }

    // Simulate the findViewById method
    public static TextView findViewById(int id) {
        return new TextView();
    }
}

// Simulate the TextView class
class TextView {
    public void setText(String text) {
        System.out.println(text);
    }
}

// Simulate the R.id class
class R {
    public static class id {
        public static int my_textview = 1; // Replace with appropriate id for your view
    }
}

// Simulate the HtmlCompat class
class HtmlCompat {
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_MODE_COMPACT = 1;

    public static String fromHtml(String source, int mode) {
        // Simplified implementation
        return source;
    }
}