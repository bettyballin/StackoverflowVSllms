import java.lang.String;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class XmlReplacingProxy {

    private static final int PORT = 8080; // Proxy port to listen on
    private static final String TARGET_HOST = "localhost"; // Host of the target server
    private static final int TARGET_PORT = 7070; // Port of the target server

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ByteArrayEncoder()); // To write out byte arrays
                            pipeline.addLast(new XmlReplacingCodecHandler());
                        }
                    });

            b.bind(PORT).sync().channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    static class XmlReplacingCodecHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            // Establish a connection to the target server when the proxy receives an active connection.
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(ctx.channel().eventLoop())
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // Setup a channel pipeline for the client-server communication that replaces xml data.
                            ch.pipeline().addLast(new XmlReplacingHandler(ctx.channel()));
                        }
                    })
                    .connect(TARGET_HOST, TARGET_PORT).addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    ctx.channel().writeAndFlush(Unpooled.EMPTY_BUFFER);
                } else {
                    ctx.close();
                }
            });
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            // Forward any incoming messages to the client-server pair.
            ctx.fireChannelRead(msg);
        }
    }

    static class XmlReplacingHandler extends ChannelInboundHandlerAdapter {

        private final Channel proxyClientChannel;  // Client (source) side of the Proxy - target server's side is 'this'.

        public XmlReplacingHandler(Channel remoteTargetServerChannel) {
            this.proxyClientChannel = remoteTargetServerChannel;
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;

            byte[] bytes = new byte[buf.readableBytes()];
            buf.readBytes(bytes);

            // Example modification: Replace some text in the XML stream. This is a naive XML processing example!
            String xmlString = new String(bytes);
            xmlString = xmlString.replace("oldText", "newText");

            ByteBuf outboundMessage = ctx.alloc().buffer();
            outboundMessage.writeBytes(xmlString.getBytes());

            // Forward the modified data to its destination
            proxyClientChannel.writeAndFlush(outboundMessage);

            buf.release();  // Release the buffer once done.
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }
}