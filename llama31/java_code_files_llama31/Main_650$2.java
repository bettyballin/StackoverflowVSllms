/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.ActionEvent;
import javax.swing.Action;

static class Main_650.2
implements Runnable {
    final /* synthetic */ Action val$action;

    Main_650.2(Action action) {
        this.val$action = action;
    }

    @Override
    public void run() {
        this.val$action.actionPerformed(new ActionEvent(this, 1001, null));
    }
}
