/*
 * Decompiled with CFR 0.152.
 */
public class BoundedStack<T> {
    private final T[] buffer;
    private int head;
    private int size;

    public BoundedStack(int n) {
        this.buffer = new Object[n];
        this.head = 0;
        this.size = 0;
    }

    public void push(T t) {
        if (this.size == this.buffer.length) {
            this.head = (this.head + 1) % this.buffer.length;
            --this.size;
        }
        this.buffer[(this.head + this.size) % this.buffer.length] = t;
        ++this.size;
    }

    public T pop() {
        if (this.size == 0) {
            return null;
        }
        T t = this.buffer[(this.head + this.size - 1) % this.buffer.length];
        --this.size;
        return t;
    }

    public static void main(String[] stringArray) {
    }
}
