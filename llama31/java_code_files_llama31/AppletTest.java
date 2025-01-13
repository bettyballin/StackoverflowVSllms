/*
 * Decompiled with CFR 0.152.
 */
import java.applet.Applet;
import java.awt.Graphics;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppletTest
extends Applet {
    private ScheduledExecutorService executor;

    @Override
    public void init() {
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(this::updateAndRepaint, 0L, 16L, TimeUnit.MILLISECONDS);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawString("Welcome to Java!!", 50, 60);
    }

    private void updateAndRepaint() {
        this.repaint();
    }

    @Override
    public void destroy() {
        this.executor.shutdown();
    }

    public static void main(String[] stringArray) {
    }
}
