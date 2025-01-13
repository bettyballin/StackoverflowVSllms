/*
 * Decompiled with CFR 0.152.
 */
import sun.misc.Signal;
import sun.misc.SignalHandler;

static class SignalHandlerExample.1
implements SignalHandler {
    SignalHandlerExample.1() {
    }

    @Override
    public void handle(Signal signal) {
        System.out.println("Received SIGINT signal");
    }
}
