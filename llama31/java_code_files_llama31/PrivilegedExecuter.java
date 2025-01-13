/*
 * Decompiled with CFR 0.152.
 */
import java.security.AccessController;
import java.security.PrivilegedAction;

public class PrivilegedExecuter {
    private final Object target;

    public PrivilegedExecuter(Object object) {
        this.target = object;
    }

    public void executeMethod(final String string, final Object ... objectArray) {
        AccessController.doPrivileged(new PrivilegedAction<Void>(){

            @Override
            public Void run() {
                try {
                    PrivilegedExecuter.this.target.getClass().getMethod(string, new Class[0]).invoke(PrivilegedExecuter.this.target, objectArray);
                }
                catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
                return null;
            }
        });
    }

    public static void main(String[] stringArray) {
    }
}
