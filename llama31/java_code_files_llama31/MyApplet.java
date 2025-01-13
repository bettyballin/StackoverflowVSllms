/*
 * Decompiled with CFR 0.152.
 */
import java.applet.Applet;
import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class MyApplet
extends Applet {
    @Override
    public void init() {
        File file = new File("kb1.xml");
        PrivilegedAction<Void> privilegedAction = new PrivilegedAction<Void>(this){

            @Override
            public Void run() {
                return null;
            }
        };
        AccessController.doPrivileged(privilegedAction);
    }

    public static void main(String[] stringArray) {
    }
}
