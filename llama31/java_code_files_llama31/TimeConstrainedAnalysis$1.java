/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

static class TimeConstrainedAnalysis.1
implements Callable<String> {
    TimeConstrainedAnalysis.1() {
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(15000L);
        return "Analysis result";
    }
}
