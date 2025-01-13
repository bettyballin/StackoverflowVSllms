import java.lang.String;

public class BorderRestorer {
    public static void main(String[] args) {
        // create an instance of BorderRestorer
        BorderRestorer restorer = new BorderRestorer();
        // assume 'input' is a variable of a class that has getBorder() and setBorder() methods
        // for demonstration purposes, let's assume it's a class named 'InputElement'
        InputElement input = new InputElement();
        restorer.restoreBorder(input);
    }

    public void restoreBorder(InputElement input) {
        Border originalBorder = input.getBorder();
        // ... later on ...
        input.setBorder(originalBorder);
    }
}

// for demonstration purposes, let's assume 'InputElement' and 'Border' classes exist
class InputElement {
    private Border border;

    public Border getBorder() {
        return border;
    }

    public void setBorder(Border border) {
        this.border = border;
    }
}

class Border {
    // assume some implementation
}