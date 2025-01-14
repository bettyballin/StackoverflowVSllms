import java.lang.String;

public class TextViewInitializer {

    {
        JustifyTextView justifyTextView = findViewById(R.id.justify_text_view);
        justifyTextView.setText("Your long text goes here...");
    }

    public static void main(String[] args) {
        new TextViewInitializer();
    }

    public JustifyTextView findViewById(int id) {
        return new JustifyTextView();
    }
}

class JustifyTextView {
    public void setText(String s) {
        System.out.println("setText called with: " + s);
    }
}

class R {
    public static class id {
        public static final int justify_text_view = 1;
    }
}