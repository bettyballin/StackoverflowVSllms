/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

class TaskB
implements Callable<String> {
    TaskB() {
    }

    @Override
    public String call() {
        return "Result B";
    }
}
