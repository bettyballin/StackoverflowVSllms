/*
 * Decompiled with CFR 0.152.
 */
public class Monitor {
    private int varX;
    private boolean occupied = false;

    public synchronized void taskA() {
        while (this.occupied) {
            try {
                this.wait();
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        this.occupied = true;
        this.occupied = false;
        this.notifyAll();
    }

    public synchronized void taskB() {
        while (this.occupied) {
            try {
                this.wait();
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        this.occupied = true;
        this.occupied = false;
        this.notifyAll();
    }

    public static void main(String[] stringArray) {
        Monitor monitor = new Monitor();
    }
}
