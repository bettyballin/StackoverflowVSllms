/*
 * Decompiled with CFR 0.152.
 */
public class RingBuffer<T> {
    private final T[] buffer;
    private int head;
    private int tail;
    private int size;

    public RingBuffer(int n) {
        this.buffer = new Object[n];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void add(T t) {
        this.buffer[this.head] = t;
        this.head = (this.head + 1) % this.buffer.length;
        if (this.size == this.buffer.length) {
            this.tail = (this.tail + 1) % this.buffer.length;
        } else {
            ++this.size;
        }
    }

    public T remove() {
        T t = this.buffer[this.tail];
        this.buffer[this.tail] = null;
        this.tail = (this.tail + 1) % this.buffer.length;
        --this.size;
        return t;
    }

    public static void main(String[] stringArray) {
    }
}
