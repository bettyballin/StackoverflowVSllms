/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.text.JTextComponent;

class HyperlinkMouseListener.1
extends MouseAdapter {
    final /* synthetic */ JTextComponent val$textComponent;

    HyperlinkMouseListener.1(HyperlinkMouseListener hyperlinkMouseListener, JTextComponent jTextComponent) {
        this.val$textComponent = jTextComponent;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int n = this.val$textComponent.viewToModel(mouseEvent.getPoint());
        if (n != -1) {
            try {
                int n2 = this.val$textComponent.getDocument().getText(0, n).lastIndexOf(91);
                int n3 = this.val$textComponent.getDocument().getText(n, this.val$textComponent.getDocument().getLength() - n).indexOf(93);
                if (n2 != -1 && n3 != -1) {
                    String string = this.val$textComponent.getDocument().getText(n2 + 1, n3 - 1);
                    Desktop.getDesktop().browse(new URI(string));
                }
            }
            catch (Exception exception) {
                System.out.println("An error occurred: " + exception.getMessage());
            }
        }
    }
}
