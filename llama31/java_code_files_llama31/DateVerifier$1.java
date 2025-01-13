/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

static class DateVerifier.1
extends WindowAdapter {
    DateVerifier.1() {
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
        System.exit(0);
    }
}
