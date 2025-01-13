/*
 * Decompiled with CFR 0.152.
 */
import java.security.PrivilegedAction;

class PrivilegedExecuter.1
implements PrivilegedAction<Void> {
    final /* synthetic */ String val$methodName;
    final /* synthetic */ Object[] val$args;

    PrivilegedExecuter.1() {
        this.val$methodName = string;
        this.val$args = objectArray;
    }

    @Override
    public Void run() {
        try {
            PrivilegedExecuter.this.target.getClass().getMethod(this.val$methodName, new Class[0]).invoke(PrivilegedExecuter.this.target, this.val$args);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return null;
    }
}
