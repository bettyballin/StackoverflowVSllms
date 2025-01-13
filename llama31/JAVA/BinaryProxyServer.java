import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.CharsetUtil;

import java.nio.charset.StandardCharsets;

public class BinaryProxyServer {

    private final int port;

    public BinaryProxyServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) {
                            ch.pipeline().addLast(new HttpRequestHandler());
                        }
                    });
            ChannelFuture f = b.bind(port).sync();
            System.out.println("Proxy server started on port " + port);
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private static class HttpRequestHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            if (msg instanceof FullHttpRequest) {
                FullHttpRequest request = (FullHttpRequest) msg;
                ByteBuf content = request.content();
                String xmlContent = content.toString(CharsetUtil.UTF_8);
                // Assuming you want to replace <oldTag> with <newTag>
                String newContent = xmlContent.replace("<oldTag>", "<newTag>");
                ByteBuf newBuffer = Unpooled.copiedBuffer(newContent, StandardCharsets.UTF_8);

                FullHttpResponse response = new DefaultFullHttpResponse(request.protocolVersion(), HttpResponseStatus.OK, newBuffer);
                ctx.writeAndFlush(response);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BinaryProxyServer server = new BinaryProxyServer(8080);
        server.start();
    }
}