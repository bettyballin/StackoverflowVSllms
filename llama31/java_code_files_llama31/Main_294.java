/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Main_294 {
    public static void main(String[] stringArray) throws InterruptedException, IOException {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8000));
        ComponentSocketBasis componentSocketBasis = new ComponentSocketBasis();
        int n = 0;
        arrayList.add(serverSocketChannel);
        arrayList.add(componentSocketBasis);
        arrayList.add(n);
        linkedBlockingQueue.add(arrayList);
        List list = (List)linkedBlockingQueue.take();
        SelectableChannel selectableChannel = (SelectableChannel)list.get(0);
        ComponentSocketBasis componentSocketBasis2 = (ComponentSocketBasis)list.get(1);
        int n2 = (Integer)list.get(2);
        selectableChannel.close();
    }
}
