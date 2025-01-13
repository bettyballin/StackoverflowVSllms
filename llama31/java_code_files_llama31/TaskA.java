/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

class TaskA
implements Callable<String> {
    TaskA() {
    }

    @Override
    public String call() {
        return "Result A";
    }
}
