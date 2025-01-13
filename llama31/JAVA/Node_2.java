import java.lang.String;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Node_2_2 {
  public static void main(String[] args) throws InterruptedException {
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap.group(group)
        .channel(NioSocketChannel.class)
        .handler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new MessageHandler());
          }
        });
      ChannelFuture future = bootstrap.connect("localhost", 8080).sync();
      future.channel().closeFuture().sync();
    } finally {
      group.shutdownGracefully();
    }
  }
}

class MessageHandler extends io.netty.channel.ChannelInboundHandlerAdapter {
  // You need to implement the MessageHandler class
  // This is just a placeholder to make the code compile
  @Override
  public void channelRead(io.netty.channel.ChannelHandlerContext ctx, Object msg) {
    System.out.println(msg);
  }
}