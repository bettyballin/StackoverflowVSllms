import java.lang.String;
import java.lang.Set;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

public class SelectorThread {
    private Selector selector;

    public SelectorThread() throws Exception {
        selector = Selector.open();
    }

    public void run() {
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;

            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isReadable()) {
                    // read and do something
                }

                keyIterator.remove();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SelectorThread selectorThread = new SelectorThread();
        selectorThread.run();
    }
}