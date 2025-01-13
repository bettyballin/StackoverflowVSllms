/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class DataPanel.2
extends KeyAdapter {
    DataPanel.2() {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        DataPanel.this.validateField2();
    }
}
