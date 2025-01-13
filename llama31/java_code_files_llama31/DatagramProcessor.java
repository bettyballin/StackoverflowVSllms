/*
 * Decompiled with CFR 0.152.
 */
import java.net.DatagramPacket;

class DatagramProcessor
implements Runnable {
    private DatagramPacket packet;

    public DatagramProcessor(DatagramPacket datagramPacket) {
        this.packet = datagramPacket;
    }

    @Override
    public void run() {
    }
}
