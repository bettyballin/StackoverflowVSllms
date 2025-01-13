/*
 * Decompiled with CFR 0.152.
 */
class TaskObject {
    private State state;

    TaskObject() {
    }

    public State executeStep() {
        return State.DONE;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
