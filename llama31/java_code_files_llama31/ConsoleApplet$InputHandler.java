/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

private class ConsoleApplet.InputHandler
implements ActionListener {
    private ConsoleApplet.InputHandler() {
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = ConsoleApplet.this.input.getText();
        ConsoleApplet.this.output.append(string + "\n");
        ConsoleApplet.this.input.setText("");
    }
}
