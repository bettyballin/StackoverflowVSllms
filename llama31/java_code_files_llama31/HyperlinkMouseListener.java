/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class HyperlinkMouseListener {
    public HyperlinkMouseListener(final JTextComponent jTextComponent) {
        jTextComponent.addMouseListener(new MouseAdapter(this){

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int n = jTextComponent.viewToModel(mouseEvent.getPoint());
                if (n != -1) {
                    try {
                        int n2 = jTextComponent.getDocument().getText(0, n).lastIndexOf(91);
                        int n3 = jTextComponent.getDocument().getText(n, jTextComponent.getDocument().getLength() - n).indexOf(93);
                        if (n2 != -1 && n3 != -1) {
                            String string = jTextComponent.getDocument().getText(n2 + 1, n3 - 1);
                            Desktop.getDesktop().browse(new URI(string));
                        }
                    }
                    catch (Exception exception) {
                        System.out.println("An error occurred: " + exception.getMessage());
                    }
                }
            }
        });
    }

    public static void main(String[] stringArray) {
        JTextArea jTextArea = new JTextArea();
        jTextArea.setText("This is a [http://www.example.com] link.");
        new HyperlinkMouseListener(jTextArea);
    }
}
