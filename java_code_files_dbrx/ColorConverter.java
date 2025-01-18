import java.awt.Color;

public class ColorConverter {
    ColorDialog colorDialog1 = new ColorDialog();
    Color colorDialog1Color = colorDialog1.getColor();
    int result = (colorDialog1Color.getAlpha() << 24) |
                 (colorDialog1Color.getRed()   << 16) |
                 (colorDialog1Color.getGreen() << 8)  |
                  colorDialog1Color.getBlue();

    public static void main(String[] args) {
    }
}

class ColorDialog {
    public Color getColor() {
        return new Color(0, 0, 0, 0);
    }
}