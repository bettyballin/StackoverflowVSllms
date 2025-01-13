/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.util.concurrent.LinkedBlockingQueue;

public class Triplet {
    public SelectableChannel channel;
    public ComponentSocketBasis socketBasis;
    public int ops;

    public Triplet(SelectableChannel selectableChannel, ComponentSocketBasis componentSocketBasis, int n) {
        this.channel = selectableChannel;
        this.socketBasis = componentSocketBasis;
        this.ops = n;
    }

    public static void main(String[] stringArray) throws InterruptedException, IOException {
        LinkedBlockingQueue<Triplet> linkedBlockingQueue = new LinkedBlockingQueue<Triplet>();
        SelectableChannel selectableChannel = null;
        ComponentSocketBasis componentSocketBasis = new ComponentSocketBasis();
        int n = 0;
        linkedBlockingQueue.add(new Triplet(selectableChannel, componentSocketBasis, n));
        Triplet triplet = (Triplet)linkedBlockingQueue.take();
        SelectableChannel selectableChannel2 = triplet.channel;
        ComponentSocketBasis componentSocketBasis2 = triplet.socketBasis;
        int n2 = triplet.ops;
        System.out.println("Channel: " + String.valueOf(selectableChannel2));
        System.out.println("Socket Basis: " + String.valueOf(componentSocketBasis2));
        System.out.println("Ops: " + n2);
    }
}
