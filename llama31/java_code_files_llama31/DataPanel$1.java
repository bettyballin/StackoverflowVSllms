/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class DataPanel.1
extends KeyAdapter {
    DataPanel.1() {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        DataPanel.this.validateField1();
    }
}
