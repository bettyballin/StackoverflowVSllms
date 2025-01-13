/*
 * Decompiled with CFR 0.152.
 */
static class Scheduler.1 {
    static final /* synthetic */ int[] $SwitchMap$State;

    static {
        $SwitchMap$State = new int[State.values().length];
        try {
            Scheduler.1.$SwitchMap$State[State.READY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Scheduler.1.$SwitchMap$State[State.WAITING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Scheduler.1.$SwitchMap$State[State.DONE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
