import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.util.Iterator;

public class MultiplexInputStreams {
    public static void main(String[] args) throws IOException {
        // Create a selector
        Selector selector = Selector.open();

        // Create channels for each input stream
        ReadableByteChannel channel1 = Channels.newChannel(System.in);
        ReadableByteChannel channel2 = Channels.newChannel(System.err);

        // Register the channels with the selector
        channel1.register(selector, SelectionKey.OP_READ);
        channel2.register(selector, SelectionKey.OP_READ);

        // Create a buffer to read into
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            // Select the ready channels
            selector.select();

            // Iterate over the selected keys
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                iter.remove();

                // Check if the channel is ready to read
                if (key.isReadable()) {
                    // Read from the channel
                    ReadableByteChannel channel = (ReadableByteChannel) key.channel();
                    int bytesRead = channel.read(buffer);
                    if (bytesRead == -1) {
                        // Handle end-of-stream
                        System.out.println("End of stream reached");
                        channel.close();
                    } else {
                        // Handle the read data
                        System.out.println("Read " + bytesRead + " bytes");
                        buffer.flip();
                        // Process the data...
                        buffer.clear();
                    }
                }
            }
        }
    }
}