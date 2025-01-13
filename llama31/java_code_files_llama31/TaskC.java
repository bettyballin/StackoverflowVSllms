/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

class TaskC
implements Callable<String> {
    TaskC() {
    }

    @Override
    public String call() {
        return "Result C";
    }
}
