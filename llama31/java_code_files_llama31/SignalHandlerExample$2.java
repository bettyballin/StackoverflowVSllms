/*
 * Decompiled with CFR 0.152.
 */
import sun.misc.Signal;
import sun.misc.SignalHandler;

static class SignalHandlerExample.2
implements SignalHandler {
    SignalHandlerExample.2() {
    }

    @Override
    public void handle(Signal signal) {
        System.out.println("Received SIGKILL signal");
    }
}
