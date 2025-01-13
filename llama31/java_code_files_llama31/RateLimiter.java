/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;

class RateLimiter {
    private final int maxBytesPerSecond;
    private final int bufferSize;
    private final InputStream in;
    private long lastReadTime;
    private int bytesRemaining;

    public RateLimiter(int n, int n2, InputStream inputStream) {
        this.maxBytesPerSecond = n;
        this.bufferSize = n2;
        this.in = inputStream;
        this.lastReadTime = System.currentTimeMillis();
        this.bytesRemaining = n;
    }

    public int read(byte[] byArray) throws IOException {
        long l = System.currentTimeMillis();
        long l2 = l - this.lastReadTime;
        if (l2 > 1000L) {
            this.bytesRemaining = this.maxBytesPerSecond;
            this.lastReadTime = l;
        } else {
            this.bytesRemaining = (int)((long)this.bytesRemaining + l2 * (long)this.maxBytesPerSecond / 1000L);
            if (this.bytesRemaining > this.maxBytesPerSecond) {
                this.bytesRemaining = this.maxBytesPerSecond;
            }
        }
        int n = this.in.read(byArray, 0, Math.min(this.bufferSize, this.bytesRemaining));
        if (n != -1) {
            this.bytesRemaining -= n;
        }
        return n;
    }
}
